package decoders.java.util;

import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings({"unused", "UnnecessaryUnboxing"})
public class LinkedHashSet_DecoderTests {

    public static int test_0(final LinkedHashSet<Integer> obj) {
        if (obj.isEmpty())
            return 0;

        if (obj.size() == 5)
            return 1;

        final Iterator<Integer> iter = obj.iterator();
        if (!iter.hasNext())
            return 2;

        final Integer value = iter.next();
        if (value == null)
            return 3;

        if (value.intValue() == 128)
            return 4;

        if (obj.size() == 2) {
            Integer[] numbers = new Integer[2];
            numbers = obj.toArray(numbers);

            final Integer a = 2;
            final Integer b = 4;

            final boolean b1 = a.equals(numbers[0]) && b.equals(numbers[1]);
            final boolean b2 = a.equals(numbers[1]) && b.equals(numbers[0]);
            if (b1 || b2)
                return 5;
        }

        return 6;
    }

}
