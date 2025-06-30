package decoders.java.lang;

@SuppressWarnings({"unused", "UnnecessaryUnboxing"})
public final class Integer_DecoderTests {

    public static int test_0(final Integer obj) {
        if (obj.intValue() == 73)
            return 0;

        if ("37".equals(obj.toString()))
            return 1;

        return 2;
    }

}
