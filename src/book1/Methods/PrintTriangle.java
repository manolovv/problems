package book1.Methods;

import java.util.Scanner;

public class PrintTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the max lenght: ");
        int n = scanner.nextInt();

        printTriangle(n);
    }

    private static void printTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            incresingLine(i);
        }
        for (int j = n - 1; j > 0; j--) {
            incresingLine(j);
        }
    }

    static void incresingLine(int lenght) {
        for (int i = 1; i <= lenght; i++) {
            System.out.print(i);
            if (i < lenght) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
