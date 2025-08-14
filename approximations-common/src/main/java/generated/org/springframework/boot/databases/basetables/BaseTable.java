package generated.org.springframework.boot.databases.basetables;

import generated.org.springframework.boot.databases.iterators.basetables.BaseTableIterator;
import generated.org.springframework.boot.databases.utils.DatabaseValidators;
import org.hibernate.StatelessSession;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import stub.spring.SpringDatabases;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BaseTable<T> extends ABaseTable<T> {

    private final T[] data;
    private final int size;
    private final Class<T> entityType;

    private final boolean generatedId;

    private Supplier<T> blankInit;
    // build relation between T object and related classes
    private Consumer<T> relationsInit;

    // used only iff idIndexes.size == 1 for id generation
    private Function<T, Object> getIdFunction;
    private BiConsumer<T, Object> setIdFunction;
    // builds array with all ids
    private Function<T, Object[]> buildIdFunction;

    private Function<T, Object>[] gettersForSoft;
    private Class<?>[] typesForSoft;

    private int nextIndexToSet;

    public BaseTable(
            Class<T> type,
            boolean generatedId
    ) {
        this.generatedId = generatedId;
        this.nextIndexToSet = 0;
        this.size = Engine.makeSymbolicInt();
        this.entityType = type;

        // TODO: think about tables with 0 size (execution prioritize 0 size, that leads to nulls by first())
        Engine.assume(size > 0);
        Engine.assume(size <= 10);

        this.data = Engine.makeConcreteArray(type, size);
        Engine.assume(this.data != null);

        this.blankInit = null;
        this.relationsInit = null;
        this.getIdFunction = null;
        this.setIdFunction = null;
        this.buildIdFunction = null;

        this.gettersForSoft = null;
        this.typesForSoft = null;
    }

    @Override
    public int size() {
        return size;
    }

    public T getRowEnsure(int ix) {
        Engine.assume(ix < size);
        if (data[ix] != null) return data[ix];

        T t = Engine.makeSymbolic(entityType);
        Engine.assume(t != null);

        if (generatedId) setNewGeneratedId(t);

        relationsInit.accept(t);
        applyCommonSoftValidation(t);

        data[ix] = t;

        return data[ix];
    }

    private void applyCommonSoftValidation(T t) {
        for (int i = 0; i < gettersForSoft.length; i++) {
            Class<?> softType = typesForSoft[i];
            Function<Object, Boolean> soft = DatabaseValidators.getSoftValidator(softType);

            if (soft != null) {
                Function<T, Object> getter = gettersForSoft[i];
                Object value = getter.apply(t);
                Engine.assumeSoft(soft.apply(value));
            }
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BaseTableIterator<>(this);
    }

    public void setDTOFunctions(
            Supplier<T> blankInit,
            Consumer<T> relationsInit,
            Function<T, Object[]> buildIdFunction,
            Function<T, Object> getIdFunction,
            BiConsumer<T, Object> setIdFunction
    ) {
        this.blankInit = blankInit;
        this.relationsInit = relationsInit;
        this.buildIdFunction = buildIdFunction;
        this.getIdFunction = getIdFunction;
        this.setIdFunction = setIdFunction;
    }

    public void setForSoft(Function<T, Object>[] getters, Class<?>[] types) {
        this.gettersForSoft = getters;
        this.typesForSoft = types;
    }

    public Object generateNewId() {
        T blankObj = blankInit.get();
        try (StatelessSession s = SpringDatabases.sessionFactory.openStatelessSession()) {
            s.insert(blankObj);
        }

        return getIdFunction.apply(blankObj);
    }

    public void setNewGeneratedId(T t) {
        Object newId = generateNewId();

        setIdFunction.accept(t, newId);
    }

    @Override
    public Object[] buildId(T t) {
        return buildIdFunction.apply(t);
    }
}
