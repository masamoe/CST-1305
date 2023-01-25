package lab4;

public class ListUsingLinkedList {
    Node head;
    Node tail;
    int size;

    ListUsingLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }
        Node newNode = new Node();
        newNode.data = data;
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    public void get(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        Node temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        ListUsingLinkedList list = new ListUsingLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.get(2);
        list.remove(2);
        list.get(2);
    }
}