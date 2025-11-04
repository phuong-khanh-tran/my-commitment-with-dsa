package MergeSort;

import java.util.Arrays;

public class RecursiveMergeSort {
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

    public static void recursiveMergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (r + l) / 2;
            recursiveMergeSort(arr, l, mid);
            recursiveMergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) {
        int[] data = { 9, 3, 7, 5, 6, 4, 8, 2 };
        recursiveMergeSort(data, 0, data.length - 1);
        System.out.println("Sorted: " + Arrays.toString(data));
    }
}
