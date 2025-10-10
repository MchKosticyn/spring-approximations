package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableConstraintValidateIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class BaseTableConstraintValidate<T> extends AChainedBaseTable<T> {

    private final String[] fieldNames;
    private final int userEntitiesSize;

    public BaseTableConstraintValidate(
            ABaseTable<T> table,
            String[] fieldNames,
            int userEntitiesSize
    ) {
        this.table = table;
        this.fieldNames = fieldNames;
        this.userEntitiesSize = userEntitiesSize;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int getUserEntitiesSize() { return userEntitiesSize; }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BaseTableConstraintValidateIterator<>(this);
    }
}
