package Sorting;

import java.util.Arrays;

public class CountingSort {
    public static int[] CountingSort(int[] A, int max) {
        int n = A.length;
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[A[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] = count[i] + count[i - 1];
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[--count[A[i]]] = A[i];
        }

        return res;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] strs) {
        int[] data = { 4, 3, 1, 5, 8, 2, 1, 3, 5, 2 };
        int max = getMax(data);

        System.out.println(Arrays.toString(CountingSort(data, max)));

    }
}
