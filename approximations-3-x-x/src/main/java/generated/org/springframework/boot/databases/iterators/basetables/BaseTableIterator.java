package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTable;
import org.usvm.api.Engine;

import java.util.Iterator;

public class BaseTableIterator<T, V> implements Iterator<Object[]> {

    BaseTable<T, V> table;

    int ix;
    int endIx;

    public BaseTableIterator(BaseTable<T, V> table) {
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
    public Object[] next() {
        Engine.assume(hasNext());
        return table.getRowEnsure(nextIndex());
    }
}
