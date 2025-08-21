package generated.org.springframework.boot.databases.utils;

import org.usvm.spring.api.SpringEngine;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

public class DatabaseValidators {

    public static Function<Object, Boolean> getIdValidator(Class<?> clazz) {
        if (clazz.equals(Boolean.class)) {
            return (Object v) -> v != null && (Boolean) v;
        } else if (clazz.equals(Byte.class)) {
            return (Object v) -> v != null && (Byte) v > 0;
        } else if (clazz.equals(Short.class)) {
            return (Object v) -> v != null && (Short) v > 0;
        } else if (clazz.equals(Integer.class)) {
            return (Object v) -> v != null && (Integer) v > 0;
        } else if (clazz.equals(Long.class)) {
            return (Object v) -> v != null && (Long) v > 0;
        } else if (clazz.equals(Float.class)) {
            return (Object v) -> v != null && (Float) v > 0;
        } else if (clazz.equals(Double.class)) {
            return (Object v) -> v != null && (Double) v > 0;
        } else if (clazz.equals(String.class)) {
            return (Object v) -> v != null && !((String) v).isEmpty();
        } else if (clazz.equals(LocalDateTime.class)) {
            return (Object v) -> v != null;
        } else if (clazz.equals(LocalDate.class)) {
            return (Object v) -> v != null;
        } else if (clazz.equals(BigInteger.class)) {
            return (Object v) -> v != null && !v.equals(BigInteger.ZERO);
        } else if (clazz.equals(BigDecimal.class)) {
            return (Object v) -> v != null && !v.equals(BigDecimal.ZERO);
        } else {
            throw new IllegalArgumentException("Unsupported id type validator");
        }
    }

    public static Function<Object, Boolean> getSoftValidator(Class<?> clazz) {
        if (clazz.equals(Boolean.class)) {
            return null;
        } else if (clazz.equals(Byte.class)) {
            return null;
        } else if (clazz.equals(Short.class)) {
            return null;
        } else if (clazz.equals(Integer.class)) {
            return null;
        } else if (clazz.equals(Long.class)) {
            return null;
        } else if (clazz.equals(Float.class)) {
            return null;
        } else if (clazz.equals(Double.class)) {
            return null;
        } else if (clazz.equals(String.class)) {
            return (Object v) -> {
                if (v == null) return false;
                int len = ((String) v).length();
                return len > 3 & len < 10;
            };
        } else if (clazz.equals(LocalDateTime.class)) {
            return null;
        } else if (clazz.equals(LocalDate.class)) {
            return null;
        } else if (clazz.equals(BigInteger.class)) {
            return null;
        } else if (clazz.equals(BigDecimal.class)) {
            return null;
        } else {
            SpringEngine.println("[DB Warning] Unsupported soft validator for type");
            return null;
        }
    }

    public static <T> boolean isDefaultValue(T value, Class<T> clazz) {
        return value.equals(Array.get(Array.newInstance(clazz, 1), 0));
    }
}
