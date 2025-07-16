package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableIterator;
import generated.org.springframework.boot.databases.utils.DatabaseValidators;
import org.hibernate.StatelessSession;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import stub.spring.SpringDatabases;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Supplier;

public class BaseTable<T, V> extends ABaseTable<V> {
    //      row0  row2  --  rowN
    //  col0
    //  col1
    //   --
    //  colM
    public Object[][] data;
    public int size;

    public boolean generatedId;

    public int columnCount;
    public int idIndex;
    public Class<?>[] columnTypes;

    private Supplier<T> blankInit;
    private Function<T, V> getIdFunction;

    public BaseTable(
            int idIndex,
            boolean generatedId,
            Class<?>... columnTypes
    ) {

        this.columnTypes = columnTypes;
        this.columnCount = columnTypes.length;
        this.idIndex = idIndex;
        this.generatedId = generatedId;
        this.size = Engine.makeSymbolicInt();

        // TODO: think about tables with 0 size (execution prioritize 0 size, that leads to nulls by first())
        Engine.assume(size > 0);
        Engine.assume(size <= 10);

        this.data = new Object[columnCount][];

        for (int i = 0; i < columnCount; i++) {
            if (generatedId && i == idIndex) {
                data[i] = (Object[]) Array.newInstance(columnTypes[i], size);
            }
            else {
                data[i] = Engine.makeSymbolicArray(columnTypes[i], size);
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int idColumnIx() {
        return idIndex;
    }

    @Override
    public int columnCount() {
        return columnCount;
    }

    @Override
    public Class<?>[] columnTypes() {
        return columnTypes;
    }

    @Override
    public Class<Object[]> type() {
        return Object[].class;
    }

    @Override
    public void deleteAll() {
        for (int i = 0; i < columnCount; i++) {
            data[i] = Engine.makeSymbolicArray(columnTypes[i], 0);
        }
        this.size = 0;
    }

    public Object[] getRowEnsure(int ix) {
        Engine.assume(ix < size);
        Object[] row = new Object[columnCount];
        for (int i = 0; i < columnCount; i++) {
            if (i == idIndex && generatedId && data[i][ix] == null) {
                data[i][ix] = generateNewId();
            }

            Object v = data[i][ix];

            Function<Object, Boolean> soft = DatabaseValidators.getSoftValidator(columnTypes[i]);
            if (soft != null) Engine.assumeSoft(soft.apply(v));

            row[i] = v;
        }

        return row;
    }

    @NotNull
    @Override
    public Iterator<Object[]> iterator() {
        return new BaseTableIterator<>(this);
    }

    public void setFunctionsGeneratedIdTable(Supplier<T> blankInit, Function<T, V> getIdFunction) {
        this.blankInit = blankInit;
        this.getIdFunction = getIdFunction;
    }

    public V generateNewId() {
        T blankObj = blankInit.get();
        try (StatelessSession s = SpringDatabases.sessionFactory.openStatelessSession()) {
            s.insert(blankObj);
        }

        return getIdFunction.apply(blankObj);
    }
}
