package book1.Methods;

import java.util.Scanner;

public class ReverseNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter num: ");
        int num = input.nextInt();

        System.out.print("Reversed number is: " + reverseDigit(num));
    }

    public static int reverseDigit(int num) {
        int rev = 0;
        int rem;

        while (num > 0) {
            rem = num % 10;
            rev = (rev * 10) + rem;
            num = num / 10;
        }
        return rev;
    }
}
