public class HeapSortUsingBubble {
    Integer[] arr;
    int lastIndex;

    HeapSortUsingBubble() {
        arr = new Integer[100];
        arr[0] = 98;
        arr[1] = 86;
        arr[2] = 41;
        arr[3] = 13;
        arr[4] = 65;
        arr[5] = 32;
        arr[6] = 29;
        arr[7] = 9;
        arr[8] = 10;
        arr[9] = 44;
        arr[10] = 23;
        arr[11] = 21;
        arr[12] = 17;
        lastIndex = 12;
    }

    void insert(int element) {
        ++lastIndex;
        arr[lastIndex] = element;
        bubbleUp(lastIndex);
    }

    // remove the root from the heap
    void remove() {
        arr[0] = arr[lastIndex];
        lastIndex--;
        bubbleDown(0);
    }

    // sort the heap
    void heapSort() {
        int size = lastIndex;
        for (int i = 0; i < size; i++) {
            swap(0, lastIndex);
            lastIndex--;
            bubbleDown(0);
        }
        lastIndex = size;
    }

    // bubble down the element at the provided index
    void bubbleDown(int index) {
        int i = index;

        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;
        int leftChildElement = arr[2 * i + 1];
        int rightChildElement = arr[2 * i + 2];

        while (leftChildElement > arr[i] ||
                rightChildElement > arr[i]) {
            int maxIndex;
            if (leftChildElement > rightChildElement) {
                maxIndex = leftChildIndex;
            } else {
                maxIndex = rightChildIndex;
            }
            swap(maxIndex, i);

            // update i
            i = maxIndex;

            leftChildIndex = 2 * i + 1;
            rightChildIndex = 2 * i + 2;
            if (leftChildIndex > lastIndex || rightChildIndex > lastIndex)
                break;
            leftChildElement = arr[2 * i + 1];
            rightChildElement = arr[2 * i + 2];
        }
    }

    // bubble up the element at the provided index
    void bubbleUp(int elementIndex) {
        int i = elementIndex;
        int parentIndex = (i - 1) / 2;
        int parentElement = arr[parentIndex];

        while (parentElement < arr[i]) {
            swap(parentIndex, i);
            i = parentIndex;
            parentIndex = (i - 1) / 2;
            parentElement = arr[parentIndex];
        }
    }

    void swap(int aIndex, int b) {
        int temp = arr[aIndex];
        arr[aIndex] = arr[b];
        arr[b] = temp;
    }

    void print() {
        for (int i = 0; i <= lastIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSortUsingBubble heapSortUsingBubble = new HeapSortUsingBubble();
        heapSortUsingBubble.insert(81);
        heapSortUsingBubble.print();
        heapSortUsingBubble.remove();
        heapSortUsingBubble.print();
        heapSortUsingBubble.heapSort();
        heapSortUsingBubble.print();
    }
}
