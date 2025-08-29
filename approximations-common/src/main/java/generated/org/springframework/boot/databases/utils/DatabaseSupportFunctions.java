package generated.org.springframework.boot.databases.utils;

import org.usvm.spring.api.SpringEngine;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.BiFunction;

public class DatabaseSupportFunctions {

    // region Comparers

    static Integer basicComparer(Object left, Object right) {

        if (left != null && right != null) {
            SpringEngine.markAsGoodPath();
            return null;
        }

        if (left == null && right == null) return null;
        if (left == null) return -1;
        return 1; // right == null
    }

    static Integer compareWithPrio(Integer res) {
        if (res == 0) {
            SpringEngine.markAsGoodPath();
            return res;
        }

        SpringEngine.markAsBadPath();
        return res;
    }

    static Integer comparer(String left, String right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(Integer left, Integer right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(Long left, Long right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(Boolean left, Boolean right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(Float left, Float right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(Double left, Double right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(BigInteger left, BigInteger right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(BigDecimal left, BigDecimal right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(Byte left, Byte right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(Short left, Short right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(LocalDate left, LocalDate right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    static Integer comparer(LocalDateTime left, LocalDateTime right) {
        Integer base = basicComparer(left, right);
        return compareWithPrio(base == null ? left.compareTo(right) : base);
    }

    public static BiFunction<Object, Object, Integer> getComparer(Class<?> clazz) {
        if (clazz.equals(Boolean.class)) {
            return (Object l, Object r) -> comparer((Boolean) l, (Boolean) r);
        } else if (clazz.equals(Byte.class)) {
            return (Object l, Object r) -> comparer((Byte) l, (Byte) r);
        } else if (clazz.equals(Short.class)) {
            return (Object l, Object r) -> comparer((Short) l, (Short) r);
        } else if (clazz.equals(Integer.class)) {
            return (Object l, Object r) -> comparer((Integer) l, (Integer) r);
        } else if (clazz.equals(Long.class)) {
            return (Object l, Object r) -> comparer((Long) l, (Long) r);
        } else if (clazz.equals(Float.class)) {
            return (Object l, Object r) -> comparer((Float) l, (Float) r);
        } else if (clazz.equals(Double.class)) {
            return (Object l, Object r) -> comparer((Double) l, (Double) r);
        } else if (clazz.equals(String.class)) {
            return (Object l, Object r) -> comparer((String) l, (String) r);
        } else if (clazz.equals(LocalDateTime.class)) {
            return (Object l, Object r) -> comparer((LocalDateTime) l, (LocalDateTime) r);
        } else if (clazz.equals(LocalDate.class)) {
            return (Object l, Object r) -> comparer((LocalDate) l, (LocalDate) r);
        } else if (clazz.equals(BigInteger.class)) {
            return (Object l, Object r) -> comparer((BigInteger) l, (BigInteger) r);
        } else if (clazz.equals(BigDecimal.class)) {
            return (Object l, Object r) -> comparer((BigDecimal) l, (BigDecimal) r);
        } else {
            SpringEngine.println("[DB Warning] Unsupported type for databases comparer function");
            return null;
        }
    }

    // endregion

    // region Equals

    static Boolean equals(String left, String right) {
        return left.equals(right);
    }

    static Boolean equals(Integer left, Integer right) {
        return left.equals(right);
    }

    static Boolean equals(Long left, Long right) {
        return left.equals(right);
    }

    static Boolean equals(Boolean left, Boolean right) {
        return left.equals(right);
    }

    static Boolean equals(Float left, Float right) {
        return left.equals(right);
    }

    static Boolean equals(Double left, Double right) {
        return left.equals(right);
    }

    static Boolean equals(BigInteger left, BigInteger right) {
        return left.equals(right);
    }

    static Boolean equals(BigDecimal left, BigDecimal right) {
        return left.equals(right);
    }

    static Boolean equals(LocalDateTime left, LocalDateTime right) {
        return left.equals(right);
    }

    // endregion

    // region Like function

    // https://stackoverflow.com/a/54437062
    public static boolean like(String expr, String pattern, String esc, boolean caseSenc) {
        char escCh = esc == null ? null : esc.charAt(0);
        int exprLength = expr.length();
        int patternLength = pattern.length();

        if (exprLength == 0 || patternLength == 0) {
            return false;
        }

        boolean fuzzy = false;
        char lastCharOfExp = 0;
        int positionOfSource = 0;

        for (int i = 0; i < patternLength; i++) {
            char ch = pattern.charAt(i);

            boolean escape = false;
            if (lastCharOfExp == escCh) {
                if (ch == '%' || ch == '_') {
                    escape = true;
                }
            }

            if (!escape && ch == '%') {
                fuzzy = true;
            } else if (!escape && ch == '_') {
                if (positionOfSource >= exprLength) {
                    return false;
                }
                positionOfSource++;

            } else if (ch != escCh) {
                if (positionOfSource >= exprLength) {
                    return false;
                }

                if (lastCharOfExp == '%') {
                    int tp = expr.indexOf(ch);
                    if (tp == -1) {
                        return false;
                    }

                    if (tp >= positionOfSource) {
                        positionOfSource = tp + 1;
                        if (i == patternLength - 1 && positionOfSource < exprLength) {
                            return false;
                        }
                    } else {
                        return false;
                    }

                } else if (compareChars(expr.charAt(positionOfSource), ch, caseSenc)) {
                    positionOfSource++;

                } else {
                    return false;
                }
            }

            lastCharOfExp = ch;
        }

        return fuzzy || positionOfSource >= exprLength;
    }

    private static boolean compareChars(char l, char r, boolean caseSenc) {
        return caseSenc ?
                l == r
                : Character.toLowerCase(l) == Character.toLowerCase(r);
    }

    // endregion

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static LocalDate date(Timestamp time) {
        return time.toLocalDateTime().toLocalDate();
    }
}
