package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTableConstraintValidate;
import generated.org.springframework.boot.databases.validation.ConstraintValidatorContextImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.usvm.api.Engine;

import java.util.Iterator;

public class BaseTableConstraintValidateIterator<V> implements Iterator<Object[]> {

    public BaseTableConstraintValidate<V> table;
    public Iterator<Object[]> tblIter;
    public ConstraintValidator<?, ?>[][] validators;

    public ConstraintValidatorContext ctx;

    public BaseTableConstraintValidateIterator(BaseTableConstraintValidate<V> table) {
        this.table = table;
        this.tblIter = table.table.iterator();
        this.validators = table.validators;

        this.ctx = new ConstraintValidatorContextImpl();
    }

    @SuppressWarnings("unchecked")
    public <T> void validateValue(Object value, ConstraintValidator<?, T> validator) {
        try {
            Engine.assume(validator.isValid((T) value, ctx));
        }
        catch (Throwable e) {
            Engine.assume(false);
        }
    }

    public void validateRow(Object[] row) {
        for (int i = 0; i < table.columnCount(); i++) {
            ConstraintValidator<?, ?>[] vs = validators[i];

            Object value = row[i];
            for (ConstraintValidator<?, ?> validator : vs) {
                validateValue(value, validator);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return tblIter.hasNext();
    }

    @Override
    public Object[] next() {
        Engine.assume(hasNext());

        Object[] row = tblIter.next();
        validateRow(row);

        return row;
    }
}
