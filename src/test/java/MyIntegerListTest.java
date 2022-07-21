import Constants.MyIntegerListTestsConstants;
import Exceptions.EmptyListException;
import Exceptions.IncorrectItemException;
import List.IntegerList;
import List.MyIntegerList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static Constants.MyIntegerListTestsConstants.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

class MyIntegerListTest {
    IntegerList out;

    @BeforeEach
    public void init() {
        out = new MyIntegerList(5, -1, 3, 7, 12, 24, -569, 6, 0);
    }


    @ParameterizedTest
    @MethodSource("paramsForSort")
    public void sortTest(IntegerList list1, IntegerList list2) {
        list1.sort();
        assertTrue(list1.equals(list2));
    }

    @Test
    public void positiveAddTest() {
        out.add(2);
        out.add(-3);
        out.add(0);
        out.equals(ALREADY_ADDED_LIST);
    }

    @Test
    public void negativeAddTest() {
        assertThrows(NullPointerException.class, () -> out.add(null));
    }

    @ParameterizedTest
    @MethodSource("paramsForAddItem")
    public void addItemTest(int index, Integer item, MyIntegerList list1, MyIntegerList list2) {
        if (index > list1.size() || item == null) {
            assertThrows(RuntimeException.class, () -> out.add(index, item));
        } else {
            System.out.println(list1.size());
            list1.add(index,0);
            list1.add(index, -3);
            list1.add(index, 6);
            assertTrue(list1.equals(list2));
        }

    }

    @Test
    public void setTest() {
        IntegerList list = new MyIntegerList(1, 2, 3, 4, 5);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(60, 5));
        assertThrows(NullPointerException.class, () -> list.set(1, null));
        list.set(0, 500);
        assertTrue(list.equals(new MyIntegerList(500, 2, 3, 4, 5)));
    }

    @ParameterizedTest
    @MethodSource("paramsForRemove")
    public void removeTest(Integer item, MyIntegerList list1, MyIntegerList list2) {
        if(item == null) {
            assertThrows(NullPointerException.class, () -> out.remove(item));
        } else if (item == -71) {
            assertThrows(IncorrectItemException.class, () -> out.remove(item));
        } else {
            list1.remove(item);
            assertTrue(list1.equals(list2));
        }
    }

    @Test
    public void ContainsTest() {
        assertTrue(out.contains(12) == true);
        assertTrue(out.contains(-1) == true);
        assertTrue(out.contains(99) == false);
        assertThrows(NullPointerException.class, () -> out.contains(null));
    }

    @Test
    public void indexOfTest() {
        assertTrue(out.indexOf(12) == 4);
        assertTrue(out.indexOf(-1) == 1);
        assertTrue(out.indexOf(99) == -1);
        assertThrows(NullPointerException.class, () -> out.indexOf(null));
    }

    @Test
    public void lastIndexOfTest() {
        assertTrue(out.lastIndexOf(12) == 4);
        assertTrue(out.lastIndexOf(-1) == 1);
        assertTrue(out.lastIndexOf(99) == -1);
        assertTrue(LIST_ONLY_5.lastIndexOf(5) == 4);
        assertThrows(NullPointerException.class, () -> out.indexOf(null));
    }

    @Test
    public void getTest() {
        assertTrue(out.get(0).equals(5));
        assertTrue(out.get(4).equals(12));
        assertTrue(out.get(8).equals(0));
        assertThrows(IndexOutOfBoundsException.class, () -> out.get(9));
        assertThrows(IndexOutOfBoundsException.class, () -> out.get(-6));
    }

    @Test
    public void equalsTest() {
        assertTrue(out.equals(new MyIntegerList(5, -1, 3, 7, 12, 24, -569, 6, 0)));
        assertTrue(EMPTY_LIST.equals(new MyIntegerList()));
        assertTrue(LIST_MIDDLE_ADDED.equals(new MyIntegerList(5, -1, 3, 7, 12, 24, 6, -3, 0, -569, 6, 0)));
        assertThrows(IncorrectItemException.class, () -> EMPTY_LIST.equals(null));
    }

    @Test
    public void sizeTest() {
        assertTrue(EMPTY_LIST.size() == 0);
        assertTrue(out.size() == 9);
        IntegerList tempList = new MyIntegerList();
        tempList.add(5);
        tempList.add(0, 5);
        tempList.remove(5);
        assertTrue(tempList.size()==1);
    }

    @Test
    public void isEmptyTest() {
        assertTrue(EMPTY_LIST.isEmpty());
        assertTrue(new MyIntegerList().isEmpty());
        assertFalse(out.isEmpty());
    }

    @Test
    public void clearTest() {
        out.clear();
        assertTrue(out.equals(EMPTY_LIST));
    }

    @Test
    public void toArrayTest() {
        assertThrows(EmptyListException.class, () -> EMPTY_LIST.toArray());
        assertTrue(Arrays.equals(out.toArray(), new Integer[] {5, -1, 3, 7, 12, 24, -569, 6, 0}));
    }

    public static Stream<Arguments> paramsForSort() {
        return Stream.of(
                Arguments.of(UNSORTED_LIST, SORTED_LIST),
                Arguments.of(EMPTY_LIST, EMPTY_LIST)
        );
    }
    public static Stream<Arguments> paramsForAddItem() {
        return Stream.of(
                Arguments.of(0, 0, DEFAULT_LIST, LIST_FIRST_ADDED),
                Arguments.of(DEFAULT_LIST.size(), -3,  DEFAULT_LIST_LAST, LIST_LAST_ADDED),
                Arguments.of(6, 6,  DEFAULT_LIST_MIDDLE, LIST_MIDDLE_ADDED),
                Arguments.of(60, -3,  DEFAULT_LIST_LAST, LIST_LAST_ADDED),
                Arguments.of(6, null,  DEFAULT_LIST_MIDDLE, LIST_MIDDLE_ADDED)
        );
    }

    public static Stream<Arguments> paramsForRemove() {
        return Stream.of(
                Arguments.of(5, DEFAULT_LIST, LIST_REMOVE_FIRST),
                Arguments.of(0, DEFAULT_LIST_LAST, LIST_REMOVE_LAST),
                Arguments.of(24, DEFAULT_LIST_MIDDLE, LIST_REMOVE_MIDDLE),
                Arguments.of(-71, DEFAULT_LIST, LIST_REMOVE_FIRST),
                Arguments.of(null, DEFAULT_LIST, LIST_REMOVE_LAST)
        );}

}