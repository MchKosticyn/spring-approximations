package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTable;
import org.usvm.api.Engine;

import java.util.Iterator;

public class BaseTableIterator<T> implements Iterator<T> {

    private final BaseTable<T> table;

    private int ix;
    private final int endIx;

    public BaseTableIterator(BaseTable<T> table) {
        this.table = table;

        this.ix = 0;
        this.endIx = table.size();
    }

    @Override
    public boolean hasNext() {
        return ix < endIx;
    }

    @Override
    public T next() {
        Engine.assume(hasNext());
        return table.getRowEnsure(ix++);
    }
}
