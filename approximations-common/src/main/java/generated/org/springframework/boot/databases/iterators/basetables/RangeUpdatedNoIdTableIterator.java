package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.RangeUpdatedNoIdTable;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.Function;

public class RangeUpdatedNoIdTableIterator implements Iterator<Object[]> {

    private final Iterator<Object[]> tableIter;
    private final Function<Object[], Boolean> predicate;
    private final Function<Object[], Object[]> update;

    public RangeUpdatedNoIdTableIterator(RangeUpdatedNoIdTable table) {
        this.tableIter = table.getTable().iterator();
        this.predicate = table.getPredicate();
        this.update = table.getUpdate();
    }

    @Override
    public boolean hasNext() {
        return tableIter.hasNext();
    }

    @Override
    public Object[] next() {
        Engine.assume(hasNext());

        Object[] row = tableIter.next();
        if (predicate.apply(row)) {
            return update.apply(row);
        }

        return row;
    }
}
