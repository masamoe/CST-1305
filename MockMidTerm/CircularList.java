import java.util.Set;

public class CircularList<T> implements SetInterface<T> {

    Node head;
    Node tail;
    int size;

    public CircularList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node();
        newNode.data = (int) newEntry;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T anEntry) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.data == (int) anEntry) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(T anEntry) {
        Node current = head;
        while (current != null) {
            if (current.data == (int) anEntry) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            array[i] = (T) new Integer(current.data);
            current = current.next;
            i++;
        }
        return array;
    }

    public CircularList union(Set A, Set B) {
        CircularList C = new CircularList();
        Object[] a = A.toArray();
        Object[] b = B.toArray();
        for (int i = 0; i < a.length; i++) {
            C.add((T) a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            C.add((T) b[i]);
        }
        return C;
    }

    public CircularList intersection(Set A, Set B) {
        CircularList C = new CircularList();
        Object[] a = A.toArray();
        Object[] b = B.toArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    C.add((T) a[i]);
                }
            }
        }
        return C;
    }

    public CircularList difference(Set A, Set B) {
        CircularList C = new CircularList();
        Object[] a = A.toArray();
        Object[] b = B.toArray();
        for (int i = 0; i < a.length; i++) {
            C.add((T) a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            C.remove((T) b[i]);
        }
        return C;
    }
}
