package book1;

import java.util.Scanner;

public class FindEvenNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter start number: ");
        int start = input.nextInt();

        System.out.print("Enter start number: ");
        int end = input.nextInt();

        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.println("The number=" + i + " is even");
            }
        }

    }
}
