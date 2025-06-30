package decoders.java.util;

import java.util.OptionalInt;

@SuppressWarnings({"unused", "OptionalUsedAsFieldOrParameterType"})
public final class OptionalInt_DecoderTests {

    public static int test_0(final OptionalInt obj) {
        if (!obj.isPresent())
            return 0;

        if (obj.getAsInt() == 32)
            return 1;

        return 2;
    }

}
