package generated.org.springframework.boot.databases;

import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.Collection;
import java.util.Iterator;

public class CollectionTable<T> implements ITable<T> {

    private final Collection<T> collection;

    // Collection must be a little bit symbolic
    public CollectionTable(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public int size() {
        return collection.size();
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

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return collection.iterator();
    }
}
