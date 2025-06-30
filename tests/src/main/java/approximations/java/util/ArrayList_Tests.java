package approximations.java.util;

import approximations.Test;

import java.util.ArrayList;

@Test
@SuppressWarnings({"unused", "ConstantConditions", "ListIndexOfReplaceableByContains", "NumberEquality"})
public final class ArrayList_Tests {

    @Test(executionMax = 4)
    public static int test_get_0(int execution) {
        ArrayList<Object> list = new ArrayList<>();
        if (execution == 0) {
            try {
                if (list.get(5) == null)
                    return -1;
            } catch (IndexOutOfBoundsException e) {
                return 0;
            }
        }

        Object stub = new Object();
        for (int i = 0; i < 3; i++)
            list.add(new Object());

        if (execution == 1) {
            if (list.size() == 3)
                return 1;
            else
                return -1;
        }

        list.add(0, stub);
        list.add(stub);

        if (execution == 2) {
            if (list.size() == 5)
                return 2;
            else
                return -1;
        }

        if (execution == 3) {
            if (list.get(0) == list.get(list.size() - 1))
                return 3;
            else
                return -1;
        }

        if (execution == 4) {
            if (list.get(0) != list.get(1))
                return 4;
            else
                return -1;
        }

        return 0;
    }


    @Test(executionMax = 2)
    public static int test_indexOf_0(int execution) {
        final Integer i1 = 11;
        final Integer i2 = 22;
        final Integer i3 = 33;

        final ArrayList<Integer> a = new ArrayList<>();
        a.add(i2);
        a.add(i1);
        a.add(i3);

        switch (execution) {
            case 0: {
                if (a.indexOf(null) != -1)
                    return -1;
                break;
            }

            case 1: {
                if (a.indexOf(i1) != 1)
                    return -1;
                break;
            }

            case 2: {
                Integer i4 = 11;
                a.add(i4);

                int idx = a.indexOf(i1);

                // TODO: force the index to be the first encounter
                if (idx != 1 && idx != 3)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }


    @Test(executionMax = 1)
    public static int test_sort_0(int execution) {
        final Integer i1 = 11;
        final Integer i2 = 22;
        final Integer i3 = 33;

        final ArrayList<Integer> a = new ArrayList<>();
        a.add(i2);
        a.add(i1);
        a.add(i3);

        switch (execution) {
            case 0: {
                a.sort(null);

                if (a.get(0) != i1 || a.get(1) != i2 || a.get(2) != i3)
                    return -1;
                break;
            }

            case 1: {
                a.sort((x, y) -> y - x);

                if (a.get(0) != i3 || a.get(1) != i2 || a.get(2) != i1)
                    return -1;
                break;
            }

            default:
                return 0;
        }
        return execution;
    }

}
