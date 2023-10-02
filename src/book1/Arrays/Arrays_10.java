package book1.Arrays;

import java.util.Scanner;

public class Arrays_10 {
    public static void main(String[] args) {

        //Write a program, which finds the most frequently occurring element in an array.
        // Example: {4, 1, 1, 4, 2, 3, 4, 4, 1, 2, 4, 9, 3} --> 4 (5 times).

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array length N: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter current index: ");
            arr[i] = scanner.nextInt();
        }

        int count = 1;
        int bestCount = 0;
        int num = 0;
        int bestNum = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                    num = arr[i];
                }
                if (count > bestCount) {
                    bestCount = count;
                    bestNum = num;
                }
            }
            count = 1;
        }
        System.out.printf("The most frequently num in the array is %d, occurring %d times.", bestNum, bestCount);
    }
}
