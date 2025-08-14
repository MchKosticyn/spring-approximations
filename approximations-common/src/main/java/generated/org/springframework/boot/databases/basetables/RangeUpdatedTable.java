package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableCommonIdIterator;
import generated.org.springframework.boot.databases.iterators.basetables.BaseTableConstraintValidateIterator;
import generated.org.springframework.boot.databases.iterators.basetables.RangeUpdatedTableIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Function;

public class RangeUpdatedTable<T> extends AChainedBaseTable<T> {

    private final Function<T, Boolean> predicate;
    private final Function<T, T> update;

    private final String[] fieldNames;

    public RangeUpdatedTable(
            ABaseTable<T> table,
            Function<T, Boolean> predicate,
            Function<T, T> update,
            String[] fieldNames
    ) {
        this.table = table;
        this.predicate = predicate;
        this.update = update;
        this.fieldNames = fieldNames;
    }

    public Function<T, Boolean> getPredicate() {
        return predicate;
    }

    public Function<T, T> getUpdate() {
        return update;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        Iterator<T> ownIter = new RangeUpdatedTableIterator<>(this);

        // we need to check that ids are unique after mutation
        Iterator<T> iterWithIdCheck = new BaseTableCommonIdIterator<>(this, ownIter);

        // we need to check table constrains after mutation
        return new BaseTableConstraintValidateIterator<>(iterWithIdCheck, fieldNames);
    }
}
