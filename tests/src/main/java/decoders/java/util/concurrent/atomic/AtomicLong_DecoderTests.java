package decoders.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings({"unused"})
public final class AtomicLong_DecoderTests {

    public static int test_0(final AtomicLong obj) {
        return obj.get() == 16L ? 0 : 1;
    }

}
