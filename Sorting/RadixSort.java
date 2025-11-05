package Sorting;

import java.sql.Array;
import java.util.Arrays;

public class RadixSort {
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void CountingSort(int[] A, int pos) {
        int n = A.length;
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            int digit = (A[i] / pos) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int digit = (A[i] / pos) % 10;
            res[--count[digit]] = A[i];
        }

        for (int i = 0; i < n; i++) {
            A[i] = res[i];
        }
    }

    public static int[] RadixSort(int[] arr) {
        int max = getMax(arr);
        for (int pos = 1; (max / pos) > 0; pos *= 10) {
            CountingSort(arr, pos);
        }

        System.out.println(Arrays.toString(arr));

        return arr;
    }

    public static void main(String[] ars) {
        int[] data = { 432, 8, 530, 90, 88, 231, 11, 45, 677, 199 };
        RadixSort(data);
    }
}
