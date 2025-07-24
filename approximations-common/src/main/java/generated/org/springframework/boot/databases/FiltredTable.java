package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.FiltredIterator;
import org.assertj.core.util.TriFunction;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FiltredTable<T> implements ITable<T> {

    private final ITable<T> table;

    // only one is not null
    private final Function<T, Boolean> filter;
    private BiFunction<T, Object[], Boolean> filter2;
    // 3rd arg used by aggregators
    private TriFunction<T, Object[], ITable<T>, Boolean> filter3;

    // arguments of original repository method
    private final Object[] methodArgs;

    public FiltredTable(ITable<T> table, BiFunction<T, Object[], Boolean> filter2, Object[] methodArgs) {
        this.table = table;
        this.filter = null;
        this.filter2 = filter2;

        this.methodArgs = methodArgs;
    }

    public FiltredTable(ITable<T> table, BiFunction<T, Object[], Boolean> filter2) {
        this.table = table;
        this.filter = null;
        this.filter2 = filter2;

        this.methodArgs = new Object[0];
    }


    public FiltredTable(ITable<T> table, Function<T, Boolean> filter) {
        this.table = table;
        this.filter = filter;
        this.filter2 = null;

        this.methodArgs = new Object[0];
    }

    public FiltredTable(
            ITable<T> table,
            TriFunction<T, Object[], ITable<T>, Boolean> filter3,
            Object[] methodArgs
    ) {
        this.table = table;
        this.filter = null;
        this.filter3 = filter3;

        this.methodArgs = methodArgs;
    }

    public ITable<T> getTable() {
        return table;
    }

    public Boolean callFilter(T t) {
        if (filter != null) return filter.apply(t);
        else if (filter2 != null) return filter2.apply(t, methodArgs);
        else return filter3.apply(t, methodArgs, this);
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new FiltredIterator<>(this);
    }

    @Override
    public T first() {
        Iterator<T> iter = iterator();
        if (iter.hasNext()) return iter.next();
        return null;
    }

    @Override
    public T ensureFirst() {
        Iterator<T> iter = iterator();
        Engine.assume(iter.hasNext());
        return iter.next();
    }
}
