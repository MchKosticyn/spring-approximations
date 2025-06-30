package decoders.java.util;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({"unused", "UnnecessaryUnboxing"})
public final class ArrayList_DecoderTests {

    public static int test_0(final ArrayList<Integer> obj) {
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

        if (value.intValue() == 32)
            return 4;

        if (obj.size() == 2) {
            final Integer a = 2;
            final Integer b = 4;

            if (a.equals(obj.get(0)) && b.equals(obj.get(1)))
                return 5;
        }

        return 6;
    }

}
