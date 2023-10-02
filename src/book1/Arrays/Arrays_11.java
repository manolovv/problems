package book1.Arrays;

import java.util.Scanner;

public class Arrays_11 {
    public static void main(String[] args) {

        // Write a program to find a sequence of neighbor numbers in an array, which has a sum of certain number S.
        // Example: {4, 3, 1, 4, 2, 5, 8}, S=11 --> {4, 2, 5}.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array length N: ");
        int n = scanner.nextInt();
        System.out.print("Enter the sum S: ");
        int s = scanner.nextInt();

        int[] arr = new int[n];

        printArray(scanner, arr);

        findSum(s, arr);
    }

    private static void printArray(Scanner scanner, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter current index: ");
            arr[i] = scanner.nextInt();
        }
    }

    private static void findSum(int s, int[] arr) {
        int sum = 0;
        int endPos = 0;
        int startPos = 0;
        boolean found = false;

        for (int i = 0; i < arr.length - 1; i++) {
            sum = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == s) {
                    startPos = i;
                    endPos = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (found) {
            for (int a = startPos; a <= endPos; a++) {
                System.out.printf("%d ", arr[a]);
            }
        } else {
            System.out.println("Sum not found.");
        }
    }
}
