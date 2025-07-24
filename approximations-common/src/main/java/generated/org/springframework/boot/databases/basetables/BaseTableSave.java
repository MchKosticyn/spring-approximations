package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableSaveIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class BaseTableSave<T> extends AChainedBaseTable<T> {

    private final T saved;

    public BaseTableSave(ABaseTable<T> table, T saved) {
        this.table = table;
        this.saved = saved;
    }

    public T getSaved() {
        return saved;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BaseTableSaveIterator<>(this);
    }
}
