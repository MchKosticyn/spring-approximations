package approximations.java.lang;

import approximations.Test;

import java.io.InputStream;
import java.io.PrintStream;
import java.lang.Object;
import java.lang.SecurityManager;
import java.lang.String;
import java.util.Properties;
import java.util.ResourceBundle;

import java.lang.System;

@Test
@SuppressWarnings({"unused", "UnnecessaryBoxing", "JavadocReference"})
public final class System_Tests {

    @Test
    public static int test__field__in(int execution) {
        if (System.in == null)
            return -1;

        // TODO: more tests

        return 0;
    }

    @Test(executionMax = 1)
    public static int test__field__out(int execution) {
        switch (execution) {
            case 0: {
                if (System.out == null)
                    return -1;
                break;
            }

            case 1: {
                System.out.println();
                System.out.println(1);
                System.out.println("2");
                break;
            }

            // TODO: more tests

            default:
                return 0;
        }
        return execution;
    }

    @Test(executionMax = 1)
    public static int test__field__err(int execution) {
        switch (execution) {
            case 0: {
                if (System.err == null)
                    return -1;
                break;
            }

            case 1: {
                System.err.println();
                System.err.println(1);
                System.err.println("2");
                break;
            }

            // TODO: more tests

            default:
                return 0;
        }
        return execution;
    }

    // internal variables

    // constructors

    // static methods

    /**
     * {@link java.lang.System#arraycopy(Object, int, Object, int, int)}
     */
    @Test(disabled = true, reason = "This method is an integral part of approximations")
    public static int test_arraycopy_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#clearProperty(String)}
     */
    @Test(executionMax = 1)
    public static int test_clearProperty_0(final int execution) {
        switch (execution) {
            case 0: {
                System.setProperty("abc.xyz", "321");
                String oldValue = System.clearProperty("abc.xyz");

                if (!"321".equals(oldValue))
                    return -1;
                break;
            }

            case 1: {
                String oldValue = System.clearProperty("user.home");

                if (oldValue == null)
                    return -1;
                break;
            }

            // TODO: more tests

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.System#console()}
     */
    @Test(disabled = true)
    public static int test_console_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#currentTimeMillis()}
     */
    @Test(disabled = true)
    public static int test_currentTimeMillis_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#exit(int)}
     */
    @Test
    public static int test_exit_0(final int execution) {
        try {
            System.exit(-100);
        } catch (Throwable ignored) {
            // expected
        }
        return 0;
    }


    /**
     * {@link java.lang.System#gc()}
     */
    @Test
    public static int test_gc_0(final int execution) {
        System.gc();
        return 0;
    }


    /**
     * {@link java.lang.System#getLogger(String)}
     */
    @Test(disabled = true, reason = "Unavailable in Java 8")
    public static int test_getLogger_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#getLogger(String, ResourceBundle)}
     */
    @Test(disabled = true, reason = "Unavailable in Java 8")
    public static int test_getLogger_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#getProperties()}
     */
    @Test(disabled = true)
    public static int test_getProperties_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#getProperty(String)}
     */
    @Test(executionMax = 3)
    public static int test_getProperty_0(int execution) {
        switch (execution) {
            case 0: {
                if (System.getProperty("file.separator") == null)
                    return -1;
                break;
            }

            case 1: {
                String value = System.getProperty("file.separator");

                if (!("/".equals(value) || "\\".equals(value)))
                    return -1;
                break;
            }

            case 2: {
                if (System.getProperty("user.name") == null)
                    return -1;
                break;
            }

            case 3: {
                if (System.getProperty("user.name").isEmpty())
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.System#getProperty(String, String)}
     */
    @Test(executionMax = 1)
    public static int test_getProperty_1(final int execution) {
        switch (execution) {
            case 0: {
                String value = System.getProperty("file.separator", "ABC");

                if (!("/".equals(value) || "\\".equals(value)))
                    return -1;
                break;
            }

            case 1: {
                if (!"ABC".equals(System.getProperty("xyz", "ABC")))
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.System#getSecurityManager()}
     */
    @Test(disabled = true)
    public static int test_getSecurityManager_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#getenv()}
     */
    @Test(disabled = true)
    public static int test_getenv_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#getenv(String)}
     */
    @Test(disabled = true)
    public static int test_getenv_1(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#identityHashCode(Object)}
     */
    @Test(executionMax = 1)
    public static int test_identityHashCode_0(final int execution) {
        switch (execution) {
            case 0: {
                if (System.identityHashCode(null) != 0)
                    return -1;
                break;
            }

            case 1: {
                int a = System.identityHashCode(new Integer(123456));
                int b = System.identityHashCode(new Integer(321));

                if (a == b)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.System#inheritedChannel()}
     */
    @Test(disabled = true)
    public static int test_inheritedChannel_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#lineSeparator()}
     */
    @Test(executionMax = 1)
    public static int test_lineSeparator_0(final int execution) {
        String value = System.lineSeparator();

        switch (execution) {
            case 0: {
                if (value == null)
                    return -1;
                break;
            }

            case 1: {
                if (!"\n".equals(value) && !"\r\n".equals(value))
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.System#load(String)}
     */
    @Test(executionMax = 1)
    public static int test_load_0(final int execution) {
        switch (execution) {
            case 0: {
                try {
                    System.load(null);
                } catch (NullPointerException ignored) {
                    // expected
                }
                break;
            }

            case 1: {
                try {
                    System.load("*something*");
                } catch (SecurityException | UnsatisfiedLinkError ignored) {
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
     * {@link java.lang.System#loadLibrary(String)}
     */
    @Test(executionMax = 1)
    public static int test_loadLibrary_0(final int execution) {
        switch (execution) {
            case 0: {
                try {
                    System.loadLibrary(null);
                } catch (NullPointerException ignored) {
                    // expected
                }
                break;
            }

            case 1: {
                try {
                    System.loadLibrary("*something*");
                } catch (SecurityException | UnsatisfiedLinkError ignored) {
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
     * {@link java.lang.System#mapLibraryName(String)}
     */
    @Test(executionMax = 1)
    public static int test_mapLibraryName_0(final int execution) {
        String value = System.mapLibraryName("_xyz_");

        switch (execution) {
            case 0: {
                if (value == null)
                    return -1;
                break;
            }

            case 1: {
                if (!"_xyz_.dll".equals(value) &&
                        !"lib_xyz_.so".equals(value) &&
                        !"lib_xyz_.dylib".equals(value))
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.System#nanoTime()}
     */
    @Test(disabled = true)
    public static int test_nanoTime_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#runFinalization()}
     */
    @Test
    public static int test_runFinalization_0(final int execution) {
        System.runFinalization();
        return 0;
    }


    /**
     * {@link java.lang.System#setErr(PrintStream)}
     */
    @Test(disabled = true)
    public static int test_setErr_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#setIn(InputStream)}
     */
    @Test(disabled = true)
    public static int test_setIn_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#setOut(PrintStream)}
     */
    @Test(disabled = true)
    public static int test_setOut_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#setProperties(Properties)}
     */
    @Test(disabled = true)
    public static int test_setProperties_0(final int execution) {
        return -1;
    }


    /**
     * {@link java.lang.System#setProperty(String, String)}
     */
    @Test(executionMax = 1)
    public static int test_setProperty_0(final int execution) {
        String oldValue = System.setProperty("abc.xyz", "123");

        switch (execution) {
            case 0: {
                if (oldValue != null)
                    return -1;
                break;
            }

            case 1: {
                if (!"123".equals(System.getProperty("abc.xyz")))
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    /**
     * {@link java.lang.System#setSecurityManager(SecurityManager)}
     */
    @Test(disabled = true)
    public static int test_setSecurityManager_0(final int execution) {
        return -1;
    }


    // methods

}
