package approximations.java.util;

import approximations.Test;

import java.util.OptionalDouble;

@Test
@SuppressWarnings({"unused", "ConstantValue"})
public final class OptionalDouble_Tests {

    @Test
    public static int test_empty_0(final int execution) {
        final OptionalDouble o = OptionalDouble.empty();

        if (o.orElse(2.d) == 2.d)
            return 0;

        return -1;
    }

    @Test
    public static int test_of_0(final int execution) {
        final OptionalDouble o = OptionalDouble.of(5.d);

        if (o.orElse(2.d) == 5.d)
            return 0;

        return -1;
    }

}
