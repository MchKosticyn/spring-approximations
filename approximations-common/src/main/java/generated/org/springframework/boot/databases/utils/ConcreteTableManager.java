package generated.org.springframework.boot.databases.utils;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.Generator;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.metamodel.MappingMetamodel;
import org.hibernate.persister.entity.EntityPersister;
import stub.spring.SpringDatabases;

import java.util.List;

public class ConcreteTableManager<T> {

    private final Class<T> entityType;
    private final String className;

    private final List<T> userData;
    private final int userEntitiesSize;

    private final EntityPersister persister;
    private final Generator identifierGenerator;
    private int nextGeneratedIndex;

    private final String[] idFieldsNames;
    private final String[] relatedFieldsNames;

    private final String findAllJPQL;
    private final String findByIdJPQL;

    public ConcreteTableManager(Class<T> entityType, String[] idFieldsNames, String[] relatedFieldsNames) {
        this.entityType = entityType;
        this.className = entityType.getSimpleName();

        this.idFieldsNames = idFieldsNames;
        this.relatedFieldsNames = relatedFieldsNames;

        this.findAllJPQL = buildFindAllJPQL();
        this.findByIdJPQL = buildFindByIdJPQL();

        this.userData = getAllUsersEntities();
        this.userEntitiesSize = userData.size();

        this.persister = ((MappingMetamodel) SpringDatabases.sessionFactory.getMetamodel()).getEntityDescriptor(entityType);
        this.identifierGenerator = persister.getGenerator();
        this.nextGeneratedIndex = userEntitiesSize + 1;
    }

    public List<T> getUserData() { return userData; }

    public int getUserEntitiesSize() { return userEntitiesSize; }

    private StringBuilder selectWithFetch() {
        StringBuilder sb = new StringBuilder("SELECT e FROM " + className + " e");
        for (String field : relatedFieldsNames)
            sb.append(" JOIN FETCH e.").append(field);
        return sb;
    }

    private String buildFindAllJPQL() {
        return selectWithFetch().toString();
    }

    private String buildFindByIdJPQL() {
        StringBuilder sb = selectWithFetch().append(" WHERE");
        for (String column : idFieldsNames) {
            sb.append(" ? = e.").append(column);
        }
        return sb.toString();
    }

    public List<T> getAllUsersEntities() {
        try (Session s = SpringDatabases.sessionFactory.openSession()) {
            TypedQuery<T> query = s.createQuery(findAllJPQL, entityType);
            return query.getResultList();
        }
    }

    public T getUserEntityById(Object[] id) {
        try (Session s = SpringDatabases.sessionFactory.openSession()) {
            TypedQuery<T> query = s.createQuery(findByIdJPQL, entityType);
            for (int i = 0; i < id.length; i++)
                query.setParameter(i, id[i]);
            return query.getSingleResult();
        }
    }

    public Object generateNewId() {
        if (identifierGenerator instanceof IdentityGenerator)
            return nextGeneratedIndex++;

        try (Session s = SpringDatabases.sessionFactory.openSession()) {
            return ((IdentifierGenerator) identifierGenerator).generate((SharedSessionContractImplementor) s, null);
        }
    }
}
