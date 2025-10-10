package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.SequenceIterator;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.Predicate;
import java.util.function.Function;

public class SequenceTable<T, CTX> implements ITable<T> {

    private final CTX context;

    private final Predicate<CTX> condition;
    private final Function<CTX, T> producer;

    public SequenceTable(CTX context, Predicate<CTX> condition, Function<CTX, T> producer) {
        this.context = context;
        this.condition = condition;
        this.producer = producer;
    }

    public CTX getContext() { return context; }

    public Predicate<CTX> getCondition() { return condition; }

    public Function<CTX, T> getProducer() { return producer; }

    @Override
    public T first() {
        Iterator<T> iter = iterator();
        return iter.next();
    }

    @Override
    public T ensureFirst() {
        T first = first();
        Engine.assume(first != null);
        return first;
    }

    @Override
    public @NotNull Iterator<T> iterator() {
        return new SequenceIterator<>(this);
    }
}
