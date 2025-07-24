package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.NoIdTableDeleteIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class NoIdTableDelete extends AChainedNoIdTable {

    private Object[] deleted;

    public NoIdTableDelete(ANoIdTable table, Object[] deleted) {
        this.table = table;
        this.deleted = deleted;
    }

    public Object[] getDeleted() {
        return deleted;
    }

    @Override
    public void deleteAll() {
        table.deleteAll();
        deleted = null;
    }

    @NotNull
    @Override
    public Iterator<Object[]> iterator() {
        return new NoIdTableDeleteIterator(this);
    }
}
