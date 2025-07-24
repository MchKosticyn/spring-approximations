package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.HavingTableIterator;
import org.assertj.core.util.TriFunction;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.Iterator;

public class HavingTable<T> implements ITable<ITable<T>> {

    private final ITable<ITable<T>> table;
    private final TriFunction<ITable<T>, Object[], ITable<ITable<T>>, Boolean> pred;
    private final Object[] methodArgs;

    public HavingTable(
            ITable<ITable<T>> table,
            TriFunction<ITable<T>, Object[], ITable<ITable<T>>, Boolean> pred,
            Object[] methodArgs
    ) {
        this.table = table;
        this.pred = pred;
        this.methodArgs = methodArgs;
    }

    public ITable<ITable<T>> getTable() {
        return table;
    }

    public boolean callPredicate(ITable<T> tbl) {
        return pred.apply(tbl, methodArgs, this);
    }

    @Override
    public int size() {
        Iterator<ITable<T>> iter = iterator();
        int count = 0;
        while (iter.hasNext()) {
            ITable<T> ignored = iter.next();
            count++;
        }

        return count;
    }

    @Override
    public ITable<T> first() {
        Iterator<ITable<T>> iter = iterator();
        if (iter.hasNext()) return iter.next();
        return null;
    }

    @Override
    public ITable<T> ensureFirst() {
        Iterator<ITable<T>> iter = iterator();
        Engine.assume(iter.hasNext());
        return iter.next();
    }

    @NotNull
    @Override
    public Iterator<ITable<T>> iterator() {
        return new HavingTableIterator<>(this);
    }
}
