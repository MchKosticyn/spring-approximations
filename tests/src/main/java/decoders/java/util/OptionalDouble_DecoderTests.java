package decoders.java.util;

import java.util.OptionalDouble;

@SuppressWarnings({"unused", "OptionalUsedAsFieldOrParameterType"})
public class OptionalDouble_DecoderTests {

    public static int test_0(final OptionalDouble obj) {
        if (!obj.isPresent())
            return 0;

        if (obj.getAsDouble() == 2.d)
            return 1;

        return 2;
    }

}
