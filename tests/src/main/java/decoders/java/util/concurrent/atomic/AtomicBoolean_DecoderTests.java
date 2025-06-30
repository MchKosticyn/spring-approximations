package decoders.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

@SuppressWarnings({"unused"})
public final class AtomicBoolean_DecoderTests {

    public static int test_0(final AtomicBoolean obj) {
        return obj.get() ? 0 : 1;
    }

}
