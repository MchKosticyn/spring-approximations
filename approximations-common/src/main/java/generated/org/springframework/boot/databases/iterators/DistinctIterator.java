package generated.org.springframework.boot.databases.iterators;

import generated.org.springframework.boot.databases.ITable;
import org.usvm.api.Engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DistinctIterator<T> implements Iterator<T> {

    private final Iterator<T> tblIter;
    private T curr;

    private final List<T> cache;

    public DistinctIterator(ITable<T> table) {
        this.tblIter = table.iterator();
        this.curr = null;
        this.cache = new ArrayList<>();
    }

    private boolean wasAdded(T t) {
        for (T o : cache)
            if (t.equals(o))
                return true;

        cache.add(t);
        return false;
    }

    @Override
    public boolean hasNext() {
        if (curr != null) return true;

        while (tblIter.hasNext()) {
            T candidate = tblIter.next();
            if (!wasAdded(candidate)) {
                curr = candidate;
                return true;
            }
        }

        return false;
    }

    @Override
    public T next() {
        Engine.assume(hasNext());

        T tmp = curr;
        curr = null;

        return tmp;
    }
}
