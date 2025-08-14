package generated.org.springframework.boot.databases.saveupddel;

import generated.org.springframework.boot.databases.basetables.BaseTableManager;
import generated.org.springframework.boot.databases.wrappers.ListWrapper;
import generated.org.springframework.boot.databases.wrappers.SetWrapper;
import org.hibernate.type.descriptor.java.JavaType;
import org.hibernate.type.descriptor.java.spi.JavaTypeRegistry;
import org.hibernate.type.spi.TypeConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

// T - type of dataclass, V -type of id from DTO, X - type of id from repository
public class CrudManager<T, V, X> {

    private final BaseTableManager<T, V> table;
    private final Function<X, Object[]> complexIdFieldTranslator; // nullable

    private final JavaType<?> idHibernateType;

    public CrudManager(
            BaseTableManager<T, V> table,
            Function<X, Object[]> complexIdFieldTranslator
    ) {
        this.table = table;
        this.complexIdFieldTranslator = complexIdFieldTranslator;

        Class<V> idType = table.getIdType();
        if (idType != null) {
            JavaTypeRegistry register = new TypeConfiguration().getJavaTypeRegistry();
            this.idHibernateType = register.getDescriptor(idType);
        } else {
            this.idHibernateType = null;
        }
    }

    public Object[] parseIdField(X value) {
        if (complexIdFieldTranslator != null) {
            return complexIdFieldTranslator.apply(value);
        } else {
            Object id = idHibernateType.coerce(value, null);
            return new Object[]{id};
        }
    }

    // allowUpdate - may or not update given entity in database
    public void save(T t, boolean allowUpdate) {
        if (!allowUpdate) table.pureSave(t);
        else table.save(t);
    }

    public Iterable<? extends T> saveAll(Iterable<? extends T> ts) {
        for (T t : ts) {
            table.save(t);
        }
        return ts;
    }

    public void delete(T t) {
        table.delete(t);
    }

    public void deleteAll() {
        table.deleteAll();
    }

    public void deleteAll(Iterable<? extends T> ts) {
        for (T t : ts) {
            table.delete(t);
        }
    }

    // It is important that names of following template
    // [name of repository method]_[return type where "." replaced with "_"]
    public Iterable<T> findAll_java_lang_Iterable() {
        return table.getCopiedTable();
    }

    public List<T> findAll_java_util_List() {
        return new ListWrapper<>(table.getCopiedTable());
    }

    public Collection<T> findAll_java_util_Collection() {
        return new ListWrapper<>(table.getCopiedTable());
    }

    public Page<T> findAll_org_springframework_data_domain_Page(Pageable pageable) {
        List<T> list = new ListWrapper<>(table.getCopiedTable());
        return new PageImpl<>(list, pageable, list.size());
    }

    public Set<T> findAll_java_util_Set() {
        return new SetWrapper<>(table.getCopiedTable());
    }

    public T findById_T(X repoKey) {
        Object[] key = parseIdField(repoKey);
        return table.findById(key).orElse(null);
    }

    public Optional<T> findById_java_util_Optional(X repoKey) {
        Object[] key = parseIdField(repoKey);
        return table.findById(key);
    }
}
