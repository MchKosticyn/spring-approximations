package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.SingletonIterator;
import generated.org.springframework.boot.databases.utils.DataRow;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class SingletonTable<T> implements ITable<T> {

    private final T data;

    public SingletonTable(T data) {
        this.data = data;
    }

    public static <T> SingletonTable<DataRow> of(String name, T data) {
        DataRow row = new DataRow(name, data);
        return new SingletonTable<>(row);
    }

    @Override
    public int size() {
        return 1;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new SingletonIterator<>(data);
    }

    @Override
    public T first() {
        return data;
    }

    @Override
    public T ensureFirst() {
        return data;
    }
}
