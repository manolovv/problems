package book1.Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCheking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array count: ");
        int arrCount = input.nextInt();

        int[] arr = new int[arrCount];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter another value: ");
            arr[i] = input.nextInt();
        }
        System.out.print("Enter array position: ");
        int position = input.nextInt();
        elementComparison(position, arr);
    }

    public static void elementComparison(int pos, int... arr) {
        if (arr[pos] > arr[pos - 1]) {
            System.out.println("The element is Larger than the previous one.");
        } if (arr[pos] < arr[pos - 1]) {
            System.out.println("The element is Smaller than the previous one.");
        } if (arr[pos] == arr[pos - 1]) {
            System.out.println("The element is Equal than the previous one.");
        } if (arr[pos] > arr[pos + 1]) {
            System.out.println("The element is Larger than the next one.");
        } if (arr[pos] < arr[pos + 1]) {
            System.out.println("The element is Smaller than the next one.");
        } if (arr[pos] == arr[pos + 1]) {
            System.out.println("The element is Equal than the next one.");
        }
    }
}
