package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.FiltredIterator;
import org.assertj.core.util.TriFunction;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FiltredTable<T> implements ITable<T> {

    public ITable<T> table;

    // only one is not null
    public Function<T, Boolean> filter;
    public BiFunction<T, Object[], Boolean> filter2;
    // 3rd arg used by aggregators
    public TriFunction<T, Object[], ITable<T>, Boolean> filter3;

    public List<T> cache;
    public int cacheSize;

    // arguments of original repository method
    Object[] methodArgs;

    public FiltredTable(ITable<T> table, BiFunction<T, Object[], Boolean> filter2, Object[] methodArgs) {
        this.table = table;
        this.filter = null;
        this.filter2 = filter2;

        this.cache = new ArrayList<>();
        this.cacheSize = -1;

        this.methodArgs = methodArgs;
    }

    public FiltredTable(ITable<T> table, BiFunction<T, Object[], Boolean> filter2) {
        this.table = table;
        this.filter = null;
        this.filter2 = filter2;

        this.cache = new ArrayList<>();
        this.cacheSize = -1;

        this.methodArgs = new Object[0];
    }


    public FiltredTable(ITable<T> table, Function<T, Boolean> filter) {
        this.table = table;
        this.filter = filter;
        this.filter2 = null;

        this.cache = new ArrayList<>();
        this.cacheSize = -1;

        this.methodArgs = new Object[0];
    }

    public FiltredTable(
            ITable<T> table,
            Function<T, Boolean> filter,
            BiFunction<T, Object[], Boolean> filter2,
            TriFunction<T, Object[], ITable<T>, Boolean> filter3,
            List<T> cache,
            int cacheSize,
            Object[] methodArgs
    ) {
        this.table = table;
        this.filter = filter;
        this.filter2 = filter2;
        this.filter3 = filter3;
        this.cache = cache;
        this.cacheSize = cacheSize;
        this.methodArgs = methodArgs;
    }

    public FiltredTable(
            ITable<T> table,
            TriFunction<T, Object[], ITable<T>, Boolean> filter3,
            Object[] methodArgs
    ) {
        this.table = table;
        this.filter = null;
        this.filter3 = filter3;

        this.cache = new ArrayList<>();
        this.cacheSize = -1;

        this.methodArgs = methodArgs;
    }

    public Boolean callFilter(T t) {
        if (filter != null) return filter.apply(t);
        else if (filter2 != null) return filter2.apply(t, methodArgs);
        else return filter3.apply(t, methodArgs, this);
    }

    public int size() {
        if (cacheSize != -1) return cacheSize;

        Iterator<T> iter = iterator();
        int count = 0;
        while (iter.hasNext()) {
            T candidate = iter.next();
            Engine.assume(callFilter(candidate));
            cache.add(candidate);
            count++;
        }

        cacheSize = count;
        return cacheSize;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        if (cacheSize != -1) return cache.iterator();
        return new FiltredIterator<>(this);
    }

    public Class<T> type() {
        return table.type();
    }

    @NotNull
    public T firstEnsure() {
        Iterator<T> iter = iterator();
        Engine.assume(iter.hasNext());
        return iter.next();
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
