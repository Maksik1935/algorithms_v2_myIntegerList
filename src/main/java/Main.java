import List.IntegerList;
import List.MyIntegerList;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        IntegerList DEFAULT_LIST = new MyIntegerList(5, -1, 3, 7, 12, 24, -569, 6, 0);
        System.out.println(DEFAULT_LIST.contains(4));

    }

}
