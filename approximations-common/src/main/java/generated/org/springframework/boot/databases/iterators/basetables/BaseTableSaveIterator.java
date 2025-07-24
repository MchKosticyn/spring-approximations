package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTableSave;
import org.usvm.api.Engine;

import java.util.Iterator;

public class BaseTableSaveIterator<T> implements Iterator<T> {

    private final BaseTableSave<T> table;
    private final Iterator<T> tblIter;
    private T saved;

    public BaseTableSaveIterator(BaseTableSave<T> table) {
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

        T t;
        if (!tblIter.hasNext()) {
            Engine.assume(saved != null);
            t = saved;
            saved = null;
        } else {
            t = tblIter.next();
            if (saved != null && table.isSameId(saved, t)) {
                t = saved;
                saved = null;
            }
        }

        return t;
    }
}
