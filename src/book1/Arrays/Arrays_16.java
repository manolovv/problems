package book1.Arrays;

import java.util.Scanner;

public class Arrays_16 {
    public static void main(String[] args) {

        // Write a program, which uses a binary search in a sorted array
        // of integer numbers to find a certain element.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the search number: ");
        int num = scanner.nextInt();
        int[] sortArr = {4, 13, 32, 66, 69, 86, 96, 100};

        Arrays_16 ob = new Arrays_16();
        int result = ob.binarySearching(sortArr, num);

        if (result == -1) {
            System.out.print("The element is not found.");
        } else {
            System.out.printf("The searching element is: %d ! ", result);
        }
    }

    public int binarySearching(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == num) {
                return  arr[m];
            }
            if (arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
