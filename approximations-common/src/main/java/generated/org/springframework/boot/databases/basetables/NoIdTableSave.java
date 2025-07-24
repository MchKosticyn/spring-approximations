package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.NoIdTableSaveIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class NoIdTableSave extends AChainedNoIdTable {

    private Object[] saved;

    public NoIdTableSave(ANoIdTable table, Object[] saved) {
        this.table = table;
        this.saved = saved;
    }

    public Object[] getSaved() {
        return saved;
    }

    @Override
    public void deleteAll() {
        table.deleteAll();
        saved = null;
    }

    @NotNull
    @Override
    public Iterator<Object[]> iterator() {
        return new NoIdTableSaveIterator(this);
    }
}
