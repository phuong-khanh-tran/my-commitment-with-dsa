package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void SelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            int j = i + 1;

            while (j < n) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                j++;
            }

            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void main(String[] strs) {
        int[] data = { 7, 4, 10, 8, 3, 1 };
        SelectionSort(data);
        System.out.println(Arrays.toString(data));
    }
}
