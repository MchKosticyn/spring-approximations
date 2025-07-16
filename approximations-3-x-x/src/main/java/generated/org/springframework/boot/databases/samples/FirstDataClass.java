package generated.org.springframework.boot.databases.samples;

import generated.org.springframework.boot.databases.FiltredTable;
import generated.org.springframework.boot.databases.ITable;
import generated.org.springframework.boot.databases.MappedTable;
import generated.org.springframework.boot.databases.saveupddel.CrudManager;
import generated.org.springframework.boot.databases.saveupddel.SaveUpdDelCtx;
import generated.org.springframework.boot.databases.saveupddel.SaveUpdDelManyManager;
import generated.org.springframework.boot.databases.wrappers.ListWrapper;
import generated.org.springframework.boot.databases.wrappers.SetWrapper;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class FirstDataClass {

    private Integer id; // id field

    // generated
    public Integer _getId() {
        return id;
    }

    private SecondDataClass oneToOne; // via additional field 'oneToOne_id'

    private List<SecondDataClass> oneToMany; // via additional field 'oneToMany_id' in SecondDataClass
    private List<SecondDataClass> oneToManyAddTable; // via additional table

    private SecondDataClass manyToOne; // via additional field 'manyToOne_id'
    private List<SecondDataClass> manyToMany; // via additional table

    private Integer oneToOne_id; // generated fields
    private Set<Integer> oneToManySet; // ids for oneToMany from join table
    private Integer manyToOne_id;
    private Set<Integer> manyToManySet;

    public FirstDataClass(
            Object[] row, // row from 'FirstDataClassTable' that sorted by fields name

            // conditions from queries to subclasses.
            // fully correct initialized objects for which all fields were filled in at previous stages
            ITable<SecondDataClass> oneToOneCondition,
            ITable<SecondDataClass> oneToManyCondition,
            ITable<SecondDataClass> oneToManyAddTableCondition,
            ITable<SecondDataClass> manyToOneCondition,
            ITable<SecondDataClass> manyToManyCondition
    ) {
        this.id = (Integer) row[0];
        this.manyToOne_id = (Integer) row[1];
        this.oneToOne_id = (Integer) row[2];

        this.oneToOne = new FiltredTable<>(oneToOneCondition, this::_oneToOneFilter, new Object[0])
                .firstEnsure();

        this.oneToMany = new ListWrapper<>(
                new FiltredTable<>(
                        oneToManyCondition,
                        this::_oneToManyFilter,
                        new Object[0]
                )
        );

        this.oneToManySet = new SetWrapper<>(
                new MappedTable<>(
                        new FiltredTable<>(
                                SpringDatabasesSample._blankAdd,
                                this::_oneToManyAddTableFilter,
                                new Object[0]
                        ),
                        this::_oneToManyAddTableSelector,
                        Integer.class,
                        new Object[0]
                )
        );

        this.oneToManyAddTable = new ListWrapper<>(
                new FiltredTable<>(
                        oneToManyAddTableCondition,
                        this::_oneToManyAddTableFilter,
                        new Object[0]
                )
        );

        this.manyToOne = new FiltredTable<>(manyToOneCondition, this::_manyToOneFilter, new Object[0])
                .firstEnsure();

        this.manyToManySet = new SetWrapper<>(
                new MappedTable<>(
                        new FiltredTable<>(
                                SpringDatabasesSample._blankAdd,
                                this::_manyToManyAddTableFilter,
                                new Object[0]
                        ),
                        this::_manyToManyAddTableSelector,
                        Integer.class,
                        new Object[0]
                )
        );

        this.manyToMany = new ListWrapper<>(
                new FiltredTable<>(
                        manyToManyCondition,
                        this::_manyToManyFilter,
                        new Object[0]
                )
        );
    }

    public FirstDataClass(Object[] row) {
        this.id = (Integer) row[0];
        this.manyToOne_id = (Integer) row[1];
        this.oneToOne_id = (Integer) row[2];

        this.oneToOne = SpringDatabasesSample._blank2.getRowsWithValueAt(
                this.oneToOne_id,
                0 // index of id field in secondDataClass
        ).first(); // null or something

        this.oneToMany = new ListWrapper<>(
                SpringDatabasesSample._blank2.getRowsWithValueAt(
                        this.id,
                        2 // index of rel-field in secondDataClass
                )
        );

        this.oneToManyAddTable = new ListWrapper<>(
                SpringDatabasesSample._blank2.getRowsRelatedByTable(
                        this.id,
                        0,
                        SpringDatabasesSample._blankAdd)
        );

        this.manyToOne = SpringDatabasesSample._blank2.getRowsWithValueAt(
                this.manyToOne_id,
                0
        ).first();

        this.manyToMany = new ListWrapper<>(
                SpringDatabasesSample._blank2.getRowsRelatedByTable(
                        this.id,
                        0,
                        SpringDatabasesSample._blankAdd
                )
        );
    }

    // region Lambdas

    // generated lambdas where methodArgs are arrays of arguments from original repository method

    public Boolean _oneToOneFilter(SecondDataClass subclass, Object[] methodArgs) {
        return subclass._getId() == oneToOne_id;
    }

    public Boolean _oneToManyFilter(SecondDataClass subclass, Object[] methodArgs) {
        return id == subclass._getOneToMany_id();
    }

    public Boolean _oneToManyAddTableFilter(Object[] row, Object[] methodArgs) {
        return row[0] == id; // rows in between table that linked with this
    }

    // mapper to FirstDataClass oneToManyAddTable field
    //
    //  _additional table for join_
    // |  fdcId  |  ..  |  sdcId  | -> sdcId
    // |________|______|__________|
    public Integer _oneToManyAddTableSelector(Object[] row, Object[] methodArgs) {
        return (Integer) row[1];
    }

    public Boolean _oneToManyAddTableFilter(SecondDataClass subclass, Object[] methodArgs) {
        return oneToManySet.contains(subclass._getId());
    }

    public Boolean _manyToOneFilter(SecondDataClass subclass, Object[] methodArgs) {
        return subclass._getId() == manyToOne_id;
    }

    public Boolean _manyToManyAddTableFilter(Object[] row, Object[] methodArgs) {
        return row[0] == id;
    }

    public Integer _manyToManyAddTableSelector(Object[] row, Object[] methodArgs) {
        return (Integer) row[1];
    }

    public Boolean _manyToManyFilter(SecondDataClass subclass, Object[] methodArgs) {
        return manyToManySet.contains(subclass._getId());
    }

    // endregion

    // generated, for joined tables
    public Object[] _serilizer() {
        Object[] row = new Object[3];
        row[0] = id;
        row[1] = oneToOne_id;
        row[2] = manyToOne_id;
        return row;
    }

    // region SaveUpdateDelete

    // save + update
    // ctx is:
    //  - context - set with already saved addresses
    //  - allowRecursiveUpdate - may or not update this as subclass that depends on CascadeType
    @SuppressWarnings("unchecked")
    public static void _save(FirstDataClass t, SaveUpdDelCtx ctx) {

        if (ctx.contains(t)) return;

        CrudManager<FirstDataClass, Integer, Long> manager = new CrudManager<>(
                SpringDatabasesSample._blank1,
                FirstDataClass::_serilizer,
                FirstDataClass::new,
                FirstDataClass.class
        );

        ctx.add(t);
        manager.save(t, ctx.getAllowRecursiveUpdate());
        Integer t_id = t._getId();

        // manager for range mutation
        // needs to easier code generation
        SaveUpdDelManyManager<SecondDataClass, Integer, Integer> secondDataClassManager = new SaveUpdDelManyManager<>(
                ctx,
                SpringDatabasesSample._blank2,
                SecondDataClass::_save,
                SecondDataClass::_delete,
                t_id,
                SecondDataClass::_getId,
                0
        );

        // saves applies on subfields iff CascadeType it allows
        // block would be generated here iff relation's CascadeType it allows

        // simple saves (just by column relation here)

        // block 1, may be recursively updated from FirstDataClass::save
        ctx.setAllowRecursiveUpdate(true);
        SecondDataClass b1 = t.oneToOne;
        Integer b1_id = secondDataClassManager.getId(b1);
        SecondDataClass._save(b1, ctx);
        SpringDatabasesSample._blank2.changeSingleFieldByIdEnsure(t_id, 2, b1_id);// update null in oneToOne_id

        // block 2, can not be updated recursively
        ctx.setAllowRecursiveUpdate(false);
        SecondDataClass b2 = t.manyToOne;
        Integer b2_id = secondDataClassManager.getId(b2);
        SecondDataClass._save(b2, ctx);
        SpringDatabasesSample._blank2.changeSingleFieldByIdEnsure(t_id, 1, b2_id); // update null in manyToOne_id

        // block 3
        secondDataClassManager.setAllowRecursiveUpdate(true);
        secondDataClassManager.saveUpdWithoutRelationTable(t.oneToMany, 2);


        // not simple saves (use additional table)

        // block 4
        secondDataClassManager.setShouldShuffle(1);
        secondDataClassManager.setAllowRecursiveUpdate(false);
        secondDataClassManager.saveUpd(t.oneToManyAddTable, SpringDatabasesSample._blankAdd);

        // block 5
        secondDataClassManager.setShouldShuffle(0);
        secondDataClassManager.setAllowRecursiveUpdate(true);
        secondDataClassManager.saveUpd(t.manyToMany, SpringDatabasesSample._blankAdd);
    }

    @SuppressWarnings("unchecked")
    public static void _delete(FirstDataClass t, SaveUpdDelCtx ctx) {

        if (ctx.contains(t)) return;

        CrudManager<FirstDataClass, Integer, Long> manager = new CrudManager<>(
                SpringDatabasesSample._blank1,
                FirstDataClass::_serilizer,
                FirstDataClass::new,
                FirstDataClass.class
        );

        ctx.add(t);
        manager.delete(t);

        SecondDataClass._delete(t.oneToOne, ctx);
        SecondDataClass._delete(t.manyToOne, ctx);

        SaveUpdDelManyManager<SecondDataClass, Integer, Integer> secondDataClassManager = new SaveUpdDelManyManager<>(
                ctx,
                SpringDatabasesSample._blank2,
                SecondDataClass::_save,
                SecondDataClass::_delete,
                t._getId(),
                SecondDataClass::_getId,
                0
        );

        secondDataClassManager.delWithoutRelationTable(t.oneToMany);

        secondDataClassManager.delete(t.oneToManyAddTable, SpringDatabasesSample._blankAdd);

        secondDataClassManager.delete(t.manyToMany, SpringDatabasesSample._blankAdd);
    }

    // endregion
}
