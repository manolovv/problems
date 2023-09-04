package book1.Methods;

import java.util.Scanner;

public class ReverseNum2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter num: ");
        int num = input.nextInt();

        String str = Integer.toString(num);
        char[] charArr = str.toCharArray();
        reverseNum(charArr);
    }
    public static void reverseNum(char... num) {
        for (int i = num.length - 1; i >= 0; i--) {
            System.out.print(num[i]);
        }
    }
}
