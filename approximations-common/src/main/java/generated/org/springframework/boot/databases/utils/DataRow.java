package generated.org.springframework.boot.databases.utils;

import org.usvm.spring.api.SpringEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// Class that represents row in query
// For example:
//  Owner owner JOIN Pet pet ->
//      {
//          "owner": Some owner;
//          "pet": Some pet;
//      }
// So "SELECT pet.id FROM Pet pet" will lead "DataRow.get("pet").getId()"
public class DataRow {

    // We do not want use map because it is not full concrete and this fact leads forking
    private final List<String> entitiesNames; // full concrete, names too
    private final List<Object> entities;

    public DataRow(String name, Object entity) {
        this.entitiesNames = new ArrayList<String>() {{
            add(name);
        }};
        this.entities = new ArrayList<Object>() {{
            add(entity);
        }};
    }

    public static DataRow of(String name, Object entity) {
        return new DataRow(name, entity);
    }

    public static Function<Object, DataRow> ofLambda(String name) {
        return (Object entity) -> DataRow.of(name, entity);
    }

    public DataRow(List<String> entitiesNames, List<Object> entities) {
        this.entitiesNames = entitiesNames;
        this.entities = entities;
    }

    public DataRow(DataRow dataRow) {
        this.entitiesNames = dataRow.getEntitiesNames();
        this.entities = dataRow.getEntities();
    }

    public List<String> getEntitiesNames() {
        return new ArrayList<>(entitiesNames);
    }

    public List<Object> getEntities() {
        return new ArrayList<>(entities);
    }

    private int indexOf(String entityName, boolean withWarning) {
        for (int i = 0; i < entitiesNames.size(); i++) {
            String name = entitiesNames.get(i);
            if (entityName.equals(name)) return i;
        }

        if (withWarning) SpringEngine.println("[DB Warning] In DataRow on entity with name ");
        return -1;
    }

    private int indexOf(String entityName) {
        return indexOf(entityName, true);
    }

    public Object get(String entityName) {
        int ix = indexOf(entityName);
        return entities.get(ix);
    }

    public DataRow map(String entityName, Function<Object, Object> map) {
        int ix = indexOf(entityName);
        Object entity = entities.get(ix);
        Object newObject = map.apply(entity);
        entities.set(ix, newObject);

        return this;
    }

    // This merge function did not modify both objects
    public static DataRow merge(DataRow left, DataRow right) {
        return new DataRow(left).merge(right);
    }

    // This merge function modifies this object
    public DataRow merge(DataRow other) {
        if (other == null) return this;

        List<String> otherEntitiesNames = other.getEntitiesNames();
        List<Object> otherEntities = other.getEntities();
        for (int i = 0; i < otherEntitiesNames.size(); i++) {
            String entityName = otherEntitiesNames.get(i);
            Object entity = otherEntities.get(i);

            if (indexOf(entityName, false) != -1) {
                SpringEngine.println("[DB Warning] Both DataRows for merge contain entity with name: ");
            }
            entitiesNames.add(entityName);
            entities.add(entityName);
        }

        return this;
    }
}
