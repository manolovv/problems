package book1.Linear.Data.Structures;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LDS_02 {
    public static void main(String[] args) {

        /*Write a program, which reads from the console N integers and prints them in reversed order.
        Use the Stack<int> class.*/

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N of inputs: ");
        int n = scanner.nextInt();

        ArrayDeque<Integer> numbers = new ArrayDeque<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter next integer: ");
            numbers.push(scanner.nextInt());
        }

        for (int integer : numbers) {
            System.out.print(integer + " ");
        }
    }
}
