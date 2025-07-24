package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.ABaseTable;
import generated.org.springframework.boot.databases.basetables.AChainedBaseTable;
import generated.org.springframework.boot.databases.basetables.BaseTableCommonId;
import org.usvm.api.Engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseTableCommonIdIterator<T> implements Iterator<T> {

    private final ABaseTable<T> table;
    private final Iterator<T> tableIter;

    private final List<Object[]> returnedIds;

    public BaseTableCommonIdIterator(BaseTableCommonId<T> table) {
        this.table = table;
        this.tableIter = table.getTable().iterator();

        this.returnedIds = new ArrayList<>();
    }

    public BaseTableCommonIdIterator(AChainedBaseTable<T> table, Iterator<T> iter) {
        this.table = table;
        this.tableIter = iter;

        this.returnedIds = new ArrayList<>();
    }

    private void ensureId(T t) {
        for (Object[] returnedId : returnedIds) {
            Engine.assume(!table.hasId(returnedId, t));
        }
        Object[] id = table.buildId(t);
        returnedIds.add(id);
    }


    @Override
    public boolean hasNext() {
        return tableIter.hasNext();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T next() {
        Engine.assume(hasNext());

        T t = tableIter.next();
        ensureId(t);

        return t;
    }
}
