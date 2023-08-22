package book1.Arrays;

import java.util.Scanner;

public class LatinAlphabet {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        System.out.print("Enter the word: ");
        char[] word = input.next().toCharArray();

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (word[i] == alphabet[j]) {
                    System.out.print(alphabet[j] + " ");
                }
            }
        }
    }
}
