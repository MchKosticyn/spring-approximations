package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTableTrack;
import generated.org.springframework.boot.databases.basetables.TableTracker;
import org.usvm.api.Engine;

import java.util.Iterator;

public class BaseTableTrackIterator<T> implements Iterator<T> {

    private final Iterator<T> iter;
    private final String tableName;
    private final Class<T> classType;

    // for tracking
    private int ix;

    public BaseTableTrackIterator(BaseTableTrack<T> table) {
        this.iter = table.getTable().iterator();
        this.tableName = table.getTableName();
        this.classType = table.getClassType();
        this.ix = 0;
    }


    public String getTableName() {
        return tableName;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public T next() {
        Engine.assume(hasNext());

        T t = iter.next();
        TableTracker.tryTrack(getTableName(), t, ix++, classType);

        return t;
    }
}
