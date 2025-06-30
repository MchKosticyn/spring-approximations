package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableLambdaValidateIterator;
import generated.org.springframework.boot.databases.utils.DatabaseValidators;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

public class BaseTableLambdaValidate<V> extends AChainedBaseTable<V> {

    public Function<Object, Boolean>[] validators;

    public BaseTableLambdaValidate(ABaseTable<V> table, Function<Object, Boolean>[] validators) {
        this.table = table;
        this.validators = validators;
    }

    // Creates table with single validator at validatorIx
    @SuppressWarnings("unchecked")
    public BaseTableLambdaValidate(ABaseTable<V> table, Function<Object, Boolean> validator, int validatorIx) {
        Function<Object, Boolean>[] validators = (Function<Object, Boolean>[]) Array.newInstance(Function.class, table.columnCount());
        for (int i = 0; i < table.columnCount(); i++)
            validators[i] = i == validatorIx ? validator : null;

        this.table = table;
        this.validators = validators;
    }

    // Validate id field
    public BaseTableLambdaValidate(ABaseTable<V> table) {
        this(table, DatabaseValidators.getIdValidator(table.columnTypes()[table.idColumnIx()]), table.idColumnIx());
    }

    @Override
    public void deleteAll() {
        table.deleteAll();
    }

    @Override
    public int size() {
        int count = 0;
        Iterator<Object[]> iter = iterator();
        while (iter.hasNext()) {
            Object[] ignored = iter.next();
            count++;
        }
        return count;
    }

    @NotNull
    @Override
    public Iterator<Object[]> iterator() {
        return new BaseTableLambdaValidateIterator<>(this);
    }
}
