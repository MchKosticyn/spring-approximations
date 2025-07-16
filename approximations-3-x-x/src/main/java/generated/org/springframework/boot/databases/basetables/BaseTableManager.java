package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.FiltredTable;
import generated.org.springframework.boot.databases.ITable;
import generated.org.springframework.boot.databases.MappedTable;
import generated.org.springframework.boot.databases.utils.DatabaseValidators;
import jakarta.validation.ConstraintValidator;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Supplier;

public class BaseTableManager<T, V> extends ABaseTable<V> implements ITableManager {

    public BaseTableTrack<T, V> trackTable; // nullable
    public BaseTable<T, V> baseTable;
    public ABaseTable<V> tablesChain;

    public Function<Object[], T> deserializer;

    public Class<V> idColType;
    public boolean isAutoGenerateId;

    public String tableName;
    public Class<T> entityType;

    @SuppressWarnings("unchecked")
    public BaseTableManager(
            int idIndex,
            Class<T> entityType,
            Class<?>[] columnTypes,
            ConstraintValidator<?, ?>[][] validators,
            String tableName,
            boolean isAutoGenerateId, // GeneratedValue annotation set in data-class
            boolean needTrack // true if SpringBootTests option set in WebBench
    ) {
        this.tableName = tableName;
        this.idColType = (Class<V>) columnTypes[idIndex];
        this.isAutoGenerateId = isAutoGenerateId;

        this.baseTable = new BaseTable<>(idIndex, isAutoGenerateId, columnTypes);

        BaseTableCommonId<V> tableWithId = new BaseTableCommonId<>(baseTable);
        BaseTableLambdaValidate<V> validatedIdDefaultValues = new BaseTableLambdaValidate<>(tableWithId);
        BaseTableConstraintValidate<V> validated = new BaseTableConstraintValidate<>(validatedIdDefaultValues, validators);

        if (needTrack) {
            BaseTableTrack<T, V> track = new BaseTableTrack<>(validated, tableName, entityType);
            this.trackTable = track;
            this.tablesChain = track;
        }
        else {
            this.tablesChain = validated;
        }

        this.entityType = entityType;
    }

    public ITable<T> deserialize(ITable<Object[]> table) {
        return new MappedTable<>(table, deserializer, entityType);
    }

    public ITable<T> getRowsWithValueAt(Object value, int ix) {
        Function<Object[], Boolean> filter = (Object[] row) -> row[ix].equals(value);
        ITable<Object[]> rows = new FiltredTable<>(tablesChain, filter);
        return deserialize(rows);
    }

    public ITable<T> getRowsRelatedByTable(
            Object value, // parent id

            // decides view of row in relation table: is [V1; V2] or [V2; V1]
            // 1 means [V2; V1], 0 means [V1; V2]
            int shouldShuffle,
            NoIdTableManager addTable
    ) {
        // take from manytomany table   | p_id | c_id |
        // al rows that p_id == value (given parent id)
        Function<Object[], Boolean> filter = (Object[] row) -> row[shouldShuffle].equals(value);

        // take from this tableChain all rows whose id values
        // are contained in filtered manytomany table
        Function<Object[], T> map = (Object[] row) ->
                getRowsWithValueAt(row[1 - shouldShuffle], idColumnIx()).ensureFirst();

        return new MappedTable<>(
                new FiltredTable<>(
                        addTable,
                        filter
                ),
                map,
                entityType
        );
    }

    public void setDeserializerTrackTable(Function<Object[] , T> deserializer) {
        this.deserializer = deserializer;
        if (trackTable != null) trackTable.setDeserializer(deserializer);
    }

    public void setFunctionsGeneratedIdTable(Supplier<T> blankInit, Function<T, V> getIdFunction) {
        this.baseTable.setFunctionsGeneratedIdTable(blankInit, getIdFunction);
    }

    @Override
    public void applyRangeUpdate(Function<Object[], Boolean> predicate, Function<Object[], Object[]> update) {
        tablesChain = new RangeUpdatedTable<>(tablesChain, predicate, update);
    }

    @Override
    public void applyRangeDelete(Function<Object[], Boolean> predicate) {
        tablesChain = new RangeDeletedTable<>(tablesChain, predicate);
    }

    public void changeSingleFieldByIdEnsure(V id, int pos, Object v) {
        V symbId = symbolizeId(id);
        tablesChain = new BaseTableEnsureSingleUpdate<>(tablesChain, symbId, pos, v);
    }

    public void pureSave(Object[] row) {
        if (isAutoGenerateId) {
            row[idColumnIx()] = baseTable.generateNewId();
        }

        tablesChain = new BaseTablePureSave<>(tablesChain, row);
    }

    @SuppressWarnings({"unchecked", "DataFlowIssue", "ConstantValue"})
    public V symbolizeId(V id) {
        V symbId = (V) Engine.makeSymbolic(tablesChain.columnTypes()[tablesChain.idColumnIx()]);
        Engine.assume(id != null);
        Engine.assume(id.equals(symbId));
        return symbId;
    }

    @Override
    public int columnCount() {
        return tablesChain.columnCount();
    }

    @Override
    public Class<?>[] columnTypes() {
        return tablesChain.columnTypes();
    }

    @Override
    public int idColumnIx() {
        return tablesChain.idColumnIx();
    }

    @Override
    public int size() {
        return tablesChain.size();
    }

    @NotNull
    @Override
    public Iterator<Object[]> iterator() {
        return tablesChain.iterator();
    }

    @Override
    public Class<Object[]> type() {
        return tablesChain.type();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void save(Object[] row) {
        if (isAutoGenerateId && DatabaseValidators.isDefaultValue((V) row[idColumnIx()], tablesChain.idFieldType())) {
            row[idColumnIx()] = baseTable.generateNewId();
        }

        tablesChain = new BaseTableSave<>(tablesChain, row);
    }

    @Override
    public void delete(Object[] row) {
        tablesChain = new BaseTableDelete<>(tablesChain, row);
    }

    @Override
    public void deleteAll() {
        tablesChain.deleteAll();
    }
}
