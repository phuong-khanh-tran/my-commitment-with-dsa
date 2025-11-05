package Sorting;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int p = arr[i];
            int j = i - 1;
            while (j > -1 && arr[j] > p) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = p;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] strs) {
        int[] data = { 5, 3, 6, 9, 7, 1 };
        insertSort(data);
    }
}
