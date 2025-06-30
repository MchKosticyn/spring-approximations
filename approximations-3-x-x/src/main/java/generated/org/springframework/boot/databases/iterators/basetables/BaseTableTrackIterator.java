package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTableTrack;
import generated.org.springframework.boot.databases.basetables.TableTracker;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.Function;

public class BaseTableTrackIterator<T, V> implements Iterator<Object[]> {

    public BaseTableTrack<T, V> table;
    public Iterator<Object[]> iter;
    public Function<Object[], T> deserializer;
    public String tableName;
    public Class<T> classType;

    // for tracking
    public int ix;

    public BaseTableTrackIterator(BaseTableTrack<T, V> table) {
        this.table = table;
        this.iter = table.table.iterator();
        this.tableName = table.tableName;
        this.classType = table.classType;
        this.ix = 0;

        if (table.deserializer == null) throw new LinkageError();
        this.deserializer = table.deserializer;
    }


    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Object[] next() {
        Engine.assume(hasNext());

        Object[] row = iter.next();
        T value = deserializer.apply(row);
        TableTracker.tryTrack(tableName, value, ix++, classType);

        return row;
    }
}
