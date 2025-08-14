package generated.org.springframework.boot.databases.iterators;

import org.usvm.api.Engine;

import java.util.Iterator;

public class SingletonIterator<T> implements Iterator<T> {

    private final T data;
    private boolean returned;

    public SingletonIterator(T data) {
        this.data = data;
        this.returned = false;
    }

    @Override
    public boolean hasNext() {
        return !returned;
    }

    @Override
    public T next() {
        Engine.assume(hasNext());
        returned = true;
        return data;
    }
}
