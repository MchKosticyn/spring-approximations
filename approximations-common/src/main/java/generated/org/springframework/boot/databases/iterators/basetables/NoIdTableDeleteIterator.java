package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.NoIdTableDelete;
import org.usvm.api.Engine;

import java.util.Iterator;

public class NoIdTableDeleteIterator implements Iterator<Object[]> {

    private final NoIdTableDelete table;
    private final Iterator<Object[]> tblIter;
    private Object[] deleted;

    private Object[] curr;

    public NoIdTableDeleteIterator(NoIdTableDelete table) {
        this.table = table;
        this.tblIter = table.getTable().iterator();
        this.deleted = table.getDeleted();
        this.curr = null;
    }

    @Override
    public boolean hasNext() {
        if (curr != null) return true;

        if (tblIter.hasNext()) {
            curr = tblIter.next();
            if (deleted != null && table.rowEquals(curr, deleted)) {
                deleted = null;
                curr = null;
                return hasNext();
            }

            return true;
        }

        return false;
    }

    @Override
    public Object[] next() {
        Engine.assume(hasNext());

        Object[] tmp = curr;
        curr = null;

        return tmp;
    }
}
