public class MergeSortRecursivelyAndIteratively {
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int[] tmp = new int[n];
        mergeSort(arr, tmp, 0, n - 1);
    }

    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, tmp, left, center);
            mergeSort(arr, tmp, center + 1, right);
            merge(arr, tmp, left, center + 1, right);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                tmp[k++] = arr[left++];
            } else {
                tmp[k++] = arr[right++];
            }
        }
        while (left <= leftEnd) {
            tmp[k++] = arr[left++];
        }
        while (right <= rightEnd) {
            tmp[k++] = arr[right++];
        }
        for (int i = 0; i < num; i++, rightEnd--) {
            arr[rightEnd] = tmp[rightEnd];
        }
    }

    public static void mergeSortIterative(int[] arr) {
        int n = arr.length;
        int[] tmp = new int[n];
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n - i; j += 2 * i) {
                int left = j;
                int right = j + i;
                int rightEnd = Math.min(j + 2 * i - 1, n - 1);
                merge(arr, tmp, left, right, rightEnd);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 1, 9, -2 };
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int[] arr2 = { 5, 3, 8, 4, 1, 9, -2 };
        mergeSortIterative(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
