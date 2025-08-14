package generated.org.springframework.boot.resolvers;

import generated.org.springframework.boot.SymbolicValueFactory;
import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import generated.org.springframework.boot.pinnedValues.PinnedValueStorage;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;
import org.usvm.api.Engine;
import org.usvm.spring.api.SpringEngine;

import java.lang.annotation.Annotation;
import java.util.List;

import static generated.org.springframework.boot.pinnedValues.PinnedValueSource.REQUEST_COOKIE;
import static generated.org.springframework.boot.pinnedValues.PinnedValueSource.REQUEST_HEADER;
import static generated.org.springframework.boot.pinnedValues.PinnedValueSource.REQUEST_MATRIX;
import static generated.org.springframework.boot.pinnedValues.PinnedValueSource.REQUEST_PARAM;
import static generated.org.springframework.boot.pinnedValues.PinnedValueSource.REQUEST_PATH_VARIABLE;

@Approximate(AbstractNamedValueMethodArgumentResolver.class)
public abstract class AbstractNamedValueMethodArgumentResolverImpl extends AbstractNamedValueMethodArgumentResolver {
    @Nullable
    private Object handleNullValue(String name, @Nullable Object value, Class<?> paramType) {
        // well be propagated to convertIfNecessary and symbolized there
        return value;
    }

    private static List<Object> getPinnedKeyOfParameterInner(MethodParameter parameter) {
        Annotation[] annotations = parameter.getParameterAnnotations();
        // TODO: Other annotations #AA
        PathVariable pathAnnotation = parameter.getParameterAnnotation(PathVariable.class);
        if (pathAnnotation != null)
            return List.of(pathAnnotation.name(), REQUEST_PATH_VARIABLE, pathAnnotation.required());

        RequestParam paramAnnotation = parameter.getParameterAnnotation(RequestParam.class);
        if (paramAnnotation != null)
            return List.of(paramAnnotation.name(), REQUEST_PARAM, paramAnnotation.required());

        RequestHeader headerAnnotation = parameter.getParameterAnnotation(RequestHeader.class);
        if (headerAnnotation != null)
            return List.of(headerAnnotation.name(), REQUEST_HEADER, headerAnnotation.required());

        MatrixVariable matrixAnnotation = parameter.getParameterAnnotation(MatrixVariable.class);
        if (matrixAnnotation != null)
            return List.of(matrixAnnotation.name(), REQUEST_MATRIX, matrixAnnotation.required());

        CookieValue cookieAnnotation = parameter.getParameterAnnotation(CookieValue.class);
        if (cookieAnnotation != null)
            return List.of(cookieAnnotation.name(), REQUEST_COOKIE, cookieAnnotation.required());

        SpringEngine.println("Warning! Unknown annotation! All annotations:");
        for (Annotation annotation : annotations) {
            SpringEngine.println(annotation.toString());
        }
        Engine.assume(false);
        throw new IllegalArgumentException();
    }

    private static List<Object> getPinnedKeyOfParameter(MethodParameter parameter) {
        List<Object> key = getPinnedKeyOfParameterInner(parameter);
        String name = (String)key.get(0);
        if (name == null || name.isEmpty()) {
            String parameterName = parameter.getParameter().getName();
            return List.of(parameterName, key.get(1), key.get(2));
        }
        return key;
    }

    @Nullable
    private static Object convertIfNecessary(
            MethodParameter parameter,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory,
            NamedValueInfo namedValueInfo,
            @Nullable Object arg
    ) throws Exception {
        // Return arg but not null because arg can be tracked
        if (arg == null)
            return arg;

        List<Object> key = getPinnedKeyOfParameter(parameter);
        String name = (String)key.get(0);
        PinnedValueSource source = (PinnedValueSource)key.get(1);
        boolean required = (boolean)key.get(2);
        Class<?> type = parameter.getParameterType();

        boolean nullable = !type.isPrimitive() && !required;
        Object value = SymbolicValueFactory.createValidSymbolic(type, nullable);

        if (type == String.class) {
            String stringValue = (String)value;
            Engine.assume(!stringValue.isEmpty());
        }

        PinnedValueStorage.writePinnedValue(source, name, value, type);
        return value;
    }
}
