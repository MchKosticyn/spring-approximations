package generated.org.springframework.boot.databases.wrappers;

import generated.org.springframework.boot.databases.ITable;

import java.util.function.Function;

public interface IWrapper<T> {

    IWrapper<T> copy(Function<T, T> copyFunction);

    ITable<T> unwrap();
}
