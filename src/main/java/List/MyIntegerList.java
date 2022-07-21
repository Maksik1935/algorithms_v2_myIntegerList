package List;

import Exceptions.EmptyListException;
import Exceptions.IncorrectItemException;

import java.util.Arrays;
import java.util.Objects;

public class MyIntegerList implements IntegerList{
    private Integer[] arr = new Integer[10];
    private int size = 0;

    public MyIntegerList (Integer...integers){
        for (Integer i : integers) {
            add(i);
        }
    }

    @Override
    public Integer add(Integer item) {
        if(item == null) {
            throw new NullPointerException();
        }
        if (size == arr.length) {
            expand();
        }
        return arr[size++] = item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if(item == null) {
            throw new NullPointerException();
        }
        if (size == arr.length) {
            expand();
        }
        if(index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == size) {
            arr[index] = item;
        } else {
            for (int i = size; i > index; i--) {
                Integer s = arr[i-1];
                arr[i] = s;
            }
        }
        size++;
        return arr[index] = item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if(item == null) {
            throw new NullPointerException();
        }
        if(index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == size) {
            size++;
        }
        return arr[index] = item;
    }

    @Override
    public Integer remove(Integer item) {
        if(item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(item)) {
                if(i == size-1) {
                    arr[i] = null;
                    size--;
                    return item;
                } else {
                    for (int j = i; j < size-1; j++) {
                        Integer s = arr[j+1];
                        arr[j+1] = null;
                        arr[j] = s;
                    }
                    size--;
                    return item;
                }
            }

        }
        throw new IncorrectItemException();
    }


    @Override
    public boolean contains(Integer item) {
        if(item == null) {
            throw new NullPointerException();
        }
        sort();
        if(Arrays.binarySearch(arr, 0, size, item) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        if(item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Integer item) {
        if(item == null) {
            throw new NullPointerException();
        }
        for (int i = size-1; i >= 0; i--) {
            if(arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if(otherList == null) {
            throw new IncorrectItemException();
        }
        if(size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!arr[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0 ) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size=0;
    }

    @Override
    public Integer[] toArray() {
        if(size == 0) {
            throw new EmptyListException("Пустой массив");
        }
        Integer[] newArr = new Integer[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;

    }

    private void expand() {
        Integer[] newArr = new Integer[(int) (size * 1.5)];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    @Override
    public void sort() {
        for (int i = 0; i < size; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyIntegerList that = (MyIntegerList) o;
        if(that.size != size) return false;
        return Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
