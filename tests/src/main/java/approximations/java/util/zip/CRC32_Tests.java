package approximations.java.util.zip;

import approximations.Test;

import java.nio.ByteBuffer;
import java.util.zip.CRC32;

@Test
@SuppressWarnings({"unused"})
public final class CRC32_Tests {

    // internal variables

    // constructors

    // CRC32Automaton::CRC32
    @Test
    public static int test_CRC32_0(final int execution) {
        CRC32 crc32 = new CRC32();
        if (crc32.getValue() != 0)
            return -1;

        return 0;
    }


    // static methods

    // methods

    // CRC32Automaton::getValue
    @Test
    public static int test_getValue_0(final int execution) {
        CRC32 crc32 = new CRC32();
        if (crc32.getValue() != 0)
            return -1;

        return 0;
    }


    // CRC32Automaton::reset
    @Test
    public static int test_reset_0(final int execution) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        if (crc32.getValue() != 0)
            return -1;

        return 0;
    }


    // CRC32Automaton::update (ByteBuffer)
    @Test(executionMax = 3, disabled = true, reason = "DirectByteBuffer have no approximations for yet")
    public static int test_update_0(final int execution) {
        CRC32 crc32 = new CRC32();

        switch (execution) {
            case 0: {
                ByteBuffer buff = ByteBuffer.wrap(new byte[]{70, 111, 111} /* "Foo" */);
                crc32.update(buff);
                crc32.getValue(); // arbitrary value
                break;
            }

            case 1: {
                ByteBuffer buff = ByteBuffer.wrap(new byte[]{});
                crc32.update(buff);
                crc32.getValue(); // arbitrary value
                break;
            }

            case 2: {
                ByteBuffer buff = ByteBuffer.allocateDirect(10);
                crc32.update(buff);
                crc32.getValue(); // arbitrary value
                break;
            }

            case 3: {
                ByteBuffer buff = ByteBuffer.allocateDirect(10);
                buff.put((byte) 3);

                crc32.update(buff);
                crc32.getValue(); // arbitrary value
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    // CRC32Automaton::update (byte[])
    @Test(executionMax = 1, disabled = true, reason = "available only since Java 9")
    public static int test_update_1(final int execution) {
//        CRC32 crc32 = new CRC32();
//        switch (execution) {
//            case 0: {
//                byte[] byteArray = { 70, 105, 122, 122, 66, 117, 122, 122 }; // "FizzBuzz" as UTF8
//                crc32.update(byteArray);
//                long crc0 = crc32.getValue();
//                if (crc0 == 0) return -1;
//                crc32.reset();
//                crc0 = crc32.getValue();
//                if (crc0 != 0) return -1;
//                break;
//            }
//
//            case 1:
//                try {
//                    crc32.update(null);
//                    return -1;
//                } catch (NullPointerException e) {
//                    break;
//                }
//
//            default:
//                return 0;
//        }
        return execution;
    }


    // CRC32Automaton::update (byte[], int, int)
    @Test(executionMax = 2)
    public static int test_update_2(final int execution) {
        byte[] byteArray = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100}; // "Hello World" encoded as UTF8
        CRC32 crc32 = new CRC32();

        switch (execution) {
            case 0: {
                crc32.update(byteArray, 2, 5);
                crc32.getValue(); // arbitrary value

                crc32.reset();
                if (crc32.getValue() != 0)
                    return -1;
                break;
            }

            case 1: {
                try {
                    crc32.update(null, 0, 1);
                    return -1;
                } catch (NullPointerException e) {
                    // expected
                }
                break;
            }

            case 2: {
                try {
                    crc32.update(byteArray, 100, 1);
                    return -1;
                } catch (ArrayIndexOutOfBoundsException e) {
                    // expected
                }
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    // CRC32Automaton::update (int)
    @Test(executionMax = 1)
    public static int test_update_3(final int execution) {
        CRC32 crc32 = new CRC32();

        switch (execution) {
            case 0: {
                crc32.update(1);
                crc32.getValue(); // arbitrary value

                crc32.reset();
                if (crc32.getValue() != 0)
                    return -1;
                break;
            }

            case 1: {
                crc32.update(-1);
                crc32.getValue(); // arbitrary value

                crc32.reset();
                if (crc32.getValue() != 0)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }

}