package approximations.java.util;

import approximations.Test;

import java.util.HashSet;

@Test
@SuppressWarnings({"unused", "ConstantValue"})
public final class HashSet_Tests {

    // internal variables

    // constructors

    // HashSetAutomaton::HashSet
    @Test
    public static int test_HashSet_0(final int execution) {
        HashSet<?> hs = new HashSet<>();
        if (hs == null)
            return -1;

        return 0;
    }


    // HashSetAutomaton::HashSet (Collection)
    @Test(disabled = true)
    public static int test_HashSet_1(final int execution) {
        return -1;
    }


    // HashSetAutomaton::HashSet (int)
    @Test(disabled = true)
    public static int test_HashSet_2(final int execution) {
        return -1;
    }


    // HashSetAutomaton::HashSet (int, float)
    @Test(disabled = true)
    public static int test_HashSet_3(final int execution) {
        return -1;
    }


    // HashSetAutomaton::HashSet (int, float, boolean)
    @Test(disabled = true)
    public static int test_HashSet_4(final int execution) {
        return -1;
    }


    // static methods

    // methods

    // HashSetAutomaton::add (Object)
    @Test(disabled = true)
    public static int test_add_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::addAll (Collection)
    @Test(disabled = true)
    public static int test_addAll_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::clear
    @Test(disabled = true)
    public static int test_clear_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::clone
    @Test(disabled = true)
    public static int test_clone_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::contains (Object)
    @Test(disabled = true)
    public static int test_contains_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::containsAll (Collection)
    @Test(disabled = true)
    public static int test_containsAll_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::equals (Object)
    @Test(disabled = true)
    public static int test_equals_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::forEach (Consumer)
    @Test(disabled = true)
    public static int test_forEach_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::hashCode
    @Test(disabled = true)
    public static int test_hashCode_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::isEmpty
    @Test(disabled = true)
    public static int test_isEmpty_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::iterator
    @Test(disabled = true)
    public static int test_iterator_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::parallelStream
    @Test(disabled = true)
    public static int test_parallelStream_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::remove (Object)
    @Test(disabled = true)
    public static int test_remove_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::removeAll (Collection)
    @Test(disabled = true)
    public static int test_removeAll_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::removeIf (Predicate)
    @Test(disabled = true)
    public static int test_removeIf_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::retainAll (Collection)
    @Test(disabled = true)
    public static int test_retainAll_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::size
    @Test(disabled = true)
    public static int test_size_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::spliterator
    @Test(disabled = true)
    public static int test_spliterator_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::stream
    @Test(disabled = true)
    public static int test_stream_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::toArray
    @Test(disabled = true)
    public static int test_toArray_0(final int execution) {
        return -1;
    }


    // HashSetAutomaton::toArray (IntFunction)
    @Test(disabled = true)
    public static int test_toArray_1(final int execution) {
        return -1;
    }


    // HashSetAutomaton::toArray (Object[])
    @Test(disabled = true)
    public static int test_toArray_2(final int execution) {
        return -1;
    }


    // HashSetAutomaton::toString
    @Test(executionMax = 1)
    public static int test_toString_0(final int execution) {
        HashSet<Integer> hs = new HashSet<>();

        switch (execution) {
            case 0: {
                String s = hs.toString();

                if (!"[]".equals(s))
                    return -1;
                break;
            }

            case 1: {
                hs.add(11);
                hs.add(22);

                String s = hs.toString();
                if (!("[11, 22]".equals(s) || "[22, 11]".equals(s)))
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }

}
