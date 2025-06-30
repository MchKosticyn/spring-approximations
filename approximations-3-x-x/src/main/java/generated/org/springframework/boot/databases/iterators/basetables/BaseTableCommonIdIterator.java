package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTableCommonId;
import org.usvm.api.Engine;

import java.util.ArrayList;
import java.util.Iterator;

public class BaseTableCommonIdIterator<V> implements Iterator<Object[]> {

    BaseTableCommonId<V> table;
    Iterator<Object[]> tableIter;

    ArrayList<V> returnedIds;

    public BaseTableCommonIdIterator(BaseTableCommonId<V> table) {
        this.table = table;
        this.tableIter = table.table.iterator();

        returnedIds = new ArrayList<>();
    }

    private void ensureId(V id) {
        for (int i = 0; i < returnedIds.size(); i++) Engine.assume(!returnedIds.get(i).equals(id));
        returnedIds.add(id);
    }


    @Override
    public boolean hasNext() {
        return tableIter.hasNext();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object[] next() {
        Engine.assume(hasNext());

        Object[] row = tableIter.next();
        ensureId((V) row[table.idColumnIx()]);

        return row;
    }
}
