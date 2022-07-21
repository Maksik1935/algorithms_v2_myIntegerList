package Constants;

import List.IntegerList;
import List.MyIntegerList;

public class MyIntegerListTestsConstants {

    public static final IntegerList EMPTY_LIST = new MyIntegerList();
    public static final IntegerList UNSORTED_LIST = new MyIntegerList(5, 1, 6, -1, 0);
    public static final IntegerList SORTED_LIST = new MyIntegerList(-1, 0, 1, 5, 6);
    public static final IntegerList DEFAULT_LIST_LAST = new MyIntegerList(5, -1, 3, 7, 12, 24, -569, 6, 0);
    public static final IntegerList DEFAULT_LIST = new MyIntegerList(5, -1, 3, 7, 12, 24, -569, 6, 0);
    public static final IntegerList DEFAULT_LIST_MIDDLE = new MyIntegerList(5, -1, 3, 7, 12, 24, -569, 6, 0);
    public static final IntegerList ALREADY_ADDED_LIST = new MyIntegerList(5, -1, 3, 7, 12, 24, -569, 6, 0, 2, -3, 0);
    public static final IntegerList LIST_FIRST_ADDED = new MyIntegerList(6, -3, 0, 5, -1, 3, 7, 12, 24, -569, 6, 0);
    public static final IntegerList LIST_LAST_ADDED = new MyIntegerList(5, -1, 3, 7, 12, 24, -569, 6, 0, 6, -3, 0);
    public static final IntegerList LIST_MIDDLE_ADDED = new MyIntegerList(5, -1, 3, 7, 12, 24, 6, -3, 0, -569, 6, 0);
    public static final IntegerList LIST_ONLY_5 = new MyIntegerList(5, 5, 5 ,5 ,5);

    public static final IntegerList LIST_REMOVE_FIRST = new MyIntegerList(-1, 3, 7, 12, 24, -569, 6, 0);
    public static final IntegerList LIST_REMOVE_LAST = new MyIntegerList(5, -1, 3, 7, 12, 24, -569, 6);
    public static final IntegerList LIST_REMOVE_MIDDLE = new MyIntegerList(5, -1, 3, 7, 12, -569, 6, 0);
}
