package generated.org.springframework.boot.databases.iterators.wrappers;

import generated.org.springframework.boot.databases.wrappers.SetWrapper;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class SetWrapperIterator<T> implements Iterator<T> {

    private final SetWrapper<T> set;
    private final Set<T> cache;
    private final Iterator<T> tblIter;
    private final Iterator<T> cacheIter;
    private T curr;

    private final int expectedModCount;

    public SetWrapperIterator(SetWrapper<T> set) {
        this.set = set;
        this.cache = set.getCache();
        this.tblIter = set.getTable().iterator();
        for (int i = 0; i < set.getPtr(); i++) {
            tblIter.next();
        }

        this.cacheIter = cache.iterator();
        this.curr = null;
        this.expectedModCount = set.getModCount();
    }

    @Override
    public boolean hasNext() {

        if (curr != null) return true;

        if (cacheIter.hasNext()) {
            T candidate = cacheIter.next();
            if (set.getRemovedCache().contains(candidate)) {
                return hasNext();
            }

            curr = candidate;
            return true;
        }

        if (tblIter.hasNext()) {
            T candidate = tblIter.next();
            if (set.getRemovedCache().contains(candidate) || cache.contains(candidate)) {
                return hasNext();
            }

            curr = candidate;
            return true;
        }

        return false;
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        if (expectedModCount != set.getModCount()) throw new ConcurrentModificationException();

        T tmp = curr;
        curr = null;

        return tmp;
    }
}
