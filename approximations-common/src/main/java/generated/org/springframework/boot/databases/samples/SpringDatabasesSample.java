package generated.org.springframework.boot.databases.samples;

import generated.org.springframework.boot.databases.basetables.BaseTableManager;
import generated.org.springframework.boot.databases.basetables.NoIdTableManager;
import jakarta.validation.Validator;
import org.hibernate.SessionFactory;

// Sample of generated SpringDatabases file
public class SpringDatabasesSample {
    public static SessionFactory sessionFactory;
    public static Validator validator;

    public static BaseTableManager<FirstDataClass, Integer> _blank1 = new BaseTableManager<>("_blank1");

    public static BaseTableManager<SecondDataClass, Integer> _blank2 = new BaseTableManager<>("_blank2");

    public static NoIdTableManager _blankAdd = new NoIdTableManager("_blanckAdd");

    static {
        // this should be called later
        _blank1.initialize(FirstDataClass.getDTOInfo());

        _blankAdd.initialize(Integer.class, Integer.class);
    }
}
