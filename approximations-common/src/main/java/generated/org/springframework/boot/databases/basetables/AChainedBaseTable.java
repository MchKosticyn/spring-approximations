package generated.org.springframework.boot.databases.basetables;

public abstract class AChainedBaseTable<T> extends ABaseTable<T> {

    protected ABaseTable<T> table;

    public ABaseTable<T> getTable() {
        return table;
    }

    @Override
    public Object[] buildId(T t) {
        return table.buildId(t);
    }

    @Override
    public boolean idEquals(Object[] left, Object[] right) {
        return table.idEquals(left, right);
    }
}
