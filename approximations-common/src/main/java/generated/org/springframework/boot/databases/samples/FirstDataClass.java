package generated.org.springframework.boot.databases.samples;

import generated.org.springframework.boot.databases.saveupddel.CrudManager;
import generated.org.springframework.boot.databases.saveupddel.SaveUpdDelCtx;
import generated.org.springframework.boot.databases.saveupddel.SaveUpdDelManyManager;
import generated.org.springframework.boot.databases.utils.DTOInfo;
import generated.org.springframework.boot.databases.utils.DatabaseSupportFunctions;
import generated.org.springframework.boot.databases.wrappers.IWrapper;
import generated.org.springframework.boot.databases.wrappers.immutable.ImmutableListWrapper;

import java.lang.reflect.Array;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class FirstDataClass {

    private Integer id; // id field

    private SecondDataClass oneToOne; // via additional field 'oneToOne_id'

    private List<SecondDataClass> oneToMany; // via additional field 'oneToMany_id' in SecondDataClass
    private List<SecondDataClass> oneToManyAddTable; // via additional table

    private SecondDataClass manyToOne; // via additional field 'manyToOne_id'
    private List<SecondDataClass> manyToMany; // via additional table

    private Integer oneToOne_id; // generated fields
    private Integer manyToOne_id;

    // Blank init
    public FirstDataClass() {

    }

    // We do not need copy in this function
    // because this is db setup
    public void _relationsInit() {

        this.oneToOne = SpringDatabasesSample._blank2.getValuesWithId(
                new Object[]{oneToOne_id}
        ).first();

        // When we decode entities from database we must be sure
        // that all related objects would be decoded too
        //
        // So by default we have chain: base -> idCheck -> validation -> track -> cache
        // This ensures that all necessary objects (which user received) in cache table
        //
        // To create relations between objects from database we use ONLY cache table
        // because in this case objects would contain all related entities during decoding
        this.oneToMany = new ImmutableListWrapper<>(
                SpringDatabasesSample._blank2.getValuesWithFields(
                        _buildIdFunction(),
                        new String[]{"oneToMany_id"}
                )
        );

        this.oneToManyAddTable = new ImmutableListWrapper<>(
                SpringDatabasesSample._blank2.getValuesRelatedByTable(
                        _buildIdFunction(),
                        SpringDatabasesSample._blankAdd,
                        new int[]{0},
                        new int[]{1}
                )
        );

        this.manyToOne = SpringDatabasesSample._blank2.getValuesWithId(
                new Object[]{manyToOne_id}
        ).first();

        this.manyToMany = new ImmutableListWrapper<>(
                SpringDatabasesSample._blank2.getValuesRelatedByTable(
                        _buildIdFunction(),
                        SpringDatabasesSample._blankAdd,
                        new int[]{0},
                        new int[]{1}
                )
        );
    }

    @SuppressWarnings("unchecked")
    public FirstDataClass _copy() {

        // After copying, it is very important to leave in chain cache table
        // because entities with ImmutableWrappers goes to track
        // and we must decode it with all their relations
        // (we can miss it by coping because it creates new refs)

        FirstDataClass newObj = new FirstDataClass();

        newObj._setId(id);
        newObj._setOneToOne(oneToOne._copy());

        List<SecondDataClass> oneToManyCopy = (List<SecondDataClass>) (
                ((IWrapper<SecondDataClass>) oneToMany).copy(SecondDataClass::_copy)
        );
        newObj._setOneToMany(oneToManyCopy);

        List<SecondDataClass> oneToManyAddTableCopy = (List<SecondDataClass>) (
                ((IWrapper<SecondDataClass>) oneToManyAddTable).copy(SecondDataClass::_copy)
        );
        newObj._setOneToManyAddTable(oneToManyAddTableCopy);

        newObj._setManyToOne(manyToOne._copy());

        List<SecondDataClass> manyToManyCopy = (List<SecondDataClass>) (
                ((IWrapper<SecondDataClass>) manyToMany).copy(SecondDataClass::_copy)
        );
        newObj._setManyToMany(manyToManyCopy);

        newObj._setOneToOne_id(oneToOne_id);
        newObj._setManyToOne_id(manyToOne_id);

        return newObj;
    }

    // Special getter and setter for id generation
    // Used iff id field single
    public Integer _getIdFunction() {
        return id;
    }

    public void _setIdFunction(Object id) {
        this.id = (Integer) id;
    }

    // Builds common id representation
    public Object[] _buildIdFunction() {
        return new Object[]{id};
    }

    // region Getters and Setters

    // Generated getters and setters
    public Integer _getId() {
        return id;
    }

    public SecondDataClass _getOneToOne() {
        return oneToOne;
    }

    public List<SecondDataClass> _getOneToMany() {
        return oneToMany;
    }

    public List<SecondDataClass> _getOneToManyAddTable() {
        return oneToManyAddTable;
    }

    public SecondDataClass _getManyToOne() {
        return manyToOne;
    }

    public List<SecondDataClass> _getManyToMany() {
        return manyToMany;
    }

    public Integer _getOneToOne_id() {
        return oneToOne_id;
    }

    public Integer _getManyToOne_id() {
        return manyToOne_id;
    }

    public void _setId(Integer id) {
        this.id = id;
    }

    public void _setOneToOne(SecondDataClass oneToOne) {
        this.oneToOne = oneToOne;
    }

    public void _setOneToMany(List<SecondDataClass> oneToMany) {
        this.oneToMany = oneToMany;
    }

    public void _setOneToManyAddTable(List<SecondDataClass> oneToManyAddTable) {
        this.oneToManyAddTable = oneToManyAddTable;
    }

    public void _setManyToOne(SecondDataClass manyToOne) {
        this.manyToOne = manyToOne;
    }

    public void _setManyToMany(List<SecondDataClass> manyToMany) {
        this.manyToMany = manyToMany;
    }

    public void _setOneToOne_id(Integer oneToOne_id) {
        this.oneToOne_id = oneToOne_id;
    }

    public void _setManyToOne_id(Integer manyToOne_id) {
        this.manyToOne_id = manyToOne_id;
    }

    // endregion

    // region SaveUpdateDelete

    // save + update
    // ctx is:
    //  - context - set with already saved addresses
    //  - allowRecursiveUpdate - may or not update this as subclass that depends on CascadeType
    @SuppressWarnings("unchecked")
    public static void _save(FirstDataClass t, SaveUpdDelCtx ctx) {

        if (ctx.contains(t)) return;

        CrudManager<FirstDataClass, Integer, Long> manager = new CrudManager<FirstDataClass, Integer, Long>(
                SpringDatabasesSample._blank1,
                null // cause id is single field we do not need special translator
        );

        ctx.add(t);
        manager.save(t, ctx.getAllowRecursiveUpdate());
        Object[] tId = t._buildIdFunction();

        // manager for range mutation
        // needs to easier code generation
        SaveUpdDelManyManager<SecondDataClass, Integer> secondDataClassManager = new SaveUpdDelManyManager<SecondDataClass, Integer>(
                ctx,
                SpringDatabasesSample._blank2,
                SecondDataClass::_save,
                SecondDataClass::_delete,
                tId,
                SecondDataClass::_buildIdFunction
        );

        // saves applies on subfields iff CascadeType it allows
        // block would be generated here iff relation's CascadeType it allows

        // simple saves (just by column relation here)

        // block 1, may be recursively updated from FirstDataClass::save
        ctx.setAllowRecursiveUpdate(true);
        SecondDataClass b1 = t.oneToOne;
        Object[] b1Id = secondDataClassManager.getId(b1);
        SecondDataClass._save(b1, ctx);
        SpringDatabasesSample._blank2.changeFieldsByIdEnsure(tId, new String[]{"oneToOne_id"}, b1Id); // update null in oneToOne_id

        // block 2, can not be updated recursively
        ctx.setAllowRecursiveUpdate(false);
        SecondDataClass b2 = t.manyToOne;
        Object[] b2Id = secondDataClassManager.getId(b2);
        SecondDataClass._save(b2, ctx);
        SpringDatabasesSample._blank2.changeFieldsByIdEnsure(tId, new String[]{"manyToOne_id"}, b2Id); // update null in manyToOne_id

        // block 3
        secondDataClassManager.setAllowRecursiveUpdate(true);
        secondDataClassManager.saveUpdWithoutRelationTable(t.oneToMany, new String[]{"oneToMany_id"});


        // not simple saves (use additional table)

        // block 4
        secondDataClassManager.setParentJoinIds(new int[]{0});
        secondDataClassManager.setChildJoinIds(new int[]{1});
        secondDataClassManager.setAllowRecursiveUpdate(false);
        secondDataClassManager.saveUpd(t.oneToManyAddTable, SpringDatabasesSample._blankAdd);

        // block 5
        secondDataClassManager.setParentJoinIds(new int[]{1});
        secondDataClassManager.setChildJoinIds(new int[]{0});
        secondDataClassManager.setAllowRecursiveUpdate(true);
        secondDataClassManager.saveUpd(t.manyToMany, SpringDatabasesSample._blankAdd);
    }

    @SuppressWarnings("unchecked")
    public static void _delete(FirstDataClass t, SaveUpdDelCtx ctx) {

        if (ctx.contains(t)) return;

        CrudManager<FirstDataClass, Integer, Long> manager = new CrudManager<FirstDataClass, Integer, Long>(
                SpringDatabasesSample._blank1,
                null // cause id is single field we do not need special translator
        );

        ctx.add(t);
        manager.delete(t);

        SecondDataClass._delete(t.oneToOne, ctx);
        SecondDataClass._delete(t.manyToOne, ctx);

        SaveUpdDelManyManager<SecondDataClass, Integer> secondDataClassManager = new SaveUpdDelManyManager<SecondDataClass, Integer>(
                ctx,
                SpringDatabasesSample._blank2,
                SecondDataClass::_save,
                SecondDataClass::_delete,
                t._buildIdFunction(),
                SecondDataClass::_buildIdFunction
        );

        secondDataClassManager.delWithoutRelationTable(t.oneToMany);

        secondDataClassManager.setParentJoinIds(new int[]{0});
        secondDataClassManager.setChildJoinIds(new int[]{1});
        secondDataClassManager.delete(t.oneToManyAddTable, SpringDatabasesSample._blankAdd);

        secondDataClassManager.setParentJoinIds(new int[]{1});
        secondDataClassManager.setChildJoinIds(new int[]{0});
        secondDataClassManager.delete(t.manyToMany, SpringDatabasesSample._blankAdd);
    }

    // endregion

    private static DTOInfo<FirstDataClass, Integer> _DTOInfo = null;

    @SuppressWarnings("unchecked")
    public static DTOInfo<FirstDataClass, Integer> getDTOInfo() {
        if (!DatabaseSupportFunctions.isNull(_DTOInfo)) return _DTOInfo;

        _DTOInfo = new DTOInfo<>(
                Integer.class,
                FirstDataClass.class,
                "_blank1",
                new String[]{"id"},
                true,
                true,

                FirstDataClass::new,
                FirstDataClass::_relationsInit,
                FirstDataClass::_buildIdFunction,
                FirstDataClass::_getIdFunction,
                FirstDataClass::_setIdFunction,

                FirstDataClass::_copy,
                new String[]{
                        "id",
                        "oneToOne",
                        "oneToMany",
                        "ontToManyAddTable",
                        "manyToOne",
                        "manyToMany",
                        "oneToOne_id",
                        "manyToOne_id"
                },

                // they must be filled
                (Function<FirstDataClass, Object>[]) Array.newInstance(Function.class, 8),
                (BiConsumer<FirstDataClass, Object>[]) Array.newInstance(BiConsumer.class, 8),

                new String[]{
                        "id"
                },
                new Class<?>[]{
                        Integer.class
                }
        );
        return _DTOInfo;
    }
}
