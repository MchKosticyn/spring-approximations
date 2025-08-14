package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableConstraintValidateIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class BaseTableConstraintValidate<T> extends AChainedBaseTable<T> {

    private final String[] fieldNames;

    public BaseTableConstraintValidate(
            ABaseTable<T> table,
            String[] fieldNames
    ) {
        this.table = table;
        this.fieldNames = fieldNames;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BaseTableConstraintValidateIterator<>(this);
    }
}
