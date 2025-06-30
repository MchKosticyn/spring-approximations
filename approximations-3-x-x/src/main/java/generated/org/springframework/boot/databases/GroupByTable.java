package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.GroupByTableIterator;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class GroupByTable<T> implements ITable<ITable<T>> {

    public ITable<T> table;
    public BiFunction<T, Object[], Object>[] translates;
    public BiFunction<Object, Object, Integer>[] comparers;

    public Object[] methodArgs;

    private boolean initialized = false;

    private ArrayList<Object[]> keys;
    public ArrayList<ArrayList<T>> groups;

    public GroupByTable(
            ITable<T> table,
            BiFunction<T, Object[], Object>[] translates,
            BiFunction<Object, Object, Integer>[] comparers,
            Object[] methodArgs
    ) {
        this.table = table;
        this.translates = translates;
        this.comparers = comparers;
        this.methodArgs = methodArgs;
        this.keys = new ArrayList<>();
    }

    private void ensureInitialized() {
        if (initialized) return;

        groupAll();
        initialized = true;
    }

    private void groupAll() {
        Iterator<T> iter = table.iterator();

        while (iter.hasNext()) {
            T t = iter.next();
            Object[] tKey = applyTranslates(t);

            boolean finded = false;
            for (int i = 0; i < keys.size(); i++) {
                Object[] key = keys.get(i);

                if (compareKeys(tKey, key)) {
                    groups.get(i).add(t);
                    finded = true;
                    break;
                }
            }

            if (!finded) {
                keys.add(tKey);
                ArrayList<T> newGroup = new ArrayList<>();
                newGroup.add(t);
                groups.add(newGroup);
            }
        }
    }

    public Object[] applyTranslates(T t) {
        Object[] res = new Object[translates.length];
        for (int i = 0; i < translates.length; i++) {
            res[i] = translates[i].apply(t, methodArgs);
        }
        return res;
    }

    public boolean compareKeys(Object[] left, Object[] right) {
        for (int i = 0; i < comparers.length; i++) {
            Integer cmp = comparers[i].apply(left[i], right[i]);
            if (cmp == 0) {
                continue;
            }

            return false;
        }

        return true;
    }

    @Override
    public int size() {
        ensureInitialized();
        return groups.size();
    }

    @Override
    public Class<ITable<T>> type() {
        return null;
    }

    @Override
    public ITable<T> first() {
        T first = table.first();
        if (first != null) {
            Object[] firstKey = applyTranslates(first);
            Function<T, Boolean> filter = getFilterByKey(firstKey);
            return new FiltredTable<>(table, filter);
        }

        return null;
    }

    private Function<T, Boolean> getFilterByKey(Object[] key) {
        return (T t) -> {
            Object[] newKey = applyTranslates(t);
            return compareKeys(newKey, key);
        };
    }

    @Override
    public ITable<T> ensureFirst() {
        T first = table.ensureFirst();
        Object[] firstKey = applyTranslates(first);
        Function<T, Boolean> filter = getFilterByKey(firstKey);
        return new FiltredTable<>(table, filter);
    }

    @NotNull
    @Override
    public Iterator<ITable<T>> iterator() {
        ensureInitialized();
        return new GroupByTableIterator<>(this);
    }
}
