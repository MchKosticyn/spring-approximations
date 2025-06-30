package generated.org.springframework.boot.pinnedValues;

public class PinnedValueStorage {
    private static void _writePinnedInner(String pinnedSourceName, String name, Object source, Class<?> clazz) {
        throw new IllegalStateException("This method must be approximated");
    }

    private static Object _readPinnedInner(String pinnedSourceName, String name, Class<?> clazz) {
        throw new IllegalStateException("This method must be approximated");
    }

    public static void writePinnedValue(PinnedValueSource source, Object value) {
        writePinnedValue(source, null, value);
    }

    public static void writePinnedValue(PinnedValueSource source, String name, Object value) {
        Class<?> clazz = value.getClass();
        writePinnedValue(source, name, value, clazz);
    }

    public static void writePinnedValue(PinnedValueSource source, String name, Object value, Class<?> clazz) {
        _writePinnedInner(source.name(), name, value, clazz);
    }

    public static <T> T getPinnedValue(PinnedValueSource source, Class<?> clazz) {
        return getPinnedValue(source, null, clazz);
    }

    @SuppressWarnings({"unchecked"})
    public static <T> T getPinnedValue(PinnedValueSource source, String name, Class<?> clazz) {
        return (T)_readPinnedInner(source.name(), name, clazz);
    }

    public static void preparePinnedValues() {
        throw new IllegalStateException("This method must be approximated");
    }
}
