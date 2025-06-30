package decoders.java.lang;

@SuppressWarnings({"unused", "UnnecessaryUnboxing"})
public final class Double_DecoderTests {

    public static int test_0(final Double obj) {
        if (obj.doubleValue() == 3.14d)
            return 0;

        if (obj.floatValue() == 2.7f)
            return 1;

        return 2;
    }

}
