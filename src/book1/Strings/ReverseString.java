package book1.Strings;

import java.util.Scanner;
import java.lang.StringBuilder;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write your string for reverse: ");
        String input = scanner.nextLine();

        String reversedString = reverseString(input);
        System.out.println(reversedString.trim());
    }

    public static String reverseString(String str) {
        StringBuilder strb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            strb.append(str.charAt(i));
        }
        return strb.toString();
    }
}
