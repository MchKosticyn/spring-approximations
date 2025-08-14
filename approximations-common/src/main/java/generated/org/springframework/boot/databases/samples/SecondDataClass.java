package generated.org.springframework.boot.databases.samples;

import generated.org.springframework.boot.databases.saveupddel.SaveUpdDelCtx;

import java.util.List;

public class SecondDataClass {

    private Integer id;

    private List<FirstDataClass> subclasses;

    private Integer subclasses_id;
    private Integer oneToMany_id;

    public Object[] _buildIdFunction() {
        return null;
    }

    public SecondDataClass _copy() {
        return null;
    }

    public SecondDataClass(Object[] row) {

    }

    public static void _save(SecondDataClass t, SaveUpdDelCtx ctx) {

    }

    public static void _delete(SecondDataClass t, SaveUpdDelCtx ctx) {

    }
}
