public class Recursion_Practice {
    // 1
    void countDown(int integer) {
        if (integer == 0) {
            System.out.println(0);
        } else {
            System.out.println(integer);
            countDown(integer - 1);
        }
    }

    // 2
    int sumOf(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumOf(n - 1);
        }
    }

    // 3
    void displayArrayFromFirst(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) {
            System.out.println(array[firstIndex]);
        } else {
            System.out.println(array[firstIndex]);
            displayArrayFromFirst(array, firstIndex + 1, lastIndex);
        }
    }

    // 4
    void displayArrayFromLast(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) {
            System.out.println(array[lastIndex]);
        } else {
            displayArrayFromLast(array, firstIndex, lastIndex - 1);
            System.out.println(array[lastIndex]);
        }
    }

    // 5
    void displayArrayFromMiddle(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) {
            System.out.println(array[firstIndex]);
        } else {
            System.out.println(array[firstIndex]);
            displayArrayFromMiddle(array, firstIndex + 1, lastIndex);
            System.out.println(array[lastIndex]);
        }
    }

    // 6
    void displayListForward(Node head) {
        if (head == null) {
            return;
        } else {
            System.out.println(head.data);
            displayListForward(head.next);
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
