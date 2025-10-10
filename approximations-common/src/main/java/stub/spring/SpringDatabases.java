package stub.spring;

import jakarta.persistence.EntityManager;
import jakarta.validation.Validator;
import org.hibernate.SessionFactory;

public class SpringDatabases {

    static {
        if (true) throw new LinkageError();
    }

    public static SessionFactory sessionFactory = null;
    public static Validator validator = null;
    public static EntityManager entityManager = null;
}
