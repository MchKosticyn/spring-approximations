package generated.org.springframework.boot.databases.basetables;

import java.util.HashMap;
import java.util.Map;

public class TableTracker {

    public static Map<String, Integer> returnedIxs = new HashMap<>();

    public static <T> void tryTrack(String tableName, T value, int ix, Class<T> type) {
        if (returnedIxs.containsKey(tableName) && returnedIxs.get(tableName) >= ix) return;

        returnedIxs.put(tableName, ix);
        track(tableName, value, type, ix);
    }

    public static <T> void track(String tableName, T value, Class<T> type, int ix) {}
}
