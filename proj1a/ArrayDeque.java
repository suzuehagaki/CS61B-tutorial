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

    /** create a resize method to avoid code repeating itself */
    private void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[(first + i + array.length) % array.length];
        }
        first = 0;
        end = size - 1;
        array = temp;
    }

    public void addFirst(T item) {
        if (size == 0) {
            array[first] = item;
            end = first;
            size = size + 1;
            return;
        }
        if (size == array.length) {
            /* ugly original code
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
            */
            resize(array.length * 2);
        }
        first = (first - 1 + array.length) % array.length;
        array[first] = item;
        size = size + 1;
    }

    public void addLast(T item) {
        if (size == 0) {
            array[end] = item;
            first = end;
            size = size + 1;
            return;
        }
        if (size == array.length) {
            /* ugly original code
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
            */
            resize(array.length * 2);
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
            /* ugly original code
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
             */
            resize(array.length / 2);
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
            /* ugly original code
            T rValue = array[end];
            end = (end - 1 + array.length) % array.length;
            size = size - 1;
            T[] temp = (T[]) new Object[array.length / 2];
            for (int i = 0; i < size; i++) {
                temp[i] = array[(first + i) % array.length];
            }
            first = 0;
            end = size - 1;
            array = temp;
            return rValue;
             */
            resize(array.length / 2);
        }
        T rValue = array[end];
        array[end] = null;
        end = (end - 1 + array.length) % array.length;
        size = size - 1;
        return rValue;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return array[(first + index) % array.length];
    }

}
