public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int first, end;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        first = 0;
        end = 0;
    }
    public void addFirst(T item) {
        if (size == array.length) {
            T[] temp = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i + 1] = array[(first + i + array.length) % array.length];
            }
            first = 0;
            end = array.length;
            array = temp;
            array[first] = item;
            size = size + 1;
            return;
        }
        first = (first - 1 + array.length) % array.length;
        array[first] = item;
        size = size + 1;
    }

    public void addLast(T item) {
        if (size == array.length) {
            T[] temp = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[(first + i) % array.length];
            }
            first = 0;
            end = array.length;
            array = temp;
            array[end] = item;
            size = size + 1;
            return;
        }
        if(size == 0) {
            array[end] = item;
            return;
        }
        end = (end + 1) % array.length;
        array[end] = item;
        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size - 1; i++) {
            System.out.printf(array[first + i] + " ");
        }
        System.out.printf(array[end] + "");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (array.length >= 16 && size < (array.length / 4)) {
            T rValue = array[first];
            first = (first + 1) % array.length;
            size = size - 1;
            T[] temp = (T[]) new Object[array.length / 2];
            for (int i = 0; i < size; i++) {
                temp[i] = array[(first + i) % array.length];
            }
            first = 0;
            end = size - 1;
            array = temp;
            return rValue;
        }
        T rValue = array[first];
        array[first] = null;
        first = (first + 1) % array.length;
        size = size - 1;
        return rValue;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (array.length >= 16 && size < (array.length / 4)) {
            T rValue = array[end];
            end = (end - 1) % array.length;
            size = size - 1;
            T[] temp = (T[]) new Object[array.length / 2];
            for (int i = 0; i < size; i++) {
                temp[i] = array[(first + i) % array.length];
            }
            first = 0;
            end = size - 1;
            array = temp;
            return rValue;
        }
        T rValue = array[end];
        end = (end - 1) % array.length;
        size = size - 1;
        return rValue;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return array[(first + index) % array.length];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.isEmpty();
        A.isEmpty();
        A.addLast(2);
        A.addLast(3);
        A.addLast(4);
        A.addLast(5);
        A.addLast(6);
        A.addLast(7);
        A.addLast(8);
        A.removeFirst();

    }
}
