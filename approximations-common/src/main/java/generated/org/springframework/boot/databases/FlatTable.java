package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.FlatIterator;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.Iterator;

public class FlatTable<T> implements ITable<T> {

    private final ITable<ITable<T>> tables;
    public int size;

    public FlatTable(ITable<ITable<T>> tables) {
        this.tables = tables;
        this.size = -1;
    }

    @Override
    public int size() {
        if (size != -1) return size;

        int count = 0;
        for (ITable<T> tbl : tables) {
            count += tbl.size();
        }
        size = count;
        return count;
    }

    public ITable<ITable<T>> getTables() {
        return tables;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new FlatIterator<>(this);
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
