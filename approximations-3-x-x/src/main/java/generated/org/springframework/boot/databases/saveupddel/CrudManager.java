package generated.org.springframework.boot.databases.saveupddel;

import generated.org.springframework.boot.databases.MappedTable;
import generated.org.springframework.boot.databases.basetables.BaseTableManager;
import generated.org.springframework.boot.databases.iterators.utils.IteratorWithMap;
import generated.org.springframework.boot.databases.wrappers.ListWrapper;
import generated.org.springframework.boot.databases.wrappers.SetWrapper;
import org.hibernate.type.descriptor.java.JavaType;
import org.hibernate.type.spi.TypeConfiguration;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

// T - type of dataclass, V - type of id field, X - type of id from repository
public class CrudManager<T, V, X> {

    public BaseTableManager<T, V> table;
    public Function<T, Object[]> serializer; // nullable
    public Function<Object[], T> deserializer; // nullable

    public boolean isAutoGenerateId;

    public Class<V> idType;
    public Class<T> genericType;

    public JavaType<V> idHibernateType;

    public CrudManager(
            BaseTableManager<T, V> table,
            Function<T, Object[]> serializer,
            Function<Object[], T> deserializer,
            Class<T> genericType
    ) {
        this.table = table;
        this.isAutoGenerateId = table.isAutoGenerateId;
        this.serializer = serializer;
        this.deserializer = deserializer;
        this.idType = table.idColType;
        this.genericType = genericType;

        this.idHibernateType = new TypeConfiguration().getJavaTypeRegistry().getDescriptor(idType);
    }

    public V parseIdField(X value) {
        return idHibernateType.coerce(value, null);
    }

    @SuppressWarnings("unchecked")
    // allowUpdate - may or not update given entity in database
    public void save(T t, boolean allowUpdate) {
        Object[] row = serializer.apply(t);
        if (!allowUpdate) table.pureSave(row);
        else table.save(row);
    }

    public Iterable<? extends T> saveAll(Iterable<? extends T> ts) {
        for (T t : ts) {
            Object[] row = serializer.apply(t);
            table.save(row);
        }
        return ts;
    }

    public void delete(T t) {
        Object[] row = serializer.apply(t);
        table.delete(row);
    }

    public void deleteAll() {
        table.deleteAll();
    }

    public void deleteAll(Iterable<? extends T> ts) {
        for (T t : ts) {
            Object[] row = serializer.apply(t);
            table.delete(row);
        }
    }

    // It is important that names of following template
    // [name of repository method]_[return type where "." replaced with "_"]
    public Iterable<T> findAll_java_lang_Iterable() {
        return new IterableWithMap<>(table.findAll(), deserializer);
    }

    public List<T> findAll_java_util_List() {
        MappedTable<Object[], T> mapped = new MappedTable<>(table, deserializer, genericType);
        return new ListWrapper<>(mapped);
    }

    public Collection<T> findAll_java_util_Collection() {
        MappedTable<Object[], T> mapped = new MappedTable<>(table, deserializer, genericType);
        return new ListWrapper<>(mapped);
    }

    public Page<T> findAll_org_springframework_data_domain_Page(Pageable pageable) {
        MappedTable<Object[], T> mapped = new MappedTable<>(table, deserializer, genericType);
        List<T> list = new ListWrapper<>(mapped);
        return new PageImpl<T>(list, pageable, list.size());
    }

    public Set<T> findAll_java_util_Set() {
        MappedTable<Object[], T> mapped = new MappedTable<>(table, deserializer, genericType);
        return new SetWrapper<>(mapped);
    }

    public T findById_T(X repoKey) {
        V key = parseIdField(repoKey);
        Optional<Object[]> row = table.findById(key);
        return row.map(deserializer).orElse(null);
    }

    public Optional<T> findById_java_util_Optional(X repoKey) {
        V key = parseIdField(repoKey);
        return table.findById(key).map(deserializer);
    }

    class IterableWithMap<I, R> implements Iterable<R> {

        Iterable<I> iterable;
        Function<I, R> mapper;

        public IterableWithMap(Iterable<I> iterable, Function<I, R> mapper) {
            this.iterable = iterable;
            this.mapper = mapper;
        }

        @NotNull
        @Override
        public Iterator<R> iterator() {
            return new IteratorWithMap<>(iterable.iterator(), mapper);
        }
    }
}
