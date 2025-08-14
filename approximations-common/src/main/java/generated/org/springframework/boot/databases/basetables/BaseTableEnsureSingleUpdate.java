package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableEnsureSingleUpdateIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Consumer;

public class BaseTableEnsureSingleUpdate<T> extends AChainedBaseTable<T> {

    private final Object[] id;
    private final Consumer<T> update;

    public BaseTableEnsureSingleUpdate(ABaseTable<T> table, Object[] id, Consumer<T> update) {
        this.table = table;
        this.id = id;
        this.update = update;
    }

    public Object[] getId() {
        return id;
    }

    public Consumer<T> getUpdate() {
        return update;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BaseTableEnsureSingleUpdateIterator<>(this);
    }
}
