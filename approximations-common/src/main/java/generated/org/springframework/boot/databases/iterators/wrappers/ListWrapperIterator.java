package generated.org.springframework.boot.databases.iterators.wrappers;

import generated.org.springframework.boot.databases.wrappers.ListWrapper;
import org.usvm.api.SymbolicList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListWrapperIterator<T> implements Iterator<T> {

    private final ListWrapper<T> list;
    private final SymbolicList<T> cache;

    private int ix;
    private final int count;

    private final int expectedModCount;

    public ListWrapperIterator(ListWrapper<T> list) {
        this.list = list;
        this.cache = list.getCache();
        this.ix = 0;
        this.count = list.getSizeOfCache();
        this.expectedModCount = list.getModCount();
    }

    @Override
    public boolean hasNext() {
        return ix < count;
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        if (expectedModCount != list.getModCount()) throw new ConcurrentModificationException();

        // we are in cached or added part of wrapper
        if (ix <= list.getWrpStartIx() || list.getWrpEndIx() <= ix) cache.get(ix++);

        // we need to cache next element
        // here ix == list.wrpStartIx + 1
        list.cacheNext();

        return cache.get(ix++);
    }
}
