package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTablePureSave;
import org.usvm.api.Engine;

import java.util.Iterator;

public class BaseTablePureSaveIterator<T> implements Iterator<T> {

    private final BaseTablePureSave<T> table;
    private final Iterator<T> tblIter;
    private T saved;

    public BaseTablePureSaveIterator(BaseTablePureSave<T> table) {
        this.table = table;
        this.tblIter = table.getTable().iterator();
        this.saved = table.getSaved();
    }

    @Override
    public boolean hasNext() {
        if (tblIter.hasNext()) return true;
        return saved != null;
    }

    @Override
    public T next() {
        Engine.assume(hasNext());

        if (tblIter.hasNext()) {
            T t = tblIter.next();
            Engine.assume(saved != null);
            Engine.assume(!table.isSameId(saved, t));
            return t;
        }

        T tmp = saved;
        saved = null;

        return tmp;
    }
}
