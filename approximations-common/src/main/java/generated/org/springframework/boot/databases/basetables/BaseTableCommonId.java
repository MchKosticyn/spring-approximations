package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableCommonIdIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class BaseTableCommonId<T> extends AChainedBaseTable<T> {

    public BaseTableCommonId(ABaseTable<T> table) {
        this.table = table;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BaseTableCommonIdIterator<>(this);
    }
}
