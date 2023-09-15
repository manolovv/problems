package book1.Recursion;

import java.util.Scanner;

public class PermSecondExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        System.out.print("Enter array lenght: ");
        int l = scanner.nextInt();
        int[] arr = new int[l];

        printArr(arr, l);
        allSubsets(arr, n);
    }

    static void printArr(int[] arr, int lenght) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter current element: ");
            arr[i] = scanner.nextInt();
        }
    }

    static void allSubsets(int[] arr, int n) {

        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                int second = arr[j];

                if ((second + first) == n) {
                    System.out.print("+ ");
                }
            }
        }
    }
}
