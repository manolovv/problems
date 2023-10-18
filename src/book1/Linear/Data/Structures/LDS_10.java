package book1.Linear.Data.Structures;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LDS_10 {
    public static void main(String[] args) {

        /*You will be given an integer N representing the number of elements to push onto the stack,
                an integer S representing the number of elements to pop from the stack and finally an integer X,
                an element that you should check whether is present in the stack. If it is, print true on the console.
                If it’s not, print the smallest element currently present in the stack.*/

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input times N: ");
        int n = scanner.nextInt();
        System.out.print("Enter the pop times S: ");
        int s = scanner.nextInt();
        System.out.print("Enter the element X that you should check whether is present  in the stack: ");
        int x = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter next stack integer: ");
            stack.push(scanner.nextInt());
        }

        int min = Integer.MAX_VALUE;
        boolean bol = true;

        for (int i = 0; i < s; i++) {
            int pop = stack.pop();

            if (pop == x) {
                System.out.print("True");
                bol = false;
                break;
            } else {
                if (pop < min) {
                    min = pop;
                }
            }
        }
        if (bol) {
            System.out.print(min);
        }
    }
}
