package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTable;
import org.usvm.api.Engine;

import java.util.ArrayList;
import java.util.Iterator;

public class BaseTableIterator<V> implements Iterator<Object[]> {

    BaseTable<V> table;

    int ix;
    int endIx;

    @SuppressWarnings("unchecked")
    public BaseTableIterator(BaseTable<V> table) {
        this.table = table;

        this.ix = 0;
        this.endIx = table.size();
    }

    private int nextIndex() {
        return ix++;
    }

    private boolean condition() {
        return ix < endIx;
    }

    @Override
    public boolean hasNext() {
        return condition();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object[] next() {
        Engine.assume(hasNext());
        return table.getRowEnsure(nextIndex());
    }
}
