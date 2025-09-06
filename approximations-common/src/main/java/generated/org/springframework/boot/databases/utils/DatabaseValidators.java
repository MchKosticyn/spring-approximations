package generated.org.springframework.boot.databases.utils;

import org.usvm.api.Engine;
import org.usvm.spring.api.SpringEngine;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

public class DatabaseValidators {

    public static Function<Object, Boolean> getIdValidator(Class<?> clazz) {
        if (clazz.equals(Boolean.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof Boolean);
                return v != null && (Boolean) v;
            };
        } else if (clazz.equals(Byte.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof Byte);
                return v != null && (Byte) v > 0;
            };
        } else if (clazz.equals(Short.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof Short);
                return v != null && (Short) v > 0;
            };
        } else if (clazz.equals(Integer.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof Integer);
                return v != null && (Integer) v > 0;
            };
        } else if (clazz.equals(Long.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof Long);
                return v != null && (Long) v > 0;
            };
        } else if (clazz.equals(Float.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof Float);
                return v != null && (Float) v > 0;
            };
        } else if (clazz.equals(Double.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof Double);
                return v != null && (Double) v > 0;
            };
        } else if (clazz.equals(String.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof String);
                return v != null && !((String) v).isEmpty();
            };
        } else if (clazz.equals(LocalDateTime.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof LocalDateTime);
                return v != null;
            };
        } else if (clazz.equals(LocalDate.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof LocalDate);
                return v != null;
            };
        } else if (clazz.equals(BigInteger.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof BigInteger);
                return v != null && !v.equals(BigInteger.ZERO);
            };
        } else if (clazz.equals(BigDecimal.class)) {
            return (Object v) -> {
                Engine.assume(v == null | v instanceof BigDecimal);
                return v != null && !v.equals(BigDecimal.ZERO);
            };
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
                Engine.assume(v instanceof String);
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

    @SuppressWarnings({"StatementWithEmptyBody"})
    public static void deprioritizeValue(Object v, Class<?> clazz) {
        if (clazz.equals(Boolean.class)) {
        } else if (clazz.equals(Byte.class)) {
        } else if (clazz.equals(Short.class)) {
        } else if (clazz.equals(Integer.class)) {
        } else if (clazz.equals(Long.class)) {
        } else if (clazz.equals(Float.class)) {
        } else if (clazz.equals(Double.class)) {
        } else if (clazz.equals(String.class)) {
            if (v == null) {
                SpringEngine.markAsBadPath();
                return;
            }

            Engine.assume(v instanceof String);
            int len = ((String) v).length();
            if (len <= 3 | len >= 10) {
                SpringEngine.markAsBadPath();
            }
        } else if (clazz.equals(LocalDateTime.class)) {
        } else if (clazz.equals(LocalDate.class)) {
        } else if (clazz.equals(BigInteger.class)) {
        } else if (clazz.equals(BigDecimal.class)) {
        } else {
            SpringEngine.println("[DB Warning] Unsupported soft validator for type");
        }
    }
}
