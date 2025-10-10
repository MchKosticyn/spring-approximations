package generated.org.springframework.boot.databases.iterators;

import generated.org.springframework.boot.databases.SequenceTable;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class SequenceIterator<T, CTX> implements Iterator<T> {

    private final CTX context;
    private final Predicate<CTX> condition;
    private final Function<CTX, T> producer;

    public SequenceIterator(SequenceTable<T, CTX> table) {
        this.context = table.getContext();
        this.condition = table.getCondition();
        this.producer = table.getProducer();
    }

    @Override
    public boolean hasNext() {
        return condition.test(context);
    }

    @Override
    public T next() {
        Engine.assume(hasNext());
        return producer.apply(context);
    }
}
