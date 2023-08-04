public class LinkedListDeque<T> {
    private class TNode {
        T item;
        TNode pre;
        TNode next;
        public TNode(T item, TNode pre, TNode next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    };
    private TNode first;
    private TNode end;
    private int size;

    public LinkedListDeque() {
        first = null;
        end = null;
    }

    public void addFirst(T item) {
        TNode temp = new TNode(item, end, first);
        if (size == 0) {
            end = temp;
            first = temp;
            temp.pre = temp;
            temp.next = temp;
            size = 1;
            return;
        }
        first.pre = temp;
        end.next = temp;
        first = temp;
        size = size + 1;
    }

    public void addLast(T item) {
        TNode temp = new TNode(item, end, first);
        if (size == 0) {
            end = temp;
            first = temp;
            temp.pre = temp;
            temp.next = temp;
            size = 1;
            return;
        }
        end.next = temp;
        first.pre = temp;
        end = temp;
        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            return;
        }
        TNode p = first;
        while (p.next != first) {
            System.out.printf(p.item + " ");
            p = p.next;
        }
        System.out.printf(p.item + "");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = first.item;
        if (size == 1) {
            first = null;
            end = null;
            size = size - 1;
            return item;
        }
        first = first.next;
        end.next = first;
        size = size - 1;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = end.item;
        if (size == 1) {
            first = null;
            end = null;
            size = size - 1;
            return item;
        }
        end = end.pre;
        first.pre = end;
        size = size - 1;
        return item;
    }

    public T get(int index) {
        if (index == 0) {
            return first.item;
        }
        TNode temp = first;
        while (temp.next != first && index > 0) {
            temp = temp.next;
            index--;
        }
        if (index == 0) {
            return temp.item;
        }
        return null;
    }
    
    private T getRecursiveHelper(int index, TNode node) {
        if (index == 0) {
            return node.item;
        }
        if (node.next == first) {
            return null;
        }
        return getRecursiveHelper(index - 1, node.next);
    }
    public T getRecursive(int index) {
        return getRecursiveHelper(index, first);
    }
}
