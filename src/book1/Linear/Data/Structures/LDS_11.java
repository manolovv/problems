package book1.Linear.Data.Structures;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LDS_11 {
    public static void main(String[] args) {

       /*         You have an empty sequence, and you will be given N commands. Each command is one of the following types:
        ⦁	"1 X" - Push the element X into the stack.
        ⦁	"2" - Delete the element present at the top of the stack.
        ⦁	"3" - Print the maximum element in the stack.*/

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter you commands count N: ");
        int n = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice: ");
            int k = scanner.nextInt();

            switch (k) {
                case 1 -> {
                    System.out.print("Enter element for Push into the stack: ");
                    stack.push(scanner.nextInt());
                }
                case 2 -> {
                    System.out.print("Pop the last element.");
                    stack.pop();
                    System.out.println();
                }
                case 3 -> {
                    for (int element : stack) {
                        if (element > max) {
                            max = element;
                        }
                    }
                    System.out.print("The biggest integer in stack at the moment is: " + max);
                    System.out.println();
                }
            }
        }
    }
}
