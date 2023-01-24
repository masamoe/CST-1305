package W2.QueueUsingArray;

public class Queue {
    Integer[] arr;
    int front;
    int num;
    final int MAXSIZE = 6;

    Queue() {
        arr = new Integer[MAXSIZE]; // max number of elements you can insert into your queue
        front = 0;
        num = 0;
    }

    void insert(int element) {
        // insert the element at the back of the queue
        int back = (front + num) % MAXSIZE;
        num++;
        arr[back] = element;
    }

    void remove() {
        front = (front + 1) % MAXSIZE;
        num--;
    }

    int getFront() {
        if (num != 0)
            return arr[front];
        else
            return -1; // to indicate that the queue is empty
    }

    boolean contains(int element) {
        for (int i = 0; i < num; i++) {
            if (arr[(front + i) % MAXSIZE] == element)
                return true;
        }
        return false;
    }

    boolean isEmpty() {
        return num == 0;
    }

    int size() {
        return num;
    }

    void printAll() {
        for (int i = 0; i < num; i++) {
            System.out.print(arr[(front + i) % MAXSIZE] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.insert(6);
        q.insert(4);
        q.insert(7);
        q.insert(3);
        q.insert(8);
        q.remove();// front to 1
        q.remove();// front to 2
        q.insert(9);
        q.insert(5);
        System.out.println(q.getFront());// 7
        q.contains(10);// false
        q.isEmpty(); // false
        q.size(); // 5
        q.printAll();// start from front
    }
}
