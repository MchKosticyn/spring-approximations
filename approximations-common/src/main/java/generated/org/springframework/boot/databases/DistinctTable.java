package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.DistinctIterator;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.Iterator;

public class DistinctTable<T> implements ITable<T> {

    private final ITable<T> table;

    public DistinctTable(ITable<T> table) {
        this.table = table;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(table);
    }

    @Override
    public T first() {
        Iterator<T> iter = iterator();
        if (!iter.hasNext()) return null;
        return iter.next();
    }

    @Override
    public T ensureFirst() {
        Iterator<T> iter = iterator();
        Engine.assume(iter.hasNext());
        return iter.next();
    }
}
