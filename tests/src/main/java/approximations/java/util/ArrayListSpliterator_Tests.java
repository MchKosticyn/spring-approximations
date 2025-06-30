package approximations.java.util;

import approximations.Test;

import java.util.ArrayList;
import java.util.Spliterator;

@Test
@SuppressWarnings({"unused", "RedundantOperationOnEmptyContainer", "SwitchStatementWithTooFewBranches", "PointlessBooleanExpression"})
public final class ArrayListSpliterator_Tests {

    // internal variables

    // constructors

    // static methods

    // methods

    // ArrayListSpliteratorAutomaton::characteristics
    @Test
    public static int test_characteristics_0(final int execution) {
        switch (execution) {
            case 0: {
                ArrayList<Object> a = new ArrayList<>();
                Spliterator<Object> s = a.spliterator();

                int c = s.characteristics();
                if (c != (Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED))
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    // ArrayListSpliteratorAutomaton::estimateSize
    @Test(executionMax = 1)
    public static int test_estimateSize_0(final int execution) {
        switch (execution) {
            case 0: {
                ArrayList<Object> a = new ArrayList<>();
                Spliterator<Object> s = a.spliterator();

                long c = s.estimateSize();
                if (c != 0)
                    return -1;
            }
            break;

            case 1: {
                ArrayList<Object> a = new ArrayList<>();
                a.add(10);
                a.add(20);
                Spliterator<Object> s = a.spliterator();

                long c = s.estimateSize();
                if (c != 2)
                    return -1;
            }
            break;

            default:
                return 0;
        }
        return execution;
    }


    // ArrayListSpliteratorAutomaton::forEachRemaining (Consumer)
    @Test(executionMax = 1)
    public static int test_forEachRemaining_0(final int execution) {
        switch (execution) {
            case 0: {
                ArrayList<Object> a = new ArrayList<>();
                Spliterator<Object> s = a.spliterator();

                final int[] counter = new int[1];

                s.forEachRemaining(o -> ++counter[0]);
                if (counter[0] != 0)
                    return -1;
            }
            break;

            case 1: {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(10);
                a.add(20);
                Spliterator<Integer> s = a.spliterator();

                final Integer[] counter = new Integer[3];
                counter[0] = 0;

                s.forEachRemaining(o -> {
                    int idx = ++counter[0];
                    counter[idx] = o;
                });
                if (counter[0] != 2)
                    return -1;

                if (counter[1] != 10 || counter[2] != 20)
                    return -1;
            }
            break;

            default:
                return 0;
        }
        return execution;
    }


    // ArrayListSpliteratorAutomaton::getExactSizeIfKnown
    @Test(executionMax = 1)
    public static int test_getExactSizeIfKnown_0(final int execution) {
        switch (execution) {
            case 0: {
                ArrayList<Object> a = new ArrayList<>();
                Spliterator<Object> s = a.spliterator();

                long x = s.getExactSizeIfKnown();
                if (x != 0)
                    return -1;
            }
            break;

            case 1: {
                ArrayList<Object> a = new ArrayList<>();
                a.add(10);
                a.add(20);
                Spliterator<Object> s = a.spliterator();

                long x = s.getExactSizeIfKnown();
                if (x != 2)
                    return -1;
            }
            break;

            default:
                return 0;
        }
        return execution;
    }


    // ArrayListSpliteratorAutomaton::hasCharacteristics (int)
    @Test
    public static int test_hasCharacteristics_0(final int execution) {
        switch (execution) {
            case 0: {
                ArrayList<Object> a = new ArrayList<>();
                Spliterator<Object> s = a.spliterator();

                boolean x = s.hasCharacteristics(Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED);
                if (x == false)
                    return -1;
            }
            break;

            default:
                return 0;
        }
        return execution;
    }


    // ArrayListSpliteratorAutomaton::tryAdvance (Consumer)
    @Test(executionMax = 2)
    public static int test_tryAdvance_0(final int execution) {
        switch (execution) {
            case 0: {
                ArrayList<Object> a = new ArrayList<>();
                Spliterator<Object> s = a.spliterator();

                if (s.tryAdvance(o -> {
                }) == true)
                    return -1;
            }
            break;

            case 1: {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(10);
                a.add(20);
                Spliterator<Integer> s = a.spliterator();

                Integer[] items = new Integer[2];

                if (s.tryAdvance(o -> items[0] = o) == false)
                    return -1;

                if (s.estimateSize() != 1)
                    return -1;

                if (s.tryAdvance(o -> items[1] = o) == false)
                    return -1;

                if (s.estimateSize() != 0)
                    return -1;

                if (items[0] != 10 || items[1] != 20)
                    return -1;
            }
            break;

            case 2: {
                ArrayList<Object> a = new ArrayList<>();
                Spliterator<Object> s = a.spliterator();

                try {
                    if (s.tryAdvance(null) == true)
                        return -1;
                } catch (NullPointerException ignored) {
                    // as expected
                }
            }
            break;

            default:
                return 0;
        }
        return execution;
    }


    // ArrayListSpliteratorAutomaton::trySplit
    @Test(executionMax = 1)
    public static int test_trySplit_0(final int execution) {
        switch (execution) {
            case 0: {
                ArrayList<Object> a = new ArrayList<>();
                Spliterator<Object> s = a.spliterator();

                if (s.trySplit() != null)
                    return -1;
            }
            break;

            case 1: {
                ArrayList<Object> a = new ArrayList<>();
                a.add(10);
                a.add(20);
                Spliterator<Object> s = a.spliterator();

                Spliterator<Object> s2 = s.trySplit();
                if (s2 == null || s2 == s)
                    return -1;

                if (s2.estimateSize() != 1 || s.estimateSize() != 1)
                    return -1;
            }
            break;

            default:
                return 0;
        }
        return execution;
    }

}
