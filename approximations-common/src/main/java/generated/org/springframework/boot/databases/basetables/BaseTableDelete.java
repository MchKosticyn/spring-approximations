package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableDeleteIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class BaseTableDelete<T> extends AChainedBaseTable<T> {

    private final T removed;

    public BaseTableDelete(ABaseTable<T> table, T removed) {
        this.table = table;
        this.removed = removed;
    }

    public T getRemoved() {
        return removed;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BaseTableDeleteIterator<>(this);
    }
}
