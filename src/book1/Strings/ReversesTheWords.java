package book1.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class ReversesTheWords {
    public static void main(String[] args) {

        //Write a program that reverses the words in a given sentence without changing punctuation and spaces.
        // For example: "C# is not C++ and PHP is not Delphi" --> "Delphi not is PHP and C++ not is C#".

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        String result = reversedText(text);
        System.out.println(result);

    }

    private static String reversedText(String text) {
        StringBuilder reversedText = new StringBuilder();
        String[] words = text.split(" ");


        for (int i = words.length - 1; i >= 0; i--) {
            reversedText.append(words[i]);
            reversedText.append(" ");
        }
        return reversedText.toString();
    }
}
