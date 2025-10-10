package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTableConstraintValidate;
import org.usvm.api.Engine;
import stub.spring.SpringDatabases;

import java.util.Iterator;
import java.util.Set;

public class BaseTableConstraintValidateIterator<T> implements Iterator<T> {

    private final Iterator<T> tblIter;
    private final String[] fieldNames;

    private int ix;
    private final int userEntitiesSize;

    public BaseTableConstraintValidateIterator(BaseTableConstraintValidate<T> table) {
        this.tblIter = table.getTable().iterator();
        this.fieldNames = table.getFieldNames();

        this.ix = 0;
        this.userEntitiesSize = table.getUserEntitiesSize();
    }

    public BaseTableConstraintValidateIterator(Iterator<T> tableIter, String[] fieldNames) {
        this.tblIter = tableIter;
        this.fieldNames = fieldNames;

        this.ix = 0;
        this.userEntitiesSize = 0;
    }

    public void validate(T t) {
        for (String fieldName : fieldNames) {
            Set<?> violations = SpringDatabases.validator.validateProperty(t, fieldName);
            Engine.assume(violations.isEmpty());
        }
    }

    @Override
    public boolean hasNext() {
        return tblIter.hasNext();
    }

    @Override
    public T next() {
        Engine.assume(hasNext());

        T next = tblIter.next();

        if (ix++ >= userEntitiesSize) validate(next);

        return next;
    }
}
