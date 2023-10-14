package book1.Strings;

import java.util.Scanner;

public class Example_24 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Write a program that reads a string from the console and replaces every sequence of identical letters
        // in it with a single letter (the repeating letter).
        // Example: "aaaaabbbbbcdddeeeedssaa" --> "abcdedsa".

        System.out.print("Enter string: ");
        String str = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {

            if (!(str.charAt(i) == str.charAt(i + 1))) {

                result.append(str.charAt(i));
            }
        }
        String result1 = result.toString();
        System.out.println(result1);
    }
}
