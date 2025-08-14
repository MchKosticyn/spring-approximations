package generated.org.springframework.boot.databases.iterators;

import generated.org.springframework.boot.databases.JoinedTable;
import generated.org.springframework.boot.databases.utils.DataRow;
import org.usvm.api.Engine;

import java.util.Iterator;

public class JoinedIterator implements Iterator<DataRow> {

    private final JoinedTable joinedTable;

    private Iterator<DataRow> leftIter;
    private Iterator<DataRow> rightIter;

    private DataRow currLeft;
    private DataRow currComposited;

    private final boolean isEmpty;
    private boolean findedRight;

    public JoinedIterator(JoinedTable joinedTable) {
        this.joinedTable = joinedTable;

        this.findedRight = false;

        resetLeftIter();
        resetRightIter();

        this.isEmpty = !leftIter.hasNext() && !rightIter.hasNext();

        this.currLeft = isEmpty ? null : leftIter.next();
        this.currComposited = null;
    }

    private void resetLeftIter() {
        leftIter = joinedTable.getLeftTable().iterator();
    }

    private void resetRightIter() {
        rightIter = joinedTable.getRightTable().iterator();
    }

    @Override
    public boolean hasNext() {
        if (currComposited != null) return true;
        if (!isEmpty) return notEmptyHasNext();

        return false;
    }

    private boolean notEmptyHasNext() {
        while (rightIter.hasNext()) {
            DataRow right = rightIter.next();
            DataRow candidate = joinedTable.composite(currLeft, right);
            if (joinedTable.applyPredicate(candidate)) {
                findedRight = true;
                currComposited = candidate;
                return true;
            }
        }

        if (joinedTable.isLeft() && !findedRight) {
            findedRight = true;
            currComposited = joinedTable.composite(currLeft, null);
            return true;
        }

        if (leftIter.hasNext()) {
            resetRightIter();
            currLeft = leftIter.next();
            findedRight = false;

            return hasNext();
        }

        return false;
    }

    @Override
    public DataRow next() {
        Engine.assume(hasNext());

        DataRow tmp = currComposited;
        currComposited = null;
        return tmp;
    }
}
