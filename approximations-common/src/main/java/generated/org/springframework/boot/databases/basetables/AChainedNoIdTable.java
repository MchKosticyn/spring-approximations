package generated.org.springframework.boot.databases.basetables;

public abstract class AChainedNoIdTable extends ANoIdTable {

    protected ANoIdTable table;

    public ANoIdTable getTable() {
        return table;
    }

    @Override
    public int columnCount() {
        return table.columnCount();
    }

    @Override
    public boolean rowEquals(Object[] left, Object[] right) {
        return table.rowEquals(left, right);
    }
}
