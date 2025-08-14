package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.utils.IteratorWithFilter;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Function;

public class RangeDeletedTable<T> extends AChainedBaseTable<T> {

    private final Function<T, Boolean> predicate;

    public RangeDeletedTable(ABaseTable<T> table, Function<T, Boolean> predicate) {
        this.table = table;
        this.predicate = predicate;
    }

    public Function<T, Boolean> getPredicate() {
        return predicate;
    }

    public Function<T, Boolean> getNegPredicate() {
        return (T t) -> !predicate.apply(t);
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new IteratorWithFilter<>(table.iterator(), getNegPredicate());
    }
}
