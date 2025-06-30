package approximations.java.lang;

import approximations.Test;

import java.util.ArrayList;
import java.util.Optional;

@Test
public final class StringBuffer_Tests {

    // internal variables

    // constructors

    // StringBufferAutomaton::StringBuffer
    @Test
    public static int test_StringBuffer_0(final int execution) {
        if (execution == 0) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() == 0)
                return 0;
            else
                return -1;
        }
        return -1;
    }


    // StringBufferAutomaton::StringBuffer (CharSequence)
    @Test(executionMax = 1)
    public static int test_StringBuffer_1(final int execution) {
        CharSequence sequence = "12";

        if (execution == 0) {
            StringBuffer stringBuffer = new StringBuffer(sequence);
            if (stringBuffer != null && stringBuffer.length() == 2 && stringBuffer.charAt(0) == '1' && stringBuffer.charAt(1) == '2')
                return 0;
            else
                return -1;
        }

        if (execution == 1) {
            sequence = null;
            try {
                StringBuffer stringBuffer = new StringBuffer(sequence);
            } catch (NullPointerException e) {
                return 1;
            }
            return -1;
        }
        return -1;
    }


    // StringBufferAutomaton::StringBuffer (String)
    @Test(executionMax = 1)
    public static int test_StringBuffer_2(final int execution) {
        String sequence = "12";

        if (execution == 0) {
            StringBuffer stringBuffer = new StringBuffer(sequence);
            if (stringBuffer != null && stringBuffer.length() == 2 && stringBuffer.charAt(0) == '1' && stringBuffer.charAt(1) == '2')
                return 0;
            else
                return -1;
        }

        if (execution == 1) {
            sequence = null;
            try {
                StringBuffer stringBuffer = new StringBuffer(sequence);
            } catch (NullPointerException e) {
                return 1;
            }
            return -1;
        }
        return -1;
    }


    // StringBufferAutomaton::StringBuffer (int)
    @Test
    public static int test_StringBuffer_3(final int execution) {
        int capacity = 4;
        StringBuffer stringBuffer = new StringBuffer(capacity);

        if (execution == 0) {
            if (stringBuffer.length() == 0)
                return 0;
            else
                return -1;
        }

        return -1;
    }


    // static methods

    // methods

    // StringBufferAutomaton::append (CharSequence)
    @Test(executionMax = 3)
    public static int test_append_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        CharSequence sequence_1 = null;
        stringBuffer.append(sequence_1);
        if (execution == 0) {
            if (stringBuffer.length() == 4 && stringBuffer.toString().equals("null"))
                return 0;
            else
                return -1;
        }

        CharSequence sequence_2 = "anystring1";
        stringBuffer.append(sequence_2);
        if (execution == 1) {
            if (stringBuffer.length() == 14 && stringBuffer.charAt(12) == 'g')
                return 1;
            else
                return -1;
        }

        CharSequence sequence_3 = "\u0441\u043B\u043E\u0432\u043E";
        stringBuffer.append(sequence_3);
        if (execution == 2) {
            if (stringBuffer.length() == 19 && stringBuffer.charAt(17) == sequence_3.charAt(3))
                return 2;
            else
                return -1;
        }

        CharSequence sequence_4 = new String(new int[]{80_000}, 0, 1);
        stringBuffer.append(sequence_4);
        if (execution == 3) {
            if (stringBuffer.length() == 21 && stringBuffer.charAt(12) == 'g')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (CharSequence, int, int)
    @Test(executionMax = 3)
    public static int test_append_1(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("test");
        CharSequence sequence_1 = null;
        stringBuffer.append(sequence_1, 1, 3);
        if (execution == 0) {
            if (stringBuffer.length() == 6 && stringBuffer.charAt(5) == 'l')
                return 0;
            else
                return -1;
        }

        CharSequence sequence_2 = "anystring1";
        stringBuffer.append(sequence_2, 0, 0);
        if (execution == 1) {
            if (stringBuffer.length() == 6 && stringBuffer.charAt(5) == 'l')
                return 1;
            else
                return -1;
        }

        CharSequence sequence_3 = "anystring1";
        if (execution == 2) {
            try {
                stringBuffer.append(sequence_3, 0, 1000);
            } catch (IndexOutOfBoundsException e) {
                return 2;
            }
            return -1;
        }

        CharSequence sequence_4 = new String(new int[]{80_000}, 0, 1);
        stringBuffer.append(sequence_4, 0, 1);
        if (execution == 3) {
            if (stringBuffer.length() == 7)
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (Object)
    @Test(executionMax = 3)
    public static int test_append_2(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        Object sequence_1 = null;
        stringBuffer.append(sequence_1);
        if (execution == 0) {
            if (stringBuffer.length() == 4 && stringBuffer.toString().equals("null"))
                return 0;
            else
                return -1;
        }

        Object sequence_2 = Optional.of(123456789);
        stringBuffer.append(sequence_2);
        if (execution == 1) {
            if (stringBuffer.toString().equals("null".concat(sequence_2.toString())))
                return 1;
            else
                return -1;
        }

        Object sequence_3 = "\u0441\u043B\u043E\u0432\u043E";
        stringBuffer.append(sequence_3);
        if (execution == 2) {
            if (stringBuffer.charAt(stringBuffer.length() - 1) == sequence_3.toString().charAt(4))
                return 2;
            else
                return -1;
        }

        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(-200);
        Object sequence_4 = a;
        stringBuffer.append(sequence_4);
        if (execution == 3) {
            if (stringBuffer.charAt(stringBuffer.length() - 1) == ']')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (String)
    @Test(executionMax = 3)
    public static int test_append_3(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        String sequence_1 = null;
        stringBuffer.append(sequence_1);
        if (execution == 0) {
            if (stringBuffer.length() == 4 && stringBuffer.toString().equals("null"))
                return 0;
            else
                return -1;
        }

        String sequence_2 = "anystring1";
        stringBuffer.append(sequence_2);
        if (execution == 1) {
            if (stringBuffer.length() == 14 && stringBuffer.charAt(12) == 'g')
                return 1;
            else
                return -1;
        }

        String sequence_3 = "\u0441\u043B\u043E\u0432\u043E";
        stringBuffer.append(sequence_3);
        if (execution == 2) {
            if (stringBuffer.length() == 19 && stringBuffer.charAt(17) == sequence_3.charAt(3))
                return 2;
            else
                return -1;
        }

        String sequence_4 = new String(new int[]{80_000}, 0, 1);
        stringBuffer.append(sequence_4);
        if (execution == 3) {
            if (stringBuffer.length() == 21 && stringBuffer.charAt(12) == 'g')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (StringBuffer)
    @Test(executionMax = 3)
    public static int test_append_4(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer sequence_1 = null;
        stringBuffer.append(sequence_1);
        if (execution == 0) {
            if (stringBuffer.length() == 4 && stringBuffer.toString().equals("null"))
                return 0;
            else
                return -1;
        }

        StringBuffer sequence_2 = new StringBuffer("anystring1");
        stringBuffer.append(sequence_2);
        if (execution == 1) {
            if (stringBuffer.length() == 14 && stringBuffer.charAt(12) == 'g')
                return 1;
            else
                return -1;
        }

        StringBuffer sequence_3 = new StringBuffer("\u0441\u043B\u043E\u0432\u043E");
        stringBuffer.append(sequence_3);
        if (execution == 2) {
            if (stringBuffer.length() == 19 && stringBuffer.charAt(17) == sequence_3.charAt(3))
                return 2;
            else
                return -1;
        }

        StringBuffer sequence_4 = new StringBuffer(new String(new int[]{80_000}, 0, 1));
        stringBuffer.append(sequence_4);
        if (execution == 3) {
            if (stringBuffer.length() == 21 && stringBuffer.charAt(12) == 'g')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (boolean)
    @Test(executionMax = 1)
    public static int test_append_5(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(false);
        if (execution == 0) {
            if (stringBuffer.length() == 5 && stringBuffer.toString().equals("false"))
                return 0;
            else
                return -1;
        }

        stringBuffer.append(true);
        if (execution == 1) {
            if (stringBuffer.length() == 9 && stringBuffer.toString().equals("falsetrue"))
                return 1;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (char)
    @Test(executionMax = 2)
    public static int test_append_6(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        char ch1 = 'b';
        stringBuffer.append(ch1);
        if (execution == 0) {
            if (stringBuffer.length() == 1 && stringBuffer.charAt(0) == 'b')
                return 0;
            else
                return -1;
        }

        char ch2 = '\u0434';
        stringBuffer.append(ch2);
        if (execution == 1) {
            if (stringBuffer.length() == 2 && stringBuffer.charAt(1) == '\u0434')
                return 1;
            else
                return -1;
        }

        char ch3 = '\\';
        stringBuffer.append(ch3);
        if (execution == 2) {
            if (stringBuffer.length() == 3 && stringBuffer.charAt(2) == '\\')
                return 2;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (char[])
    @Test(executionMax = 2)
    public static int test_append_7(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] ch1 = {'b', 'a', 'c'};
        stringBuffer.append(ch1);
        if (execution == 0) {
            if (stringBuffer.length() == 3 && stringBuffer.charAt(2) == 'c')
                return 0;
            else
                return -1;
        }

        char[] ch2 = {'!', '?', '.'};
        stringBuffer.append(ch2);
        if (execution == 1) {
            if (stringBuffer.length() == 6 && stringBuffer.charAt(5) == '.')
                return 1;
            else
                return -1;
        }

        char[] ch3 = {'\u0432'};
        stringBuffer.append(ch3);
        if (execution == 2) {
            if (stringBuffer.length() == 7 && stringBuffer.charAt(6) == '\u0432')
                return 2;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (char[], int, int)
    @Test(executionMax = 3)
    public static int test_append_8(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] ch1 = {'b', 'a', 'c'};
        stringBuffer.append(ch1, 1, 2);
        if (execution == 0) {
            if (stringBuffer.length() == 2 && stringBuffer.charAt(1) == 'c')
                return 0;
            else
                return -1;
        }

        char[] ch2 = {'!', '\u0432', '.'};
        stringBuffer.append(ch2, 0, 3);
        if (execution == 1) {
            if (stringBuffer.length() == 5 && stringBuffer.charAt(4) == '.')
                return 1;
            else
                return -1;
        }

        char[] ch3 = {'\u0430', '\u0431', '\u0432', '\u0433'};
        if (execution == 2) {
            try {
                stringBuffer.append(ch3, 1, -1);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 2;
            }
        }

        char[] ch4 = {'1', '2', '3'};
        if (execution == 3) {
            try {
                stringBuffer.append(ch4, 1, -1);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 3;
            }
        }

        return -1;
    }


    // StringBufferAutomaton::append (double)
    @Test(executionMax = 3)
    public static int test_append_9(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        int oldLength = stringBuffer.length();
        stringBuffer.append(1.000);
        if (execution == 0) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(oldLength) == '1')
                return 0;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.append(23.34);
        if (execution == 1) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(oldLength + 2) == '.')
                return 1;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.append(Double.MAX_VALUE);
        if (execution == 2) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == '8')
                return 2;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.append(12e-1);
        if (execution == 3) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(oldLength) == '1')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (float)
    @Test(executionMax = 3)
    public static int test_append_10(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        int oldLength = stringBuffer.length();
        stringBuffer.append(1.0F);
        if (execution == 0) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(0) == '1')
                return 0;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.append(23.34F);
        if (execution == 1) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(oldLength) == '2'
                    && stringBuffer.charAt(oldLength + 2) == '.')
                return 1;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.append(Float.MAX_VALUE);
        if (execution == 2) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == '8')
                return 2;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.append(12e-1F);
        if (execution == 3) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(oldLength) == '1')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (int)
    @Test(executionMax = 3)
    public static int test_append_11(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);

        if (execution == 0) {
            if (stringBuffer.length() == 1 && stringBuffer.charAt(0) == '1')
                return 0;
            else
                return -1;
        }

        stringBuffer.append(23);
        if (execution == 1) {
            if (stringBuffer.length() == 3 && stringBuffer.charAt(0) == '1' && stringBuffer.charAt(2) == '3')
                return 1;
            else
                return -1;
        }

        stringBuffer.append(Integer.MAX_VALUE);
        if (execution == 2) {
            if (stringBuffer.length() == 13 && stringBuffer.charAt(10) == '6' && stringBuffer.charAt(12) == '7')
                return 2;
            else
                return -1;
        }

        stringBuffer.append(-10);
        if (execution == 3) {
            if (stringBuffer.length() == 16 && stringBuffer.charAt(13) == '-' && stringBuffer.charAt(15) == '0')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::append (long)
    @Test(executionMax = 3)
    public static int test_append_12(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1L);

        if (execution == 0) {
            if (stringBuffer.length() == 1 && stringBuffer.charAt(0) == '1')
                return 0;
            else
                return -1;
        }

        stringBuffer.append(23L);
        if (execution == 1) {
            if (stringBuffer.length() == 3 && stringBuffer.charAt(0) == '1' && stringBuffer.charAt(2) == '3')
                return 1;
            else
                return -1;
        }

        stringBuffer.append(Long.MAX_VALUE);
        if (execution == 2) {
            if (stringBuffer.length() == 22 && stringBuffer.charAt(18) == '5' && stringBuffer.charAt(21) == '7')
                return 2;
            else
                return -1;
        }

        stringBuffer.append(-10L);
        if (execution == 3) {
            if (stringBuffer.length() == 25 && stringBuffer.charAt(22) == '-' && stringBuffer.charAt(23) == '1')
                return 3;
            else
                return -1;
        }
        return -1;
    }


    // StringBufferAutomaton::appendCodePoint (int)
    @Test(executionMax = 3)
    public static int test_appendCodePoint_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();

        if (execution == 0) {
            try {
                stringBuffer.appendCodePoint(-1);
                return -1;
            } catch (IllegalArgumentException e) {
                return 0;
            }
        }

        stringBuffer.appendCodePoint(65);
        if (execution == 1) {
            if (stringBuffer.length() == 1 && stringBuffer.charAt(0) == 'A')
                return 1;
            else
                return -1;
        }

        stringBuffer.appendCodePoint(1074);
        if (execution == 2) {
            if (stringBuffer.length() == 2 && stringBuffer.charAt(1) == '\u0432')
                return 2;
            else
                return -1;
        }

        stringBuffer.appendCodePoint(32);
        if (execution == 3) {
            if (stringBuffer.length() == 3 && stringBuffer.charAt(2) == ' ')
                return 3;
            else
                return -1;
        }
        return -1;
    }


    // StringBufferAutomaton::capacity
    @Test(executionMax = 3)
    public static int test_capacity_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        if (execution == 0) {
            if (stringBuffer.length() == 0)
                return 0;
            else
                return -1;
        }

        stringBuffer.append("test1");
        if (execution == 1) {
            if (stringBuffer.length() == 5)
                return 1;
            else
                return -1;
        }

        char[] space100 = new char[100];
        stringBuffer.append(space100);
        if (execution == 2) {
            if (stringBuffer.length() == 105)
                return 2;
            else
                return -1;
        }

        stringBuffer.append('\u0432');
        if (execution == 3) {
            if (stringBuffer.length() == 106)
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::charAt (int)
    @Test(executionMax = 3)
    public static int test_charAt_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("text for \u0442\u0435\u0441\u0442 0!");

        if (execution == 0) {
            try {
                stringBuffer.charAt(100);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 0;
            }
        }

        if (execution == 1) {
            try {
                stringBuffer.charAt(-2);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 1;
            }
        }

        if (execution == 2) {
            if (stringBuffer.charAt(9) == '\u0442')
                return 2;
            else
                return -1;
        }

        stringBuffer.append('\u0432');
        if (execution == 3) {
            if (stringBuffer.charAt(0) == 't')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::chars
    @Test(disabled = true)
    public static int test_chars_0(final int execution) {
        // FIXME: stream not implemented
        return -1;
    }


    // StringBufferAutomaton::codePointAt (int)
    @Test(executionMax = 2)
    public static int test_codePointAt_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();

        if (execution == 0) {
            try {
                stringBuffer.codePointAt(0);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.append("testtesttesttest");
        if (execution == 1) {
            try {
                stringBuffer.codePointAt(-1);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 1;
            }
        }

        if (execution == 2) {
            if (stringBuffer.codePointAt(2) <= 1114111 && stringBuffer.codePointAt(2) >= 0)
                return 2;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::codePointBefore (int)
    @Test(executionMax = 3)
    public static int test_codePointBefore_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();

        if (execution == 0) {
            try {
                stringBuffer.codePointBefore(0);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        if (execution == 1) {
            try {
                stringBuffer.codePointBefore(-1);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 1;
            }
        }

        stringBuffer.append("test");
        if (execution == 2) {
            if (stringBuffer.codePointBefore(4) <= 1114111 && stringBuffer.codePointBefore(4) >= 0)
                return 2;
            else
                return -1;
        }

        if (execution == 3) {
            if (stringBuffer.codePointBefore(1) <= 1114111 && stringBuffer.codePointBefore(1) >= 0)
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::codePointCount (int, int)
    @Test(executionMax = 3)
    public static int test_codePointCount_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();

        if (execution == 0) {
            try {
                stringBuffer.codePointCount(0, 2);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.append("test");
        if (execution == 1) {
            try {
                stringBuffer.codePointCount(4, 2);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 1;
            }
        }

        if (execution == 2) {
            try {
                stringBuffer.codePointCount(-1, 2);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 2;
            }
        }

        stringBuffer.append("test");
        if (execution == 3) {
            int startIndex = 2;
            int endIndex = 6;
            if (stringBuffer.codePointCount(startIndex, endIndex) >= (endIndex - startIndex) &&
                    stringBuffer.codePointCount(startIndex, endIndex) <= (endIndex - startIndex) * 2)
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::codePoints
    @Test(disabled = true)
    public static int test_codePoints_0(final int execution) {
        // FIXME: stream not implemented
        return -1;
    }


    // StringBufferAutomaton::compareTo (StringBuffer)
    @Test(executionMax = 4, disabled = true, reason = "available only since Java 11")
    public static int test_compareTo_0(final int execution) {
        /*
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer("aaaaaaaaaa");
        StringBuffer stringBuffer3 = new StringBuffer("bbbbb");
        StringBuffer stringBuffer4 = stringBuffer1;
        StringBuffer stringBuffer5 = new StringBuffer();
        StringBuffer stringBuffer6 = new StringBuffer("bbbbc");
        StringBuffer stringBuffer7 = new StringBuffer("bbbbb");

        if (execution == 0) {
            if (stringBuffer1.compareTo(stringBuffer4) == 0)
                return 0;
            else
                return -1;
        }

        if (execution == 1) {
            if (stringBuffer2.compareTo(stringBuffer1) > 0)
                return 1;
            else
                return -1;
        }

        if (execution == 2) {
            if (stringBuffer3.compareTo(stringBuffer2) > 0)
                return 2;
            else
                return -1;
        }

        if (execution == 3) {
            if (stringBuffer1.compareTo(stringBuffer5) == 0)
                return 3;
            else
                return -1;
        }

        if (execution == 4) {
            if (stringBuffer7.compareTo(stringBuffer6) < 0)
                return 4;
            else
                return -1;
        }

        return -1;
         */

        // WARNING: this method exists only since java-11
        return -1;
    }


    // StringBufferAutomaton::delete (int, int)
    @Test(executionMax = 3)
    public static int test_delete_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");

        if (execution == 0) {
            try {
                stringBuffer.delete(-1, 2);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.delete(1, 12);
        if (execution == 1) {
            if (stringBuffer.length() == 1 && stringBuffer.toString().equals("0"))
                return 1;
            else return -1;
        }

        stringBuffer.append("123456789");
        if (execution == 2) {
            try {
                stringBuffer.delete(2, 1);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 2;
            }
        }

        stringBuffer.delete(3, 7);
        if (execution == 3) {
            if (stringBuffer.length() == 6 && stringBuffer.charAt(3) == '7')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::deleteCharAt (int)
    @Test(executionMax = 3)
    public static int test_deleteCharAt_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");

        if (execution == 0) {
            try {
                stringBuffer.deleteCharAt(-1);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        if (execution == 1) {
            try {
                stringBuffer.deleteCharAt(10);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 1;
            }
        }

        stringBuffer.deleteCharAt(6);
        if (execution == 2) {
            if (stringBuffer.length() == 9 && stringBuffer.charAt(6) == '7')
                return 2;
            else
                return -1;

        }

        stringBuffer.deleteCharAt(8);
        if (execution == 3) {
            if (stringBuffer.length() == 8 && stringBuffer.charAt(7) == '8')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::ensureCapacity (int)
    @Test
    public static int test_ensureCapacity_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");

        if (execution == 0) {
            stringBuffer.ensureCapacity(1);
            if (stringBuffer.length() == 10)
                return 0;
            else return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::getChars (int, int, char[], int)
    @Test(executionMax = 2)
    public static int test_getChars_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};

        if (execution == 0) {
            try {
                stringBuffer.getChars(1, 12, chars, 1);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        if (execution == 1) {
            try {
                stringBuffer.getChars(1, 5, chars, 4);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 1;
            }
        }

        if (execution == 2) {
            stringBuffer.getChars(2, 4, chars, 1);
            if (chars[1] == stringBuffer.charAt(2) && chars[2] == stringBuffer.charAt(3))
                return 2;
            else
                return -1;

        }

        return -1;
    }


    // StringBufferAutomaton::indexOf (String)
    @Test(executionMax = 2)
    public static int test_indexOf_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456012341356");

        if (execution == 0) {
            if (stringBuffer.indexOf("12") == 1)
                return 0;
            else
                return -1;
        }

        if (execution == 1) {
            if (stringBuffer.indexOf("13") == 12)
                return 1;
            else
                return -1;
        }

        if (execution == 2) {
            if (stringBuffer.indexOf("aaa") == -1)
                return 2;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::indexOf (String, int)
    @Test(executionMax = 3)
    public static int test_indexOf_1(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("012345601234135612");

        if (execution == 0) {
            if (stringBuffer.indexOf("12", 4) == 8)
                return 0;
            else
                return -1;
        }

        if (execution == 1) {
            if (stringBuffer.indexOf("13", 13) == -1)
                return 1;
            else
                return -1;
        }

        if (execution == 2) {
            if (stringBuffer.indexOf("13", 20) == -1)
                return 2;
            else
                return -1;
        }

        if (execution == 3) {
            if (stringBuffer.indexOf("3", -100) == 3)
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, CharSequence)
    @Test(executionMax = 3)
    public static int test_insert_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        CharSequence sequence_1 = null;

        if (execution == 0) {
            try {
                stringBuffer.insert(5, sequence_1);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.insert(0, sequence_1);
        if (execution == 1) {
            if (stringBuffer.length() == 4 && stringBuffer.toString().equals("null"))
                return 1;
            else
                return -1;
        }

        CharSequence sequence_2 = "anystring1";
        stringBuffer.insert(1, sequence_2);
        if (execution == 2) {
            if (stringBuffer.length() == 14 && stringBuffer.charAt(1) == sequence_2.charAt(0))
                return 2;
            else
                return -1;
        }

        CharSequence sequence_3 = "\u0441\u043B\u043E\u0432\u043E";
        stringBuffer.insert(10, sequence_3);
        if (execution == 3) {
            if (stringBuffer.length() == 19 && stringBuffer.charAt(10) == '\u0441')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, CharSequence, int, int)
    @Test(executionMax = 3)
    public static int test_insert_1(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        CharSequence sequence_1 = null;

        if (execution == 0) {
            try {
                stringBuffer.insert(0, sequence_1, 3, 2);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.insert(0, sequence_1, 1, 3);
        if (execution == 1) {
            if (stringBuffer.length() == 2 && stringBuffer.toString().equals("ul"))
                return 1;
            else
                return -1;
        }

        CharSequence sequence_2 = "anystring1";

        stringBuffer.insert(1, sequence_2, 9, 10);
        if (execution == 2) {
            if (stringBuffer.length() == 3 && stringBuffer.charAt(1) == sequence_2.charAt(9))
                return 2;
            else
                return -1;
        }

        CharSequence sequence_3 = "\u0441\u043B\u043E\u0432\u043E";
        stringBuffer.insert(3, sequence_3, 2, 5);
        if (execution == 3) {
            if (stringBuffer.length() == 6 && stringBuffer.charAt(5) == '\u043E')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, Object)
    @Test(executionMax = 3)
    public static int test_insert_2(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        Object sequence_1 = null;

        if (execution == 0) {
            try {
                stringBuffer.insert(5, sequence_1);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.insert(0, sequence_1);
        if (execution == 1) {
            if (stringBuffer.length() == 4 && stringBuffer.toString().equals("null"))
                return 1;
            else
                return -1;
        }

        Object sequence_2 = Optional.of(123456789);

        stringBuffer.insert(1, sequence_2);
        if (execution == 2) {
            if (stringBuffer.length() == 4 + sequence_2.toString().length()
                    && stringBuffer.charAt(1) == sequence_2.toString().charAt(0))
                return 2;
            else
                return -1;
        }

        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(-200);
        Object sequence_3 = a;
        stringBuffer.insert(10, sequence_3);
        if (execution == 3) {
            if (stringBuffer.length() == 4 + sequence_2.toString().length() + a.toString().length()
                    && stringBuffer.charAt(10) == a.toString().charAt(0))
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, String)
    @Test(executionMax = 3)
    public static int test_insert_3(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        String sequence_1 = null;

        if (execution == 0) {
            try {
                stringBuffer.insert(5, sequence_1);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.insert(0, sequence_1);
        if (execution == 1) {
            if (stringBuffer.length() == 4 && stringBuffer.toString().equals("null"))
                return 1;
            else
                return -1;
        }

        String sequence_2 = Optional.of(987654321).toString();

        stringBuffer.insert(1, sequence_2);
        if (execution == 2) {
            if (stringBuffer.length() == 4 + sequence_2.length()
                    && stringBuffer.charAt(1) == sequence_2.charAt(0))
                return 2;
            else
                return -1;
        }


        String sequence_3 = new String(new int[]{80_000}, 0, 1);
        stringBuffer.insert(10, sequence_3);
        if (execution == 3) {
            if (stringBuffer.length() == 4 + sequence_2.toString().length() + 2
                    && stringBuffer.charAt(10) == sequence_3.charAt(0))
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, boolean)
    @Test(executionMax = 2)
    public static int test_insert_4(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();

        if (execution == 0) {
            try {
                stringBuffer.insert(5, false);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.insert(0, true);
        if (execution == 1) {
            if (stringBuffer.length() == 4 && stringBuffer.toString().equals("true"))
                return 1;
            else
                return -1;
        }

        stringBuffer.insert(2, false);
        if (execution == 2) {
            if (stringBuffer.length() == 9 && stringBuffer.toString().equals("trfalseue"))
                return 2;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, char)
    @Test(executionMax = 3)
    public static int test_insert_5(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        char ch1 = 'b';
        if (execution == 0) {
            try {
                stringBuffer.insert(5, ch1);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 0;
            }
        }

        char ch2 = '\u0434';
        stringBuffer.insert(0, ch2);
        if (execution == 1) {
            if (stringBuffer.length() == 1 && stringBuffer.charAt(0) == ch2)
                return 1;
            else
                return -1;
        }

        char ch3 = '\\';
        stringBuffer.insert(0, ch3);
        if (execution == 2) {
            if (stringBuffer.length() == 2 && stringBuffer.charAt(0) == ch3)
                return 2;
            else
                return -1;
        }

        stringBuffer.insert(1, ch1);
        if (execution == 3) {
            if (stringBuffer.length() == 3 && stringBuffer.charAt(1) == ch1)
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, char[])
    @Test(executionMax = 3)
    public static int test_insert_6(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] ch1 = {'b', 'a', 'c'};

        if (execution == 0) {
            try {
                stringBuffer.insert(2, ch1);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.insert(0, ch1);
        if (execution == 1) {
            if (stringBuffer.length() == ch1.length &&
                    stringBuffer.charAt(stringBuffer.length() - 1) == ch1[ch1.length - 1])
                return 1;
            else
                return -1;
        }

        char[] ch3 = {'\u0432', '\u0433'};
        stringBuffer.insert(2, ch3);
        if (execution == 2) {
            if (stringBuffer.length() == ch1.length + ch3.length &&
                    stringBuffer.charAt(stringBuffer.length() - 1) == ch1[ch1.length - 1] &&
                    stringBuffer.charAt(2) == ch3[0])
                return 2;
            else
                return -1;
        }

        char[] ch0 = null;
        if (execution == 3) {
            try {
                stringBuffer.insert(0, ch0);
                return -1;
            } catch (NullPointerException e) {
                return 3;
            }
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, char[], int, int)
    @Test(executionMax = 3)
    public static int test_insert_7(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] ch1 = {'b', 'a', '\u0446', '\u0434', 'e', 'f'};

        if (execution == 0) {
            try {
                stringBuffer.insert(2, ch1, 1, 3);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.insert(0, ch1, 2, 4);
        if (execution == 1) {
            if (stringBuffer.length() == 4 &&
                    stringBuffer.charAt(stringBuffer.length() - 1) == ch1[ch1.length - 1])
                return 1;
            else
                return -1;
        }

        char[] ch3 = {'0', '1', '2', '3'};
        stringBuffer.insert(2, ch3, 1, 1);
        if (execution == 2) {
            if (stringBuffer.length() == 5 &&
                    stringBuffer.charAt(2) == ch3[1])
                return 2;
            else
                return -1;
        }

        char[] ch0 = null;
        if (execution == 3) {
            try {
                stringBuffer.insert(0, ch0);
                return -1;
            } catch (NullPointerException e) {
                return 3;
            }
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, double)
    @Test(executionMax = 4)
    public static int test_insert_8(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        if (execution == 0) {
            try {
                stringBuffer.insert(5, 1.0);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        int oldLength = stringBuffer.length();
        stringBuffer.insert(0, 1.05);
        if (execution == 1) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(0) == '1')
                return 1;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.insert(3, 23.000);
        if (execution == 2) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(3) == '2')
                return 2;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.insert(8, Double.MAX_VALUE);
        if (execution == 3) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(8) == '1')
                return 3;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.insert(0, 12E-1);
        if (execution == 4) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(1) == '.')
                return 4;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, float)
    @Test(executionMax = 4)
    public static int test_insert_9(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        if (execution == 0) {
            try {
                stringBuffer.insert(5, 1.0f);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        int oldLength = stringBuffer.length();
        stringBuffer.insert(0, 1.05f);
        if (execution == 1) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(0) == '1')
                return 1;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.insert(3, 23.000f);
        if (execution == 2) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(3) == '2')
                return 2;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.insert(8, Float.MAX_VALUE);
        if (execution == 3) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(8) == '3')
                return 3;
            else
                return -1;
        }
        oldLength = stringBuffer.length();

        stringBuffer.insert(0, 12E-1);
        if (execution == 4) {
            if (stringBuffer.length() - oldLength > 0 && stringBuffer.charAt(1) == '.')
                return 4;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, int)
    @Test(executionMax = 3)
    public static int test_insert_10(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        if (execution == 0) {
            try {
                stringBuffer.insert(5, 1);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.insert(0, 1234);
        if (execution == 1) {
            if (stringBuffer.length() == 4 && stringBuffer.charAt(0) == '1')
                return 1;
            else
                return -1;
        }

        stringBuffer.insert(3, -239);
        if (execution == 2) {
            if (stringBuffer.length() == 8 && stringBuffer.charAt(3) == '-')
                return 2;
            else
                return -1;
        }

        stringBuffer.insert(8, Integer.MAX_VALUE);
        if (execution == 3) {
            if (stringBuffer.length() == 18 && stringBuffer.charAt(8) == '2')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::insert (int, long)
    @Test(executionMax = 3)
    public static int test_insert_11(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();
        if (execution == 0) {
            try {
                stringBuffer.insert(5, 1L);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 0;
            }
        }

        stringBuffer.insert(0, 1234L);
        if (execution == 1) {
            if (stringBuffer.length() == 4 && stringBuffer.charAt(0) == '1')
                return 1;
            else
                return -1;
        }

        stringBuffer.insert(3, -239L);
        if (execution == 2) {
            if (stringBuffer.length() == 8 && stringBuffer.charAt(3) == '-')
                return 2;
            else
                return -1;
        }

        stringBuffer.insert(8, Long.MAX_VALUE);
        if (execution == 3) {
            if (stringBuffer.length() == 27 && stringBuffer.charAt(8) == '9')
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::lastIndexOf (String)
    @Test(executionMax = 2)
    public static int test_lastIndexOf_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456012341356");

        if (execution == 0) {
            if (stringBuffer.lastIndexOf("12") == 8)
                return 0;
            else
                return -1;
        }

        if (execution == 1) {
            if (stringBuffer.lastIndexOf("13") == 12)
                return 1;
            else
                return -1;
        }

        if (execution == 2) {
            if (stringBuffer.lastIndexOf("aaa") == -1)
                return 2;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::lastIndexOf (String, int)
    @Test
    public static int test_lastIndexOf_1(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456012341356");

        if (execution == 0) {
            if (stringBuffer.lastIndexOf("12", 20) == 8)
                return 0;
            else
                return -1;
        }

        if (execution == 1) {
            if (stringBuffer.lastIndexOf("13", 5) == -1)
                return 1;
            else
                return -1;
        }

        if (execution == 2) {
            if (stringBuffer.lastIndexOf("12", 7) == 1)
                return 2;
            else
                return -1;
        }

        if (execution == 3) {
            if (stringBuffer.lastIndexOf("12", -1) == -1)
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::length
    @Test(executionMax = 2)
    public static int test_length_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("123456");

        if (execution == 0) {
            if (stringBuffer.length() == 6)
                return 0;
            else
                return -1;
        }

        stringBuffer.append("aaaa");
        if (execution == 1) {
            if (stringBuffer.length() == 10)
                return 1;
            else
                return -1;
        }

        StringBuffer stringBuffer0 = new StringBuffer();
        if (execution == 2) {
            if (stringBuffer0.length() == 0)
                return 2;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::offsetByCodePoints (int, int)
    @Test(executionMax = 3)
    public static int test_offsetByCodePoints_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("123456\u0431\u0432\u0433\u0434bvgd");

        if (execution == 0) {
            try {
                stringBuffer.offsetByCodePoints(2, -3);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 0;
            }
        }

        if (execution == 1) {
            try {
                stringBuffer.offsetByCodePoints(2, 20);
                return -1;
            } catch (IndexOutOfBoundsException e) {
                return 1;
            }
        }

        if (execution == 2) {
            if (stringBuffer.offsetByCodePoints(2, 5) == 7)
                return 2;
            else
                return -1;
        }

        if (execution == 3) {
            if (stringBuffer.offsetByCodePoints(13, -2) == 11)
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::replace (int, int, String)
    @Test(executionMax = 3)
    public static int test_replace_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");

        stringBuffer.replace(10, 20, "a");
        if (execution == 0) {
            if (stringBuffer.charAt(10) == 'a' && stringBuffer.length() == 11) return 0;
            else return -1;
        }

        stringBuffer.replace(6, 6, "bbb");
        if (execution == 1) {
            if (stringBuffer.charAt(6) == 'b' && stringBuffer.charAt(9) == '6' && stringBuffer.length() == 14)
                return 1;
            else
                return -1;
        }

        stringBuffer.replace(1, 5, "v");
        if (execution == 2) {
            if (stringBuffer.charAt(1) == 'v' && stringBuffer.charAt(2) == '5' && stringBuffer.length() == 11)
                return 2;
            else
                return -1;
        }

        if (execution == 3) {
            try {
                stringBuffer.replace(15, 5, "v");
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 3;
            }
        }

        return -1;
    }


    // StringBufferAutomaton::reverse
    @Test(executionMax = 3)
    public static int test_reverse_0(final int execution) {
        String s1 = "0123456789";
        String s2 = "9876543210";
        StringBuffer stringBuffer = new StringBuffer(s1);
        stringBuffer.reverse();
        if (execution == 0) {
            if (stringBuffer.length() == 10 && stringBuffer.toString().equals(s2)) return 0;
            else return -1;
        }

        StringBuffer stringBuffer2 = new StringBuffer();

        if (execution == 1) {
            try {
                stringBuffer2.reverse();
                return 1;
            } catch (Exception e) {
                return -1;
            }
        }

        String sur1 = "\uD83D\uDE00 \uD83D\uDE0B \uDC00\uD800";
        String sur2 = "\uD800\uDC00 \uD83D\uDE0B \uD83D\uDE00";
        String sur3 = "\uD83D\uDE00 \uD83D\uDE0B \uD800\uDC00";

        StringBuffer surBuf = new StringBuffer(sur1);
        surBuf.reverse();
        if (execution == 2) {
            if (surBuf.toString().equals(sur2))
                return 2;
            else
                return -1;
        }

        surBuf.reverse();
        if (execution == 3) {
            if (surBuf.toString().equals(sur3))
                return 3;
            else
                return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::setCharAt (int, char)
    @Test(executionMax = 3)
    public static int test_setCharAt_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");

        stringBuffer.setCharAt(2, 'a');
        if (execution == 0) {
            if (stringBuffer.charAt(2) == 'a' && stringBuffer.length() == 10) return 0;
            else return -1;
        }

        stringBuffer.setCharAt(6, '?');
        if (execution == 1) {
            if (stringBuffer.charAt(6) == '?' && stringBuffer.length() == 10)
                return 1;
            else
                return -1;
        }

        stringBuffer.setCharAt(9, '\u0432');
        if (execution == 2) {
            if (stringBuffer.charAt(9) == '\u0432' && stringBuffer.length() == 10)
                return 2;
            else
                return -1;
        }

        if (execution == 3) {
            try {
                stringBuffer.setCharAt(15, 'v');
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 3;
            }
        }

        return -1;
    }


    // StringBufferAutomaton::setLength (int)
    @Test(executionMax = 3)
    public static int test_setLength_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.setLength(10);
        if (execution == 0) {
            if (stringBuffer.length() == 10) return 0;
            else return -1;
        }

        stringBuffer.setLength(0);
        if (execution == 1) {
            if (stringBuffer.length() == 0) return 1;
            else return -1;
        }

        stringBuffer.append("aaaa");
        stringBuffer.setLength(6);
        if (execution == 2) {
            if (stringBuffer.length() == 6 && stringBuffer.charAt(3) == 'a'
                    && stringBuffer.charAt(4) != 'a') return 2;
            else return -1;
        }

        stringBuffer.setLength(2);
        if (execution == 3) {
            if (stringBuffer.length() == 2 && stringBuffer.charAt(1) == 'a') return 3;
            else return -1;
        }

        return -1;
    }


    // StringBufferAutomaton::subSequence (int, int)
    @Test(executionMax = 3)
    public static int test_subSequence_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");

        if (execution == 0) {
            if (stringBuffer.subSequence(2, 3).equals("2")) return 0;
            else return -1;
        }


        if (execution == 1) {
            if (stringBuffer.subSequence(1, 10).equals("123456789"))
                return 1;
            else
                return -1;
        }

        if (execution == 2) {
            try {
                stringBuffer.subSequence(1, 11);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 2;
            }
        }

        if (execution == 3) {
            if (stringBuffer.subSequence(1, 1).equals(""))
                return 3;
            else
                return -1;
        }


        return -1;
    }


    // StringBufferAutomaton::substring (int)
    @Test(executionMax = 3)
    public static int test_substring_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");

        if (execution == 0) {
            if (stringBuffer.substring(2).equals("23456789")) return 0;
            else return -1;
        }


        if (execution == 1) {
            if (stringBuffer.substring(9).equals("9"))
                return 1;
            else
                return -1;
        }

        if (execution == 2) {
            try {
                stringBuffer.substring(11);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 2;
            }
        }

        if (execution == 3) {
            if (stringBuffer.substring(10).equals(""))
                return 3;
            else
                return -1;
        }


        return -1;
    }


    // StringBufferAutomaton::substring (int, int)
    @Test(executionMax = 3)
    public static int test_substring_1(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");

        if (execution == 0) {
            if (stringBuffer.substring(2, 3).equals("2")) return 0;
            else return -1;
        }


        if (execution == 1) {
            if (stringBuffer.substring(1, 10).equals("123456789"))
                return 1;
            else
                return -1;
        }

        if (execution == 2) {
            try {
                stringBuffer.substring(1, 11);
                return -1;
            } catch (StringIndexOutOfBoundsException e) {
                return 2;
            }
        }

        if (execution == 3) {
            if (stringBuffer.substring(1, 1).equals(""))
                return 3;
            else
                return -1;
        }


        return -1;
    }


    // StringBufferAutomaton::toString
    @Test(executionMax = 1)
    public static int test_toString_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer();

        if (execution == 0) {
            if (stringBuffer.toString().equals("")) return 0;
            else return -1;
        }

        stringBuffer.append("abcde");
        if (execution == 1) {
            if (stringBuffer.toString().equals("abcde"))
                return 1;
            else
                return -1;
        }


        return -1;
    }


    // StringBufferAutomaton::trimToSize
    @Test
    public static int test_trimToSize_0(final int execution) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");

        if (execution == 0) {
            stringBuffer.trimToSize();
            if (stringBuffer.length() == 10)
                return 0;
            else return -1;
        }

        return -1;
    }


}

