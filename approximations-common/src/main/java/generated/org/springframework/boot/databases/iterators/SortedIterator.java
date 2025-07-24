package generated.org.springframework.boot.databases.iterators;

import generated.org.springframework.boot.databases.SortedTable;
import org.usvm.api.Engine;

import java.util.Iterator;

public class SortedIterator<T, R> implements Iterator<T> {

    private final Object[] sorted;

    private int ix;
    private final int endIx;

    public SortedIterator(SortedTable<T, R> table) {
        this.sorted = table.getSorted();
        this.ix = table.getOffset();
        this.endIx = table.getSize();
    }

    @Override
    public boolean hasNext() {
        return ix < endIx;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T next() {
        Engine.assume(hasNext());
        return (T) sorted[ix++];
    }
}
