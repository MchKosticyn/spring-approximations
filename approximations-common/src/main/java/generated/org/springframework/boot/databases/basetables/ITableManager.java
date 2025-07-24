package generated.org.springframework.boot.databases.basetables;

import java.util.function.Function;

public interface ITableManager<T> {
    void applyRangeUpdate(Function<T, Boolean> predicate, Function<T, T> update);

    void applyRangeDelete(Function<T, Boolean> predicate);

    void save(T row);

    void delete(T row);
}
