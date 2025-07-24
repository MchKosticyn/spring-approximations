package generated.org.springframework.boot.databases;

import java.util.Iterator;

public interface ITable<T> extends Iterable<T> {

    default int size() {
        Iterator<T> iter = iterator();
        int count = 0;
        while (iter.hasNext()) {
            T ignored = iter.next();
            count++;
        }
        return count;
    }

    T first();

    T ensureFirst();
}
