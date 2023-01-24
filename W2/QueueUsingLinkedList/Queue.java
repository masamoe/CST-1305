package W2.QueueUsingLinkedList;

public class Queue {

    Node front;

    Queue() {
        front = null;
    }

    void enqueue(int input) {
        Node newNode = new Node();
        newNode.data = input;

        if (front == null) {
            front = newNode;
        } else {
            Node temp = front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void dequeue() {
        if (front != null) {
            front = front.next;
        }
    }

    int getFront() {
        return front.data;
    }

    int getSize() {
        int size = 0;
        Node temp = front;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    boolean isEmpty() {
        return front == null;
    }

    boolean contains(int input) {
        Node temp = front;
        while (temp != null) {
            if (temp.data == input) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1); // add 1 to the back of the queue
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue(); // remove 1 (the front of the queue)
        q.dequeue(); // remove 2
        q.getFront(); // 3 (the front of the queue)
        q.getSize(); // 1
        q.isEmpty(); // false
        q.contains(1); // false
    }
}
