package book1.Recursion;

import java.util.Scanner;

public class Permutation {
    static void permutat(int[] arr, int index) {

        if (index == arr.length) {
            System.out.print("(");
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%d ", arr[i]);
            }
            System.out.print(") ");

        } else {
            for (int i = index; i < arr.length; i++) {

                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;

                permutat(arr, index + 1);

                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        permutat(arr, 0);
    }
}
