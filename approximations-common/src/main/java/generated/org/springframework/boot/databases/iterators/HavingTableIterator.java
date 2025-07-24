package generated.org.springframework.boot.databases.iterators;

import generated.org.springframework.boot.databases.HavingTable;
import generated.org.springframework.boot.databases.ITable;
import org.usvm.api.Engine;

import java.util.Iterator;

public class HavingTableIterator<T> implements Iterator<ITable<T>> {

    public HavingTable<T> table;
    public Iterator<ITable<T>> iter;

    private ITable<T> curr;

    public HavingTableIterator(HavingTable<T> table) {
        this.table = table;
        this.iter = table.getTable().iterator();
        this.curr = null;
    }

    @Override
    public boolean hasNext() {
        if (curr != null) return true;

        if (iter.hasNext()) {
            curr = iter.next();
            if (table.callPredicate(curr)) return true;

            curr = null;
            return hasNext();
        }

        return false;
    }

    @Override
    public ITable<T> next() {
        Engine.assume(hasNext());

        ITable<T> tmp = curr;
        curr = null;
        return tmp;
    }
}
