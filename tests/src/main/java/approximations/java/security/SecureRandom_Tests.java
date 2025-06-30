package approximations.java.security;

import approximations.Test;

import java.lang.Object;
import java.lang.String;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandomSpi;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import java.security.SecureRandom;

@Test
@SuppressWarnings({"unused", "ResultOfMethodCallIgnored", "SizeReplaceableByIsEmpty"})
public final class SecureRandom_Tests {

    // internal variables

    // constructors

    /**
     * {@link java.security.SecureRandom#SecureRandom()}
     */
    @Test
    public static int test_SecureRandom_0(final int execution) {
        SecureRandom sr = new SecureRandom();
        sr.hashCode();

        return 0;
    }


    /**
     * {@link java.security.SecureRandom#SecureRandom(byte[])}
     */
    @Test(executionMax = 1)
    public static int test_SecureRandom_1(final int execution) {
        switch (execution) {
            case 0: {
                try {
                    SecureRandom sr = new SecureRandom(null);
                    return -1;
                } catch (NullPointerException e) {
                    // expected
                }
                break;
            }

            case 1: {
                byte[] seed = new byte[1];
                SecureRandom sr = new SecureRandom(seed);
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    // static methods

    /**
     * {@link java.security.SecureRandom#getInstance(String)}
     */
    @Test(executionMax = 2)
    public static int test_getInstance_0(final int execution) {
        switch (execution) {
            case 0: {
                try {
                    SecureRandom sr = SecureRandom.getInstance(null);
                    return -1;
                } catch (NullPointerException e) {
                    // expected
                } catch (NoSuchAlgorithmException e) {
                    return -2;
                }
                break;
            }

            case 1: {
                try {
                    // NOTE: this is a real algorithm name
                    SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
                } catch (NoSuchAlgorithmException e) {
                    return -1;
                }
                break;
            }

            case 2: {
                try {
                    // NOTE: a non-existing algorithm
                    SecureRandom sr = SecureRandom.getInstance("qwerty123");
                    return -1;
                } catch (NoSuchAlgorithmException e) {
                    // expected
                }
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.security.SecureRandom#getInstance(String, Provider)}
     */
    @Test(disabled = true, reason = "no approximations for Hashtable class yet")
    public static int test_getInstance_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#getInstance(String, SecureRandomParameters)}
     */
    @Test(disabled = true, reason = "method does not exist in Java8")
    public static int test_getInstance_2(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#getInstance(String, SecureRandomParameters, Provider)}
     */
    @Test(disabled = true, reason = "method does not exist in Java8")
    public static int test_getInstance_3(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#getInstance(String, SecureRandomParameters, String)}
     */
    @Test(disabled = true, reason = "method does not exist in Java8")
    public static int test_getInstance_4(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#getInstance(String, String)}
     */
    @Test(disabled = true)
    public static int test_getInstance_5(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#getInstanceStrong()}
     */
    @Test
    public static int test_getInstanceStrong_0(final int execution) {
        try {
            SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            // expected
        }
        return 0;
    }


    /**
     * {@link java.security.SecureRandom#getSeed(int)}
     */
    @Test(executionMax = 2)
    public static int test_getSeed_0(final int execution) {
        switch (execution) {
            case 0: {
                try {
                    SecureRandom.getSeed(-1);
                    return -1;
                } catch (NegativeArraySizeException e) {
                    // expected
                }
                break;
            }

            case 1: {
                byte[] b = SecureRandom.getSeed(0);

                if (b == null)
                    return -1;

                if (b.length != 0)
                    return -2;

                break;
            }

            case 2: {
                byte[] b = SecureRandom.getSeed(2);

                if (b == null || b.length != 2)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    // methods

    /**
     * {@link java.security.SecureRandom#doubles()}
     */
    @Test
    public static int test_doubles_0(final int execution) {
        DoubleStream s = new SecureRandom().doubles();

        if (s == null)
            return -1;

        return 0;
    }


    /**
     * {@link java.security.SecureRandom#doubles(double, double)}
     */
    @Test(disabled = true)
    public static int test_doubles_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#doubles(long)}
     */
    @Test(disabled = true)
    public static int test_doubles_2(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#doubles(long, double, double)}
     */
    @Test(disabled = true)
    public static int test_doubles_3(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#generateSeed(int)}
     */
    @Test(disabled = true)
    public static int test_generateSeed_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#getAlgorithm()}
     */
    @Test
    public static int test_getAlgorithm_0(final int execution) {
        // TODO: check the name?
        new SecureRandom().getAlgorithm();

        return 0;
    }


    /**
     * {@link java.security.SecureRandom#getParameters()}
     */
    @Test(disabled = true, reason = "method does not exist in Java8")
    public static int test_getParameters_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#getProvider()}
     */
    @Test
    public static int test_getProvider_0(final int execution) {
        // TODO: check the provider?
        new SecureRandom().getProvider();

        return 0;
    }


    /**
     * {@link java.security.SecureRandom#ints()}
     */
    @Test
    public static int test_ints_0(final int execution) {
        IntStream s = new SecureRandom().ints();

        if (s == null)
            return -1;

        return 0;
    }


    /**
     * {@link java.security.SecureRandom#ints(int, int)}
     */
    @Test(disabled = true)
    public static int test_ints_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#ints(long)}
     */
    @Test(disabled = true)
    public static int test_ints_2(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#ints(long, int, int)}
     */
    @Test(disabled = true)
    public static int test_ints_3(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#longs()}
     */
    @Test
    public static int test_longs_0(final int execution) {
        LongStream s = new SecureRandom().longs();

        if (s == null)
            return -1;

        return 0;
    }


    /**
     * {@link java.security.SecureRandom#longs(long)}
     */
    @Test(disabled = true)
    public static int test_longs_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#longs(long, long)}
     */
    @Test(disabled = true)
    public static int test_longs_2(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#longs(long, long, long)}
     */
    @Test(disabled = true)
    public static int test_longs_3(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#nextBoolean()}
     */
    @Test
    public static int test_nextBoolean_0(final int execution) {
        new SecureRandom().nextBoolean();

        return 0;
    }


    /**
     * {@link java.security.SecureRandom#nextBytes(byte[])}
     */
    @Test(disabled = true)
    public static int test_nextBytes_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#nextBytes(byte[], SecureRandomParameters)}
     */
    @Test(disabled = true, reason = "method does not exist in Java8")
    public static int test_nextBytes_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#nextDouble()}
     */
    @Test(disabled = true)
    public static int test_nextDouble_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#nextFloat()}
     */
    @Test(disabled = true)
    public static int test_nextFloat_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#nextGaussian()}
     */
    @Test(disabled = true)
    public static int test_nextGaussian_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#nextInt()}
     */
    @Test(disabled = true)
    public static int test_nextInt_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#nextInt(int)}
     */
    @Test(disabled = true)
    public static int test_nextInt_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#nextLong()}
     */
    @Test(disabled = true)
    public static int test_nextLong_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#reseed()}
     */
    @Test(disabled = true, reason = "method does not exist in Java8")
    public static int test_reseed_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#reseed(SecureRandomParameters)}
     */
    @Test(disabled = true, reason = "method does not exist in Java8")
    public static int test_reseed_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#setSeed(byte[])}
     */
    @Test(disabled = true)
    public static int test_setSeed_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#setSeed(long)}
     */
    @Test(disabled = true)
    public static int test_setSeed_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.security.SecureRandom#toString()}
     */
    @Test
    public static int test_toString_0(final int execution) {
        String str = new SecureRandom().toString();

        switch (execution) {
            case 0: {
                if (str == null)
                    return -1;
                break;
            }

            case 1: {
                if (str.length() == 0)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }

}
