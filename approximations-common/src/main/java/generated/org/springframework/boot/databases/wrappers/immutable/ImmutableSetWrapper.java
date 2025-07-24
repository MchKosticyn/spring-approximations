package generated.org.springframework.boot.databases.wrappers.immutable;

import generated.org.springframework.boot.databases.CacheTable;
import generated.org.springframework.boot.databases.ITable;
import generated.org.springframework.boot.databases.MappedTable;
import generated.org.springframework.boot.databases.wrappers.IWrapper;
import generated.org.springframework.boot.databases.wrappers.SetWrapper;
import org.jetbrains.annotations.NotNull;
import org.usvm.spring.api.SpringEngine;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

// Used to represent collection in not copied yet objects from database
public class ImmutableSetWrapper<T> implements Set<T>, IWrapper<T> {

    private final CacheTable<T> cache;

    public ImmutableSetWrapper(CacheTable<T> cache) {
        this.cache = cache;
    }

    @Override
    public IWrapper<T> copy(Function<T, T> copyFunction) {
        MappedTable<T, T> copied = new MappedTable<>(cache, copyFunction);
        return new SetWrapper<>(copied);
    }

    @Override
    public ITable<T> unwrap() {
        return cache;
    }

    @Override
    public int size() {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return 0;
    }

    @Override
    public boolean isEmpty() {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return false;
    }

    @Override
    public boolean contains(Object o) {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return false;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return new Object[0];
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return null;
    }

    @Override
    public boolean add(T t) {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return false;
    }

    @Override
    public boolean remove(Object o) {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
        return false;
    }

    @Override
    public void clear() {
        SpringEngine.println("[DB Warning] ImmutableSetWrapper's immutable");
    }
}
