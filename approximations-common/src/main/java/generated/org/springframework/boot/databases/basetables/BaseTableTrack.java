package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableTrackIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

// T - type of data-class
public class BaseTableTrack<T> extends AChainedBaseTable<T> {

    private final String tableName;
    private final Class<T> classType;

    public BaseTableTrack(ABaseTable<T> table, String tableName, Class<T> classType) {
        this.table = table;
        this.tableName = tableName;
        this.classType = classType;
    }

    public String getTableName() {
        return tableName;
    }

    public Class<T> getClassType() {
        return classType;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BaseTableTrackIterator<>(this);
    }
}
