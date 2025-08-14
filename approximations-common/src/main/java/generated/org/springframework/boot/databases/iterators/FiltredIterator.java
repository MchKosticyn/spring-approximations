package generated.org.springframework.boot.databases.iterators;

import generated.org.springframework.boot.databases.FiltredTable;
import org.usvm.api.Engine;

import java.util.Iterator;

public class FiltredIterator<T> implements Iterator<T> {

    private final FiltredTable<T> filtredTable;
    private final Iterator<T> tblIter;
    private T curr;

    public FiltredIterator(FiltredTable<T> filtredTable) {
        this.filtredTable = filtredTable;
        this.tblIter = filtredTable.getTable().iterator();
        this.curr = null;
    }

    @Override
    public boolean hasNext() {
        if (curr != null) return true;

        while (tblIter.hasNext()) {
            T candidate = tblIter.next();
            if (filtredTable.callFilter(candidate)) {
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
