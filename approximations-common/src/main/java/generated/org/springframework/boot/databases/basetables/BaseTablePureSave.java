package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTablePureSaveIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class BaseTablePureSave<T> extends AChainedBaseTable<T> {

    private final T saved;

    public BaseTablePureSave(ABaseTable<T> table, T saved) {
        this.table = table;
        this.saved = saved;
    }

    public T getSaved() {
        return saved;
    }

    @Override
    public int size() {
        return table.size() + 1;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BaseTablePureSaveIterator<>(this);
    }
}
