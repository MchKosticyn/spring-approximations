package stub.spring;

import jakarta.validation.Validator;
import org.hibernate.SessionFactory;

public class SpringDatabases {

    static {
        if (true) throw new LinkageError();
    }

    public static SessionFactory sessionFactory = null;
    public static Validator validator = null;
}
