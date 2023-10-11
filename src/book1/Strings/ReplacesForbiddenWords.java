package book1.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class ReplacesForbiddenWords {

    // A string is given, composed of several "forbidden" words separated by commas.
    // Also a text is given, containing those words. Write a program that replaces the forbidden words with asterisks.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter banned words: ");
        String[] bannWords = scanner.nextLine().split(",");
        System.out.println("Enter your text: ");
        String text = scanner.nextLine();


        replaceBannedWords(bannWords, text);

    }

    private static void replaceBannedWords(String[] bannWords, String text) {
        for (var banWord : bannWords) {
            String replace = replaceStr("*", banWord.length());
            if (text.contains(banWord)) {
                text = text.replace(banWord, replace);

            }
        }
        System.out.println(text);
    }

    private static String replaceStr(String str, int length) {
        String repStr = new String();
        for (int i = 0; i < length; i++) {
            repStr += str;
        }
        return repStr;
    }
}
