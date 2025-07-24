package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.SortedIterator;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.BiFunction;

public class SortedTable<T, R> implements ITable<T> {

    private final ITable<T> table;
    private int size;
    private final int limit; // -1 if no limit
    private final int offset; // 0 if no offset
    private final boolean direction; // true -  ASC, false - DESC
    private final boolean nulls; // true - LAST, false - FIRST

    private int tblSize;

    private final BiFunction<T, Object[], R> translate;
    private final BiFunction<R, R, Integer> comparer;

    private Object[] sorted;

    // arguments of original repository method
    private final Object[] methodArgs;

    private boolean initialized = false;

    public SortedTable(
            ITable<T> table,
            int limit,
            int offset,
            boolean direction,
            boolean nulls,
            BiFunction<T, Object[], R> translate,
            BiFunction<R, R, Integer> comparer,
            Object[] methodArgs
    ) {

        this.table = table;
        this.translate = translate;
        this.comparer = comparer;
        this.limit = limit;
        this.offset = offset;
        this.direction = direction;
        this.nulls = nulls;
        this.methodArgs = methodArgs;
    }

    public SortedTable(
            ITable<T> table,
            int limit,
            int offset,
            boolean direction,
            boolean nulls,
            BiFunction<T, Object[], R> translate,
            BiFunction<R, R, Integer> comparer
    ) {
        this(table, limit, offset, direction, nulls, translate, comparer, new Object[0]);
    }

    public SortedTable(
            ITable<T> table,
            int limit,
            int offset,
            int size,
            boolean direction,
            boolean nulls,
            int tblSize,
            BiFunction<T, Object[], R> translate,
            BiFunction<R, R, Integer> comparer,
            Object[] methodArgs,
            T[] sorted
    ) {
        this.table = table;
        this.limit = limit;
        this.offset = offset;
        this.size = size;
        this.direction = direction;
        this.nulls = nulls;
        this.tblSize = tblSize;
        this.translate = translate;
        this.comparer = comparer;
        this.methodArgs = methodArgs;
        this.sorted = sorted;
    }

    private void ensureInitialized() {
        if (initialized) return;

        this.tblSize = table.size();

        if (limit == -1) {
            this.size = tblSize - offset;
        } else {
            this.size = Math.min(tblSize - offset, limit);
        }

        this.sorted = new Object[tblSize];
        Iterator<T> tblIter = table.iterator();
        int ix = 0;
        while (tblIter.hasNext()) {
            sorted[ix++] = tblIter.next();
        }

        sort();
        initialized = true;
    }

    public int getOffset() {
        return offset;
    }

    public int getSize() {
        return size;
    }

    public Object[] getSorted() {
        return sorted;
    }

    public boolean compare(R left, R right) {
        if (left == null) return nulls; // NULLs always bigger or else
        boolean common = comparer.apply(left, right) > 0;
        return common == direction;
    }

    public R applyTranslate(T t) {
        return translate.apply(t, methodArgs);
    }

    // bubble sort
    @SuppressWarnings("unchecked")
    private void sort() {
        for (int i = 0; i < tblSize; i++) {
            boolean swapped = false;
            for (int j = 0; j < tblSize - i - 1; j++) {

                R left = applyTranslate((T) sorted[j]);
                R right = applyTranslate((T) sorted[j + 1]);

                if (compare(left, right)) {

                    T tmp = (T) sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = tmp;

                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    @Override
    public int size() {
        ensureInitialized();
        return size;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        ensureInitialized();
        return new SortedIterator<>(this);
    }

    @Override
    public T first() {
        Iterator<T> iter = iterator();
        if (!iter.hasNext()) return null;
        return iter.next();
    }

    @Override
    public T ensureFirst() {
        Iterator<T> iter = iterator();
        Engine.assume(iter.hasNext());
        return iter.next();
    }
}
