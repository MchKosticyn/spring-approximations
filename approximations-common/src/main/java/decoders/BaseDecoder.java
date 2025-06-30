package decoders;

import org.jacodb.api.jvm.*;
import org.usvm.api.decoder.DecoderApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Deprecated
@SuppressWarnings({"all", "unchecked"})
public abstract class BaseDecoder {

    protected static JcMethod getMethod(final List<JcMethod> methods,
                                        final String name,
                                        final String... types) {
        for (JcMethod m : methods)
            if (name.equals(m.getName()) && parametersMatch(m, types))
                return m;

        throw new InternalError("Method not found");
    }

    protected static boolean parametersMatch(final JcMethod method, final String... types) {
        final List<JcParameter> ps = method.getParameters();

        final int pCount = ps.size();
        if (pCount != types.length)
            return false;

        for (int i = 0; i < pCount; i++) {
            final String expected = types[i];
            final String actual = ps.get(i).getType().getTypeName();

            if (!expected.equals(actual))
                return false;
        }

        return true;
    }

    protected static JcMethod getConstructor(final JcClassOrInterface clazz,
                                             final String... types) {
        for (JcMethod m : clazz.getDeclaredMethods())
            if (m.isConstructor() && parametersMatch(m, types))
                return m;

        throw new InternalError("Constructor not found");
    }

    protected static JcField getField(final List<JcField> fields, final String name) {
        for (JcField f : fields)
            if (name.equals(f.getName()))
                return f;

        throw new InternalError("Field not found");
    }

    protected static JcClassOrInterface getClass(JcClasspath cp, String typeName) {
        final JcClassOrInterface clazz = cp.findClassOrNull(typeName);
        if (clazz == null)
            throw new InternalError("Class not found");

        return clazz;
    }

    protected static <T> T call(final DecoderApi<T> decoder,
                                final T instance,
                                final JcMethod method,
                                final T... values) {
        List<T> args = new ArrayList<>();
        args.add(instance);
        Collections.addAll(args, values);

        return decoder.invokeMethod(method, args);
    }

    protected static <T> T callStatic(final DecoderApi<T> decoder,
                                      final JcMethod method,
                                      final T... values) {
        return decoder.invokeMethod(method, Arrays.asList(values));
    }
}
