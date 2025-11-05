package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l;
        int j = h;

        while (i < j) {
            while (arr[i] <= pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[l] = arr[j];
        arr[j] = pivot;

        return j;
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = partition(arr, l, h);
            quickSort(arr, l, mid - 1);
            quickSort(arr, mid + 1, h);
        }
    }

    public static void main(String[] strs) {
        int[] data = { 6, 5, 8, 9, 3, 10, 15, 12, 16 };

        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

}
