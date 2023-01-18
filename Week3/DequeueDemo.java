import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeueDemo {
    public static void main(String[] args) {
        Queue<Integer> aQueue = new LinkedList<>();
        aQueue.add(1);
        aQueue.add(2);
        aQueue.remove(); //removed 1
        System.out.println(aQueue.peek()); //2

        Deque<Integer> aDeque = new ArrayDeque<>();
        aDeque.addFirst(1);
        aDeque.addFirst(2);
        System.out.println(aDeque.getLast()); //1
        aDeque.addLast(3);
        System.out.println(aDeque.getFirst()); //2
    }
}

