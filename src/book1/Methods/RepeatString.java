package book1.Methods;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your word: ");
        String word = scanner.nextLine();

        System.out.print("Enter how many repeat: ");
        int repeat = scanner.nextInt();

        String printWords = manyPrintOfWord(word, repeat);
        System.out.print(printWords);
    }

    static String manyPrintOfWord(String s, int rep) {
        String[] arr = new String[rep];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s;
        }
        String strings = String.join(" ", arr);
        return strings;
    }
}
