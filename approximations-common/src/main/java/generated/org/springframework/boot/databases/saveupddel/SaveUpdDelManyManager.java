package generated.org.springframework.boot.databases.saveupddel;

import generated.org.springframework.boot.databases.basetables.BaseTableManager;
import generated.org.springframework.boot.databases.basetables.NoIdTableManager;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;

// T - type of objects to save, V - type of id field
public class SaveUpdDelManyManager<T, V> {

    private final SaveUpdDelCtx context;

    private final BaseTableManager<T, V> manager;

    private final BiConsumer<T, SaveUpdDelCtx> saveUpd; // nullable
    private final BiConsumer<T, SaveUpdDelCtx> delete; // nullable

    private final Object[] parentId; // nullable
    private final Function<T, Object[]> getTId; // nullable

    private int[] parentJoinIds;
    private int[] childJoinIds;

    public SaveUpdDelManyManager(
            SaveUpdDelCtx context,
            BaseTableManager<T, V> manager,
            BiConsumer<T, SaveUpdDelCtx> saveUpd, // nullable
            BiConsumer<T, SaveUpdDelCtx> delete, // nullable

            Object[] parentId, // nullable
            Function<T, Object[]> getTId // nullable
    ) {
        this.context = context;
        this.manager = manager;
        this.saveUpd = saveUpd;
        this.delete = delete;

        this.parentId = parentId;
        this.getTId = getTId;
    }

    public Object[] getId(T t) {
        return getTId.apply(t);
    }

    public void setParentJoinIds(int[] parentJoinIds) {
        this.parentJoinIds = parentJoinIds;
    }

    public void setChildJoinIds(int[] childJoinIds) {
        this.childJoinIds = childJoinIds;
    }

    public void setAllowRecursiveUpdate(boolean allowRecursiveUpdate) {
        context.setAllowRecursiveUpdate(allowRecursiveUpdate);
    }

    public void saveUpdWithoutRelationTable(Collection<T> objects, String[] names) {
        for (T t : objects) {
            saveUpd.accept(t, context);
            manager.changeFieldsByIdEnsure(getTId.apply(t), names, parentId);
        }
    }

    public void delWithoutRelationTable(Collection<T> objects) {
        for (T t : objects) {
            delete.accept(t, context);
        }
    }

    public void saveUpd(Collection<T> objects, NoIdTableManager relationTable) {
        for (T t : objects) {
            Object[] childId = getTId.apply(t);
            saveUpd.accept(t, context);

            Object[] relRow = new Object[parentJoinIds.length + childJoinIds.length];

            for (int i = 0; i < parentJoinIds.length; i++) {
                relRow[parentJoinIds[i]] = parentId[i];
            }

            for (int i = 0; i < childJoinIds.length; i++) {
                relRow[childJoinIds[i]] = childId[i];
            }

            relationTable.save(relRow);
        }
    }

    public void delete(Collection<T> objects, NoIdTableManager relationTable) {
        for (T t : objects) {
            Object[] childId = getTId.apply(t);
            delete.accept(t, context);

            Object[] relRow = new Object[parentJoinIds.length + childJoinIds.length];

            for (int i = 0; i < parentJoinIds.length; i++) {
                relRow[parentJoinIds[i]] = parentId[i];
            }

            for (int i = 0; i < childJoinIds.length; i++) {
                relRow[childJoinIds[i]] = childId[i];
            }

            relationTable.delete(relRow);
        }
    }
}
