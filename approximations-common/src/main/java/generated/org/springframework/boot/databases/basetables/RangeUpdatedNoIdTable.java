package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.RangeUpdatedNoIdTableIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Function;

public class RangeUpdatedNoIdTable extends AChainedNoIdTable {

    private final Function<Object[], Boolean> predicate;
    private final Function<Object[], Object[]> update;

    public RangeUpdatedNoIdTable(
            ANoIdTable table,
            Function<Object[], Boolean> predicate,
            Function<Object[], Object[]> update
    ) {
        this.table = table;
        this.predicate = predicate;
        this.update = update;
    }

    public Function<Object[], Boolean> getPredicate() {
        return predicate;
    }

    public Function<Object[], Object[]> getUpdate() {
        return update;
    }

    @NotNull
    @Override
    public Iterator<Object[]> iterator() {
        return new RangeUpdatedNoIdTableIterator(this);
    }

    @Override
    public void deleteAll() {
        table.deleteAll();
    }
}
