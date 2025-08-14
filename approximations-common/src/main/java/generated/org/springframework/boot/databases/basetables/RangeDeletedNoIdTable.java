package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.utils.IteratorWithFilter;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Function;

public class RangeDeletedNoIdTable extends AChainedNoIdTable {

    private final Function<Object[], Boolean> predicate;

    public RangeDeletedNoIdTable(ANoIdTable table, Function<Object[], Boolean> predicate) {
        this.table = table;
        this.predicate = predicate;
    }

    public Function<Object[], Boolean> getPredicate() {
        return predicate;
    }

    public Function<Object[], Boolean> getNegPredicate() {
        return (Object[] row) -> !predicate.apply(row);
    }

    @NotNull
    @Override
    public Iterator<Object[]> iterator() {
        return new IteratorWithFilter<>(table.iterator(), getNegPredicate());
    }

    @Override
    public void deleteAll() {
        table.deleteAll();
    }
}
