package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.ITable;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.Optional;

public abstract class ABaseTable<T> implements ITable<T> {

    public abstract Object[] buildId(T t);

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

    // TODO [OPT]: optimize everywhere
    public Optional<T> findById(Object[] id) {
        for (T t : this) {
            if (hasId(id, t)) return Optional.of(t);
        }
        return Optional.empty();
    }

    public boolean idEquals(Object[] left, Object[] right) {
        for (int i = 0; i < left.length; i++) {
            if (!left[i].equals(right[i])) return false;
        }
        return true;
    }

    public boolean hasId(Object[] id, T t) {
        Object[] tId = buildId(t);
        for (int i = 0; i < id.length; i++) {
            if (!id[i].equals(tId[i])) return false;
        }
        return true;
    }

    public boolean isSameId(T left, T right) {
        Object[] leftId = buildId(left);
        Object[] rightId = buildId(right);
        return idEquals(leftId, rightId);
    }
}
