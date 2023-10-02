package book1.Arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Arrays_08 {
    public static void main(String[] args) {

        //Sorting an array means to arrange its elements in an increasing (or decreasing) order.
        // Write a program, which sorts an array using the algorithm "selection sort".

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter current index: ");
            arr[i] = scanner.nextInt();
        }

        increaseSort(arr);
        System.out.print("Here is increasing sort: ");
        System.out.print(Arrays.toString(arr));

        System.out.println();

        System.out.print("Here is decreasing sort: ");
        decreaseSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void increaseSort(int[] arr) {
        int minIndx;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndx]) {
                    minIndx = j;
                }
                temp = arr[minIndx];
                arr[minIndx] = arr[i];
                arr[i] = temp;
            }
        }
    }
    private static void decreaseSort(int[] arr) {
        int minIndx;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[minIndx]) {
                    minIndx = j;
                }
                temp = arr[minIndx];
                arr[minIndx] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
