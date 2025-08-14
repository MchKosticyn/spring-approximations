package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.RangeUpdatedTable;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.Function;

public class RangeUpdatedTableIterator<T> implements Iterator<T> {

    private final Iterator<T> tblIter;
    private final Function<T, Boolean> predicate;
    private final Function<T, T> update;

    public RangeUpdatedTableIterator(RangeUpdatedTable<T> table) {
        this.tblIter = table.getTable().iterator();
        this.predicate = table.getPredicate();
        this.update = table.getUpdate();
    }

    @Override
    public boolean hasNext() {
        return tblIter.hasNext();
    }

    @Override
    public T next() {
        Engine.assume(hasNext());

        T t = tblIter.next();
        if (predicate.apply(t)) {
            return update.apply(t);
        }

        return t;
    }
}
