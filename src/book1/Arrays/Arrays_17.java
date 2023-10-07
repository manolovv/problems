package book1.Arrays;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Arrays_17 {
    public static void main(String[] args) {

        //Write a program, which sorts an array of integer elements using a "merge sort" algorithm.

        int[] arr = {32, 12, 19, 16, 14, 86, 66, 2, 1};

        int l = 0;
        int r = arr.length - 1;

        System.out.println("The given array is: ");
        System.out.println(Arrays.toString(arr));

        Arrays_17 ob = new Arrays_17();
        ob.sortArr(arr, l, r);

        System.out.println("The sorted array is: ");
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0; int j = 0;
        int k = l;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    private void sortArr(int[] arr, int l, int r) {

        if (l < r) {

            int m = l + (r - l) / 2;

            sortArr(arr, l, m);
            sortArr(arr, m + 1, r);

            mergeSort(arr, l, m, r);
        }
    }
}
