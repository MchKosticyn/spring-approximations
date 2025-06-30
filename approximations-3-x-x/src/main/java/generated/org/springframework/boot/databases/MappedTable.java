package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.MappedIterator;
import org.assertj.core.util.TriFunction;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MappedTable<T, R> implements ITable<R> {

    public ITable<T> table;

    public Class<R> type;

    // only one is not null
    public Function<T, R> mapper;
    public BiFunction<T, Object[], R> mapper2;
    // 3rd arg used by aggregators
    public TriFunction<T, Object[], ITable<T>, R> mapper3;

    // arguments of original repository method
    Object[] methodArgs;

    public MappedTable(ITable<T> table, Function<T, R> mapper, Class<R> type) {
        this.table = table;
        this.mapper = mapper;
        this.type = type;
    }

    public MappedTable(ITable<T> table, BiFunction<T, Object[], R> mapper2, Class<R> type, Object[] methodArgs) {
        this.table = table;
        this.mapper2 = mapper2;
        this.type = type;
        this.methodArgs = methodArgs;
    }

    public MappedTable(ITable<T> table, BiFunction<T, Object[], R> mapper2, Object[] methodArgs) {
        this.table = table;
        this.mapper2 = mapper2;
        this.methodArgs = methodArgs;
    }

    public MappedTable(
            ITable<T> table,
            TriFunction<T, Object[], ITable<T>, R> mapper,
            Class<R> type,
            Object[] methodArgs
    ) {
        this.table = table;
        this.mapper3 = mapper;
        this.type = type;
        this.methodArgs = methodArgs;
    }

    public MappedTable(
            ITable<T> table,
            TriFunction<T, Object[], ITable<T>, R> mapper,
            Object[] methodArgs
    ) { this(table, mapper, null, methodArgs); }

    public R applyMapper(T t) {
        if (mapper != null) return mapper.apply(t);
        else if (mapper2 != null) return mapper2.apply(t, methodArgs);
        else return mapper3.apply(t, methodArgs, table);
    }

    @Override
    public int size() {
        return table.size();
    }

    @NotNull
    @Override
    public Iterator<R> iterator() {
        return new MappedIterator<>(this);
    }

    @Override
    public Class<R> type() {
        return type;
    }

    @Override
    public R first() {
        T t = table.first();
        if (t != null) return applyMapper(t);
        return null;
    }

    @Override
    public R ensureFirst() {
        R r = first();
        Engine.assume(r != null);
        return r;
    }
}
