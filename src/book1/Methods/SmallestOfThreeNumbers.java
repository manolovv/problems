package book1.Methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int smillestNum = returnSmallestNum(a, b, c);
        System.out.print("The smallest num is: " + smillestNum);
    }

    static int returnSmallestNum(int a, int b, int c) {
        int min = Math.min(a, b);
        if (min > c) {
            return c;
        }
        return min;
    }
}
