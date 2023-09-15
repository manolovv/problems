package book1.Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char a = scanner.next().charAt(0);
        char b = scanner.next().charAt(0);

        List<String> result = returnRange(a, b);
        for (var current : result) {
            System.out.print(current + " ");
        }

    }

    static List<String> returnRange(char a, char b) {
        List<String> charSymbols = new ArrayList<>();

        int first = Character.toTitleCase(a);
        int second = Character.toTitleCase(b);


        for (int i = first + 1; i < second; i++) {
            char currChar = (char) i;
            String charr = Character.toString(currChar);
            charSymbols.add(charr);
        }
        return charSymbols;
    }
}
