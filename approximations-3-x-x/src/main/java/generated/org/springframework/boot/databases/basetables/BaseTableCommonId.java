package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableCommonIdIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class BaseTableCommonId<V> extends AChainedBaseTable<V> {

    public BaseTableCommonId(ABaseTable<V> table) {
        this.table = table;
    }

    @Override
    public void deleteAll() {
        table.deleteAll();
    }

    @Override
    public int size() {
        Iterator<Object[]> iter = iterator();
        int count = 0;
        while (iter.hasNext()) {
            Object[] ignored = iter.next();
            count++;
        }
        return count;
    }

    @NotNull
    @Override
    public Iterator<Object[]> iterator() {
        return new BaseTableCommonIdIterator<>(this);
    }
}
