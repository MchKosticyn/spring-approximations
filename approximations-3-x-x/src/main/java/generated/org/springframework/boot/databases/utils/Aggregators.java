package generated.org.springframework.boot.databases.utils;

import generated.org.springframework.boot.SpringUtils;
import generated.org.springframework.boot.databases.MappedTable;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.function.BiFunction;

import static generated.org.springframework.boot.databases.utils.DatabaseSupportFunctions.getComparer;

public class Aggregators {

    public static Long count(MappedTable<Object[], Object[]> table) {
        Iterator<Object[]> iter = table.iterator();
        long count = 0;
        while (true) {
            // early out from aggregator
            if (!iter.hasNext()) break;
            Object[] next = iter.next();
            // nulls always ignored in aggregators
            if (next != null) count++;
        }

        // only COUNT returns 0 if table contains no elements or only nulls
        return count;
    }

    public static Double avg(MappedTable<Object[], Object[]> table) {
        Iterator<Object[]> tableIter = table.iterator();
        int count = 0;
        long sum = 0;
        while (true) {
            if (!tableIter.hasNext()) break;
            Object[] next = tableIter.next();
            if (next != null) {
                sum += ((Number) next[0]).longValue();
                count++;
            }
        }

        if (count == 0) return null;
        return (double) sum / (double) count;
    }

    public static Object min(MappedTable<Object[], Object[]> table, Class<?> clazz) {
        Object min = null;
        Iterator<Object[]> tableIter = table.iterator();
        while (true) {
            if (!tableIter.hasNext()) break;
            Object[] next = tableIter.next();
            if (next != null) {
                BiFunction<Object, Object, Integer> comparer = getComparer(clazz);
                int cmp = comparer.apply(min, next[0]);
                if (cmp > 0) min = next[0];
            }
        }

        return min;
    }

    public static Object max(MappedTable<Object[], Object[]> table, Class<?> clazz) {
        Object max = null;
        Iterator<Object[]> tableIter = table.iterator();
        while (true) {
            if (!tableIter.hasNext()) break;
            Object[] next = tableIter.next();
            if (next != null) {
                BiFunction<Object, Object, Integer> comparer = getComparer(clazz);
                int cmp = comparer.apply(max, next[0]);
                if (cmp < 0) max = next[0];
            }
        }

        return max;
    }

    // region sums

    public static Object sum(MappedTable<Object[], Object[]> table, Class<?> clazz) {
        if (clazz.equals(Long.class)) return long_sum(table);
        else if (clazz.equals(Double.class)) return double_sum(table);
        else if (clazz.equals(BigInteger.class)) return big_integer_sum(table);
        else if (clazz.equals(BigDecimal.class)) return big_decimal_sum(table);
        else {
            SpringUtils._internalLog("Unsupported type for aggregate SUM function", clazz.getName());
            return null;
        }
    }

    private static Long long_sum(MappedTable<Object[], Object[]> table) {
        // SUM of nulls or empty table is null
        Long sum = null;
        Iterator<Object[]> tableIter = table.iterator();
        while (true) {
            if (!tableIter.hasNext()) break;
            Object[] next = tableIter.next();
            if (next != null) {
                if (sum != null) sum += (long) next[0];
                else sum = (long) next[0];
            }
        }

        return sum;
    }

    private static Double double_sum(MappedTable<Object[], Object[]> table) {
        // SUM of nulls or empty table is null
        Double sum = null;
        Iterator<Object[]> tableIter = table.iterator();
        while (true) {
            if (!tableIter.hasNext()) break;
            Object[] next = tableIter.next();
            if (next != null) {
                if (sum != null) sum += (double) next[0];
                else sum = (double) next[0];
            }
        }

        return sum;
    }

    private static BigInteger big_integer_sum(MappedTable<Object[], Object[]> table) {
        // SUM of nulls or empty table is null
        BigInteger sum = null;
        Iterator<Object[]> tableIter = table.iterator();
        while (true) {
            if (!tableIter.hasNext()) break;
            Object[] next = tableIter.next();
            if (next != null) {
                if (sum != null) sum = sum.add((BigInteger) next[0]);
                else sum = (BigInteger) next[0];
            }
        }

        return sum;
    }

    private static BigDecimal big_decimal_sum(MappedTable<Object[], Object[]> table) {
        // SUM of nulls or empty table is null
        BigDecimal sum = null;
        Iterator<Object[]> tableIter = table.iterator();
        while (true) {
            if (!tableIter.hasNext()) break;
            Object[] next = tableIter.next();
            if (next != null) {
                if (sum != null) sum = sum.add((BigDecimal) next[0]);
                else sum = (BigDecimal) next[0];
            }
        }

        return sum;
    }

    // endregion

    // region statistic

    // TODO: not in JPA standard
    public static Double varPop(MappedTable<Object[], Object[]> table) {
        return null;
    }

    public static Double varSamp(MappedTable<Object[], Object[]> table) {
        return null;
    }

    public static Double stddevPop(MappedTable<Object[], Object[]> table) {
        return null;
    }

    public static Double stddevSamp(MappedTable<Object[], Object[]> table) {
        return null;
    }

    // endregion

    public static Boolean any(MappedTable<Object[], Object[]> table) {
        Iterator<Object[]> tableIter = table.iterator();
        while  (true) {
            if (!tableIter.hasNext()) break;
            if ((Boolean) (tableIter.next()[0])) return true;
        }

        return false;
    }

    public static Boolean every(MappedTable<Object[], Object[]> table) {
        Iterator<Object[]> tableIter = table.iterator();
        while (true) {
            if (!tableIter.hasNext()) break;
            if (!((Boolean) tableIter.next()[0])) return false;
        }

        return true;
    }
}
