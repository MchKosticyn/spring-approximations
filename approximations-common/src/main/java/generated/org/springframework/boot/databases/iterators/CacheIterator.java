package generated.org.springframework.boot.databases.iterators;

import generated.org.springframework.boot.databases.CacheTable;
import org.usvm.api.Engine;

import java.util.Iterator;

public class CacheIterator<T> implements Iterator<T> {

    private int ix;

    private final CacheTable<T> table;
    private final Iterator<T> tableIter;

    public CacheIterator(CacheTable<T> table) {
        this.ix = 0;
        this.table = table;
        this.tableIter = table.getTableIter();
    }

    @Override
    public boolean hasNext() {
        return tableIter.hasNext();
    }

    @Override
    public T next() {
        Engine.assume(hasNext());
        return table.getElement(ix++);
    }
}
