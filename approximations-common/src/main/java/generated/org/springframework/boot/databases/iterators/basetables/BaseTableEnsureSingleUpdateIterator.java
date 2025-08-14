package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTableEnsureSingleUpdate;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.Consumer;

public class BaseTableEnsureSingleUpdateIterator<T> implements Iterator<T> {

    private final BaseTableEnsureSingleUpdate<T> table;
    private final Iterator<T> tblIter;

    private final Object[] id;
    private Consumer<T> update;

    public BaseTableEnsureSingleUpdateIterator(BaseTableEnsureSingleUpdate<T> table) {
        this.table = table;
        this.tblIter = table.getTable().iterator();

        this.id = table.getId();
        this.update = table.getUpdate();
    }


    @Override
    public boolean hasNext() {
        if (!tblIter.hasNext()) {
            Engine.assume(update == null);
            return false;
        }

        return true;
    }

    @Override
    public T next() {
        Engine.assume(hasNext());

        T next = tblIter.next();

        if (update != null && table.hasId(id, next)) {
            update.accept(next);
            update = null;
            return next;
        }

        return next;
    }
}
