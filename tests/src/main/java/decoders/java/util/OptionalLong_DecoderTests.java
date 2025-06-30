package decoders.java.util;

import java.util.OptionalLong;

@SuppressWarnings({"unused", "OptionalUsedAsFieldOrParameterType"})
public final class OptionalLong_DecoderTests {

    public static int test_0(final OptionalLong obj) {
        if (!obj.isPresent())
            return 0;

        if (obj.getAsLong() == 256L)
            return 1;

        return 2;
    }

}
