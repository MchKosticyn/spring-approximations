package generated.org.springframework.boot.databases.iterators.utils;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Function;

public class IterableWithMap<I, R> implements Iterable<R> {

    private final Iterable<I> iterable;
    private final Function<I, R> mapper;

    public IterableWithMap(Iterable<I> iterable, Function<I, R> mapper) {
        this.iterable = iterable;
        this.mapper = mapper;
    }

    @NotNull
    @Override
    public Iterator<R> iterator() {
        return new IteratorWithMap<>(iterable.iterator(), mapper);
    }
}
