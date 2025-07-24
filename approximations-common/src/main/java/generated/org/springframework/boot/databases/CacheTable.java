package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.CacheIterator;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import org.usvm.spring.api.SpringEngine;

import java.util.Iterator;

public class CacheTable<T> implements ITable<T> {

    private final ITable<T> table;
    private final Iterator<T> tableIter;

    private final SymbolicList<T> cache;
    private int cacheSize;

    public CacheTable(ITable<T> table) {
        this.table = table;
        this.tableIter = table.iterator();

        this.cache = Engine.makeSymbolicList();
        Engine.assume(cache != null);
        Engine.assume(cache.size() == 0);
        this.cacheSize = 0;
    }

    public ITable<T> getTable() {
        return table;
    }

    public Iterator<T> getTableIter() {
        return tableIter;
    }

    private T cacheNext() {
        T next = tableIter.next();
        cache.insert(cacheSize, next);
        cacheSize++;
        return next;
    }

    public T getElement(int ix) {
        if (ix < cacheSize) return cache.get(ix);
        if (ix == cacheSize) return cacheNext();

        // Index must be near to cache or already cached
        SpringEngine.println("[DB Warning] Index to get from cache table are greater that cache size");
        return null;
    }

    @Override
    public T first() {
        Iterator<T> iter = iterator();
        if (iter.hasNext()) return iter.next();
        return null;
    }

    @Override
    public T ensureFirst() {
        Iterator<T> iter = iterator();
        Engine.assume(iter.hasNext());
        return iter.next();
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new CacheIterator<>(this);
    }
}
