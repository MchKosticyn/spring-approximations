package generated.org.springframework.boot.databases.iterators.basetables;

import generated.org.springframework.boot.databases.basetables.BaseTableGeneratedId;
import org.hibernate.StatelessSession;
import org.usvm.api.Engine;
import stub.spring.SpringDatabases;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Supplier;

public class BaseTableGeneratedIdIterator<T, V> implements Iterator<Object[]> {

    BaseTableGeneratedId<T, V> table;
    Iterator<Object[]> tableIter;
    Class<T> clazz;

    Supplier<T> blankInit;
    Function<T, V> getIdFunction;

    public BaseTableGeneratedIdIterator(BaseTableGeneratedId<T, V> table) {
        this.table = table;
        this.tableIter = table.table.iterator();
        this.clazz = table.clazz;

        this.blankInit = table.blankInit;
        this.getIdFunction = table.getIdFunction;
    }

    public V generateNewId() {
        T blankObj = blankInit.get();

        try (StatelessSession s = SpringDatabases.sessionFactory.openStatelessSession()) {
            s.insert(blankObj);
        }

        return getIdFunction.apply(blankObj);
    }

    @Override
    public boolean hasNext() {
        return tableIter.hasNext();
    }

    @Override
    public Object[] next() {
        Engine.assume(hasNext());

        Object[] row = tableIter.next();
        V newId = generateNewId();
        row[table.idColumnIx()] = newId;

        return row;
    }
}
