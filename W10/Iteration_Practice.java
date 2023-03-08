public class Iteration_Practice {
    // 1
    void countDown(int integer) {
        while (integer >= 0) {
            System.out.println(integer);
            integer--;
        }
    }

    // 2
    int sumOf(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n;
            n--;
        }
        return sum;
    }

    // 3
    void displayArrayFromFirst(int[] array, int firstIndex, int lastIndex) {
        while (firstIndex <= lastIndex) {
            System.out.println(array[firstIndex]);
            firstIndex++;
        }
    }

    // 4
    void displayArrayFromLast(int[] array, int firstIndex, int lastIndex) {
        while (lastIndex >= firstIndex) {
            System.out.println(array[lastIndex]);
            lastIndex--;
        }
    }

    // 5
    void displayArrayFromMiddle(int[] array, int firstIndex, int lastIndex) {
        while (firstIndex <= lastIndex) {
            System.out.println(array[firstIndex]);
            firstIndex++;
        }
        while (lastIndex >= firstIndex) {
            System.out.println(array[lastIndex]);
            lastIndex--;
        }
    }

    // 6
    void displayListForward(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    // 7
    void displayListBackward(Node head) {
        if (head == null) {
            return;
        } else {
            displayListBackward(head.next);
            System.out.println(head.data);
        }
    }
}
