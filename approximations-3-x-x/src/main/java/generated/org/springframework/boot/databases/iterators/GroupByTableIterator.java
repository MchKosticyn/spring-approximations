package generated.org.springframework.boot.databases.iterators;

import generated.org.springframework.boot.databases.CollectionTable;
import generated.org.springframework.boot.databases.GroupByTable;
import generated.org.springframework.boot.databases.ITable;
import org.usvm.api.Engine;

import java.util.ArrayList;
import java.util.Iterator;

public class GroupByTableIterator<T> implements Iterator<ITable<T>> {

    public GroupByTable<T> table;
    public Iterator<ArrayList<T>> groupsIter;


    public GroupByTableIterator(GroupByTable<T> table) {
        this.table = table;
        this.groupsIter = table.groups.iterator();
    }

    @Override
    public boolean hasNext() {
        return groupsIter.hasNext();
    }

    @Override
    public ITable<T> next() {
        Engine.assume(hasNext());
        return new CollectionTable<>(groupsIter.next());
    }
}
