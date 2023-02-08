import java.util.Set;

public class DoublyLinkedList<T> implements SetInterface<T> {

    Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
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
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T anEntry) {
        Node current = head;
        while (current != null) {
            if (current.data == (int) anEntry) {
                if (current.previous == null) {
                    head = current.next;
                } else {
                    current.previous.next = current.next;
                }
                if (current.next == null) {
                    tail = current.previous;
                } else {
                    current.next.previous = current.previous;
                }
                size--;
                return true;
            }
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

    public static void main(String[] args) {
        DoublyLinkedList<Integer> myList = new DoublyLinkedList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.getCurrentSize();
        myList.isEmpty();
    }

    public static DoublyLinkedList union(DoublyLinkedList A, DoublyLinkedList B) {
        DoublyLinkedList C = new DoublyLinkedList();
        for (Object o : A.toArray()) {
            C.add(o);
        }
        for (Object o : B.toArray()) {
            C.add(o);
        }
        return C;
    }

    public static DoublyLinkedList intersection(DoublyLinkedList A, DoublyLinkedList B) {
        DoublyLinkedList C = new DoublyLinkedList();
        for (Object o : A.toArray()) {
            if (B.contains(o)) {
                C.add(o);
            }
        }
        return C;
    }

    public static DoublyLinkedList difference(DoublyLinkedList A, DoublyLinkedList B) {
        DoublyLinkedList C = new DoublyLinkedList();
        for (Object o : A.toArray()) {
            if (!B.contains(o)) {
                C.add(o);
            }
        }
        return C;
    }
}
