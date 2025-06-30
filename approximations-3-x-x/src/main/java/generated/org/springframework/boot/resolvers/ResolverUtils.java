package generated.org.springframework.boot.resolvers;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.util.UrlPathHelper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ResolverUtils {

    public static boolean isPrimitiveOrWrapper(Class<?> clazz) {
        List<Class<?>> primitives = Arrays.asList(
                Boolean.class,
                Byte.class,
                Short.class,
                Character.class,
                Integer.class,
                Long.class,
                Float.class,
                Double.class,
                String.class,
                LocalDate.class,
                LocalDateTime.class
        );
        return primitives.contains(clazz) || clazz.isPrimitive();
    }

    public static boolean supportsMatrix(NativeWebRequest request) {
        boolean removeSemicolon = UrlPathHelper.rawPathInstance.shouldRemoveSemicolonContent();
        boolean hasPathVariable = request.getContextPath().contains("{");
        return !removeSemicolon && hasPathVariable;
    }
}
