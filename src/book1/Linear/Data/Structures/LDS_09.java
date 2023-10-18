package book1.Linear.Data.Structures;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LDS_09 {
    public static void main(String[] args) {

        // Program that reverses N inputs of integers with using stack.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input times N: ");
        int n = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter next integer for push: ");
            stack.push(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            System.out.print(stack.pop() + " ");
        }

    }
}
