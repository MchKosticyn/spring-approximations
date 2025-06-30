package approximations.java.lang;

import approximations.Test;

import java.lang.Object;
import java.lang.String;

import java.lang.Float;

@Test
@SuppressWarnings({"unused", "deprecation", "UnnecessaryTemporaryOnConversionToString", "ConstantConditions",
        "divzero", "UnnecessaryUnboxing", "NumericOverflow", "PointlessBooleanExpression", "UnnecessaryBoxing"})
public final class Float_Tests {

    // internal variables

    // constructors

    /**
     * {@link java.lang.Float#Float(String)}
     */
    @Test(disabled = true)
    public static int test_Float_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.Float#Float(double)}
     */
    @Test
    public static int test_Float_1(final int execution) {
        if (new Float(1.0d).floatValue() != 1.0f)
            return -1;

        return 0;
    }


    /**
     * {@link java.lang.Float#Float(float)}
     */
    @Test
    public static int test_Float_2(final int execution) {
        if (new Float(1.0f).floatValue() != 1.0f)
            return -1;

        return 0;
    }


    // static methods

    /**
     * {@link java.lang.Float#compare(float, float)}
     */
    @Test(disabled = true)
    public static int test_compare_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.Float#floatToIntBits(float)}
     */
    @Test
    public static int test_floatToIntBits_0(final int execution) {
        Float.floatToIntBits(123f); // TODO: check the result
        return 0;
    }


    /**
     * {@link java.lang.Float#floatToRawIntBits(float)}
     */
    @Test
    public static int test_floatToRawIntBits_0(final int execution) {
        Float.floatToRawIntBits(123f); // TODO: check the result
        return 0;
    }


    /**
     * {@link java.lang.Float#hashCode(float)}
     */
    @Test
    public static int test_hashCode_0(final int execution) {
        Float.hashCode(123f); // TODO: check the result
        return 0;
    }


    /**
     * {@link java.lang.Float#intBitsToFloat(int)}
     */
    @Test
    public static int test_intBitsToFloat_0(final int execution) {
        Float.intBitsToFloat(0); // TODO: check the result
        return 0;
    }


    /**
     * {@link java.lang.Float#isFinite(float)}
     */
    @Test(executionMax = 3)
    public static int test_isFinite_0(final int execution) {
        switch (execution) {
            case 0: {
                if (Float.isFinite(0f) == false)
                    return -1;
                break;
            }

            case 1: {
                if (Float.isFinite(-123f) == false)
                    return -1;
                break;
            }

            case 2: {
                if (Float.isFinite(5f / 0f))
                    return -1;
                break;
            }

            case 3: {
                if (Float.isFinite(-1f / 0f))
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.Float#isInfinite(float)}
     */
    @Test(executionMax = 3)
    public static int test_isInfinite_0(final int execution) {
        switch (execution) {
            case 0: {
                if (Float.isInfinite(0f))
                    return -1;
                break;
            }

            case 1: {
                if (Float.isInfinite(-123f))
                    return -1;
                break;
            }

            case 2: {
                if (Float.isInfinite(5f / 0f) == false)
                    return -1;
                break;
            }

            case 3: {
                if (Float.isInfinite(-1f / 0f) == false)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.Float#isNaN(float)}
     */
    @Test(executionMax = 4)
    public static int test_isNaN_0(final int execution) {
        switch (execution) {
            case 0: {
                if (Float.isNaN(0f))
                    return -1;
                break;
            }

            case 1: {
                if (Float.isNaN(-123f))
                    return -1;
                break;
            }

            case 2: {
                if (Float.isNaN(5f / 0f))
                    return -1;
                break;
            }

            case 3: {
                if (Float.isNaN(-1f / 0f))
                    return -1;
                break;
            }

            case 4: {
                if (Float.isNaN(0f / 0f) == false)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.Float#max(float, float)}
     */
    @Test
    public static int test_max_0(final int execution) {
        if (Float.max(-2f, 7f) != 7f)
            return -1;

        return 0;
    }


    /**
     * {@link java.lang.Float#min(float, float)}
     */
    @Test
    public static int test_min_0(final int execution) {
        if (Float.min(-2f, 7f) != -2f)
            return -1;

        return 0;
    }


    /**
     * {@link java.lang.Float#parseFloat(String)}
     */
    @Test
    public static int test_parseFloat_0(final int execution) {
        // TODO: more test cases
        if (Float.parseFloat("3.1415926") != 3.1415926f)
            return -1;

        return 0;
    }


    /**
     * {@link java.lang.Float#sum(float, float)}
     */
    @Test
    public static int test_sum_0(final int execution) {
        if (Float.sum(-2f, 7f) != 5f)
            return -1;

        return 0;
    }


    /**
     * {@link java.lang.Float#toHexString(float)}
     */
    @Test(disabled = true)
    public static int test_toHexString_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.Float#toString(float)}
     */
    @Test(executionMax = 7)
    public static int test_toString_0(int execution) {
        switch (execution) {
            case 0: {
                if (!"0.0".equals(Float.toString(0.0f)))
                    return -1;
                break;
            }

            case 1: {
                if (!"-0.0".equals(Float.toString(-0.0f)))
                    return -1;
                break;
            }

            case 2: {
                if (!"1.0".equals(Float.toString(1.0f)))
                    return -1;
                break;
            }

            case 3: {
                if (!"0.1".equals(Float.toString(0.1f)))
                    return -1;
                break;
            }

            case 4: {
                if (!"Infinity".equals(Float.toString(Float.POSITIVE_INFINITY)))
                    return -1;
                break;
            }

            case 5: {
                if (!"-Infinity".equals(Float.toString(Float.NEGATIVE_INFINITY)))
                    return -1;
                break;
            }

            case 6: {
                if (!"NaN".equals(Float.toString(0f / 0f)))
                    return -1;
                break;
            }

            case 7: {
                if (!"23.34".equals(Float.toString(23.34F)))
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.Float#valueOf(String)}
     */
    @Test(disabled = true)
    public static int test_valueOf_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.Float#valueOf(float)}
     */
    @Test
    public static int test_valueOf_1(final int execution) {
        if (Float.valueOf(1.0f).floatValue() != 1.0f)
            return -1;

        return 0;
    }


    // methods

    /**
     * {@link java.lang.Float#byteValue()}
     */
    @Test
    public static int test_byteValue_0(final int execution) {
        if (new Float(123f).byteValue() != (byte) 123)
            return -1;

        return 0;
    }


    /**
     * {@link java.lang.Float#compareTo(Float)}
     */
    @Test(disabled = true)
    public static int test_compareTo_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.Float#doubleValue()}
     */
    @Test
    public static int test_doubleValue_0(final int execution) {
        if (new Float(123f).doubleValue() != 123d)
            return -1;

        return 0;
    }


    /**
     * {@link java.lang.Float#equals(Object)}
     */
    @Test(executionMax = 1)
    public static int test_equals_0(final int execution) {
        switch (execution) {
            case 0: {
                Float a = new Float(1f);
                Float b = new Float(2f);
                if (a.equals(b))
                    return -1;
                break;
            }

            case 1: {
                Float a = new Float(5f);
                Float b = new Float(5f);
                if (a.equals(b) == false)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.Float#hashCode()}
     */
    @Test(disabled = true)
    public static int test_hashCode_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.Float#intValue()}
     */
    @Test
    public static int test_intValue_0(final int execution) {
        if (new Float(2f).intValue() != 2)
            return -1;

        return 0;
    }


    /**
     * {@link java.lang.Float#isInfinite()}
     */
    @Test(executionMax = 3)
    public static int test_isInfinite_1(final int execution) {
        switch (execution) {
            case 0: {
                if (new Float(0f).isInfinite())
                    return -1;
                break;
            }

            case 1: {
                if (new Float(-123f).isInfinite())
                    return -1;
                break;
            }

            case 2: {
                if (new Float(5f / 0f).isInfinite() == false)
                    return -1;
                break;
            }

            case 3: {
                if (new Float(-1f / 0f).isInfinite() == false)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.Float#isNaN()}
     */
    @Test(executionMax = 4)
    public static int test_isNaN_1(final int execution) {
        switch (execution) {
            case 0: {
                if (new Float(0f).isNaN())
                    return -1;
                break;
            }

            case 1: {
                if (new Float(-123f).isNaN())
                    return -1;
                break;
            }

            case 2: {
                if (new Float(5f / 0f).isNaN())
                    return -1;
                break;
            }

            case 3: {
                if (new Float(-1f / 0f).isNaN())
                    return -1;
                break;
            }

            case 4: {
                if (new Float(0f / 0f).isNaN() == false)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.Float#longValue()}
     */
    @Test
    public static int test_longValue_0(final int execution) {
        if (new Float(321f).longValue() != 321L)
            return -1;

        return 0;
    }


    /**
     * {@link java.lang.Float#shortValue()}
     */
    @Test
    public static int test_shortValue_0(final int execution) {
        if (new Float(123f).shortValue() != (short) 123)
            return -1;

        return 0;
    }


    /**
     * {@link java.lang.Float#toString()}
     */
    @Test(executionMax = 3)
    public static int test_toString_1(final int execution) {
        // this method is implemented exactly the same as static Float.toString(float)
        switch (execution) {
            case 0: {
                if (!"0.0".equals(new Float(0.0f).toString()))
                    return -1;
                break;
            }

            case 1: {
                if (!"-0.0".equals(new Float(-0.0f).toString()))
                    return -1;
                break;
            }

            case 2: {
                if (!"1.0".equals(new Float(1.0f).toString()))
                    return -1;
                break;
            }

            case 3: {
                if (!"0.1".equals(new Float(0.1f).toString()))
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }

}
