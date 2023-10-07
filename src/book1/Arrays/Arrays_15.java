package book1.Arrays;

import java.util.Scanner;

public class Arrays_15 {
    public static void main(String[] args) {

        // Write a program, which creates an array containing all Latin letters.
        // The user inputs a word from the console and as result the program prints
        // to the console the indices of the letters from the word.


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your word: ");
        char[] word = scanner.nextLine().toCharArray();

        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < alphabets.length; j++) {

                if (word[i] == alphabets[j]) {
                    System.out.printf("%s", alphabets[j]);
                }
            }
        }
    }
}
