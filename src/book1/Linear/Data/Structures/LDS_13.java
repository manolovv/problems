package book1.Linear.Data.Structures;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LDS_13 {

    /*Given a sequence consisting of parentheses, determine whether the expression is balanced.
    A sequence of parentheses is balanced if every open parenthesis can be paired uniquely with a closed parenthesis
    that occurs after the former. Also, the interval between them must be balanced.
    You will be given three types of parentheses: (, {, and [ */

//    {[()]} - This is a balanced parenthesis.
//    {[(])} - This is not a balanced parenthesis.

//    For each test case, print on a new line "YES"
//    if the parentheses are balanced. Otherwise, print "NO".

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sequence of parentheses: ");
        String parenthesesArr = scanner.nextLine();
        char[] chArr = parenthesesArr.toCharArray();

        boolean bol = areBalancedOrNot(chArr);

        if (bol) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static boolean areBalancedOrNot(char[] chArr) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char x : chArr) {

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }

            char current = stack.pop();
            switch (x) {
                case ')' -> {
                    if (current == '[' || current == '{') return false;
                    break;
                }
                case '}' -> {
                    if (current == '[' || current == '(') return false;
                    break;
                }
                case ']' -> {
                    if (current == '(' || current == '{') return false;
                    break;
                }
            }
        }
        return (stack.isEmpty());
    }
}
