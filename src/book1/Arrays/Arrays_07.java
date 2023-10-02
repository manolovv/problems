package book1.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Arrays_07 {
    public static void main(String[] args) {

        // Write a program, which reads from the console two integer numbers N and K (K<N) and array of N integers.
        // Find those K consecutive elements in the array, which have maximal sum.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        System.out.print("Enter K: ");
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter next index: ");
            arr[i] = scanner.nextInt();
        }
        int sum = 0;
        int bestSum = 0;
        int position = 0;
        int bestStart = 0;

        for (int i = 0; i < arr.length - k; i++) {
            int index = i;
            position = i;

            for (int j = 0; j < k; j++) {
                sum += arr[index];
                index++;
            }
            if (sum > bestSum) {
                bestSum = sum;
                bestStart = position;
            }
            sum = 0;
        }
        int[] bestSumArr = new int[k];

        for (int i = 0; i < k; i++) {
            bestSumArr[i] = arr[bestStart];
            bestStart++;
        }
        System.out.printf("Best sum is: %d%n", bestSum);
        System.out.print(Arrays.toString(bestSumArr));
    }
}
