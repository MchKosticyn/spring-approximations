package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTableDelete;
import org.usvm.api.Engine;

import java.util.Iterator;

public class BaseTableDeleteIterator<T> implements Iterator<T> {

    private final BaseTableDelete<T> table;
    private final Iterator<T> tblIter;
    private T removed;

    private T curr;

    public BaseTableDeleteIterator(BaseTableDelete<T> table) {
        this.table = table;
        this.tblIter = table.getTable().iterator();
        this.removed = table.getRemoved();
        this.curr = null;
    }

    @Override
    public boolean hasNext() {
        if (curr != null) return true;
        if (!tblIter.hasNext()) return false;

        curr = tblIter.next();
        if (removed != null && table.isSameId(curr, removed)) {
            removed = null;
            curr = null;
            return hasNext();
        }

        return true;
    }

    @Override
    public T next() {
        Engine.assume(hasNext());

        T tmp = curr;
        curr = null;

        return tmp;
    }
}
