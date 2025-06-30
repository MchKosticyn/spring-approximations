package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableGeneratedIdIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Supplier;

public class BaseTableGeneratedId<T, V> extends AChainedBaseTable<V> {

    public Supplier<T> blankInit;
    public Function<T, V> getIdFunction;
    public Class<T> clazz;

    public BaseTableGeneratedId(ABaseTable<V> table, Class<T> clazz) {
        this.table = table;
        this.clazz = clazz;
    }

    public void setBlankInit(Supplier<T> blankInit) {
        this.blankInit = blankInit;
    }

    public void setGetIdFunction(Function<T, V> getIdFunction) {
        this.getIdFunction = getIdFunction;
    }

    @Override
    public void deleteAll() {
        table.deleteAll();
    }

    @Override
    public int size() {
        Iterator<Object[]> iter = iterator();
        int count = 0;
        while (iter.hasNext()) {
            Object[] ignored = iter.next();
            count++;
        }
        return count;
    }

    @NotNull
    @Override
    public Iterator<Object[]> iterator() {
        return new BaseTableGeneratedIdIterator<>(this);
    }
}
