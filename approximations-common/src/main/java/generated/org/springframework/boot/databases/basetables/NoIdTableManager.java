package generated.org.springframework.boot.databases.basetables;

import org.jetbrains.annotations.NotNull;
import org.usvm.spring.api.SpringEngine;

import java.util.Iterator;
import java.util.function.Function;

public class NoIdTableManager extends ANoIdTable implements ITableManager<Object[]> {

    private ANoIdTable tablesChain;

    private final String tableName;

    public NoIdTableManager(String tableName) {
        this.tableName = tableName;
    }

    private boolean initialized = false;

    public void initialize(Class<?>... columnTypes) {
        if (initialized) return;

        this.tablesChain = new NoIdTable(columnTypes);

        initialized = true;
    }

    private void checkInitialized() {
        if (!initialized) SpringEngine.println("[DB Warning] BaseTableManager is not initialized");
    }

    @Override
    public void applyRangeUpdate(Function<Object[], Boolean> predicate, Function<Object[], Object[]> update) {
        tablesChain = new RangeUpdatedNoIdTable(tablesChain, predicate, update);
    }

    @Override
    public void applyRangeDelete(Function<Object[], Boolean> predicate) {
        tablesChain = new RangeDeletedNoIdTable(tablesChain, predicate);
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
    public int columnCount() {
        return tablesChain.columnCount();
    }

    @Override
    public void save(Object[] row) {
        tablesChain = new NoIdTableSave(tablesChain, row);
    }

    @Override
    public void delete(Object[] row) {
        tablesChain = new NoIdTableDelete(tablesChain, row);
    }

    @Override
    public void deleteAll() {
        tablesChain.deleteAll();
    }
}
