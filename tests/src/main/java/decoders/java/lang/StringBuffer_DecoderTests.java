package decoders.java.lang;

@SuppressWarnings({"unused"})
public final class StringBuffer_DecoderTests {

    public static int test_0(final StringBuffer obj) {
        if (obj.length() != 3)
            return 0;

        String value = obj.toString();
        if ("ABC".equals(value))
            return 1;

        return 2;
    }

}
