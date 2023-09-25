package book1.Strings;

import java.util.Scanner;

public class CountSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String inputStr = scanner.nextLine();
        System.out.print("Enter the serach word: ");
        String inputWord = scanner.nextLine();

        int numOfRep = substringCounting(inputStr, inputWord);
        System.out.println(numOfRep);
    }

    public static int substringCounting(String str, String word) {
        int indx = str.indexOf(word);
        int count = 0;
        while (indx != -1) {
            indx = str.indexOf(word, indx + 1);
            count++;
        }
        return count;
    }
}
