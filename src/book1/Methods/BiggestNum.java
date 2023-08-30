package book1.Methods;

import java.util.Scanner;

public class BiggestNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first num: ");
        int a = input.nextInt();
        System.out.print("Enter second num: ");
        int b = input.nextInt();
        System.out.print("Enter third num: ");
        int c = input.nextInt();

        int max1 = Math.max(a, b);
        biggestFromTwoNums(max1, c);
    }
    public static void biggestFromTwoNums(int num1, int num2) {
        if (num1 > num2) {
            System.out.printf("Biggest number is: %d", num1);
        } else {
            System.out.printf("Biggest number is: %d", num2);
        }
    }
}
