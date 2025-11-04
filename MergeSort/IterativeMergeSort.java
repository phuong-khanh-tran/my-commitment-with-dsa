package MergeSort;

import java.util.Arrays;

public class IterativeMergeSort {

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        for (i = l, k = 0; i <= r; i++, k++) {
            arr[i] = temp[k];
        }

    }

    public static void iterativeMergeSort(int[] arr) {
        int n = arr.length;

        for (int width = 1; width < n; width *= 2) {
            for (int i = 0; i < n; i += 2 * width) {
                int l = i;
                int r = Math.min(i + 2 * width - 1, n - 1);
                int mid = Math.min(i + width - 1, n - 1);
                merge(arr, l, mid, r);
            }
        }
    }

    public static void main(String[] args) {
        int[] data = { 9, 3, 7, 5, 6, 4, 8, 2 };
        iterativeMergeSort(data);
        System.out.println("Sorted: " + Arrays.toString(data));
    }
}
