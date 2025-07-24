package generated.org.springframework.boot.databases;

import generated.org.springframework.boot.databases.iterators.JoinedIterator;
import generated.org.springframework.boot.databases.utils.DataRow;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.util.Iterator;
import java.util.function.Function;

public class JoinedTable implements ITable<DataRow> {

    private int size;

    private final ITable<DataRow> leftTable;
    private final ITable<DataRow> rightTable;

    // nullable
    private final Function<DataRow, Boolean> onMethod;

    // true - JOIN LEFT, false - normal join, to RIGHT JOIN replace left and right tables
    private final boolean isLeft;

    public JoinedTable(
            ITable<DataRow> leftTable,
            ITable<DataRow> rightTable,
            Function<DataRow, Boolean> onMethod,
            boolean isLeft
    ) {
        this(-1, leftTable, rightTable, onMethod, isLeft);
    }

    public JoinedTable(
            ITable<DataRow> leftTable,
            ITable<DataRow> rightTable
    ) {
        this(leftTable, rightTable, null, false);
    }

    public JoinedTable(
            int size,
            ITable<DataRow> leftTable,
            ITable<DataRow> rightTable,
            Function<DataRow, Boolean> onMethod,
            boolean isLeft
    ) {
        this.size = size;
        this.leftTable = leftTable;
        this.rightTable = rightTable;
        this.onMethod = onMethod;
        this.isLeft = isLeft;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public ITable<DataRow> getLeftTable() {
        return leftTable;
    }

    public ITable<DataRow> getRightTable() {
        return rightTable;
    }

    public boolean applyPredicate(DataRow row) {
        if (onMethod == null) return true;
        return onMethod.apply(row);
    }

    // r is null when isLeft and onMethod is false for all rs
    public DataRow composite(DataRow l, DataRow r) {
        return DataRow.merge(l, r);
    }

    @Override
    public int size() {
        if (size != -1) return size;

        if (onMethod == null) {
            size = leftTable.size() * rightTable.size();
            return size;
        }

        Iterator<DataRow> iter = iterator();
        int count = 0;
        while (iter.hasNext()) {
            DataRow candidate = iter.next();
            Engine.assume(applyPredicate(candidate));
            count++;
        }

        size = count;
        return size;
    }

    @NotNull
    @Override
    public Iterator<DataRow> iterator() {
        return new JoinedIterator(this);
    }

    @Override
    public DataRow first() {
        if (onMethod == null) return composite(leftTable.first(), rightTable.first());

        Iterator<DataRow> iter = iterator();
        if (iter.hasNext()) return iter.next();
        return null;
    }

    @Override
    public DataRow ensureFirst() {
        Iterator<DataRow> iter = iterator();
        Engine.assume(iter.hasNext());
        return iter.next();
    }
}
