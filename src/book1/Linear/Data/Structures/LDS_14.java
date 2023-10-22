package book1.Linear.Data.Structures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LDS_14 {

        /*You are given an empty text. Your task is to implement 4 types of commands related to manipulating the text:
        "1 [string]" - appends [string] to the end of the text
	    "2 [count]" - erases the last [count] elements from the text
	    "3 [index]" - returns the element at position [index] from the text
	    "4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation
        For each operation of type "3" print a single line with the returned character of that operation.*/


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of operations N: ");
        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> stack = new ArrayDeque<>();
        String text = "";

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of operation and command argument: ");
            String[] commandAndArg = scanner.nextLine().split(" ");


            switch (commandAndArg[0]) {
                case "1" -> {
                    stack.push(text);
                    text += commandAndArg[1];
                }
                case "2" -> {
                    stack.push(text);
                    int count = Integer.parseInt(commandAndArg[1]);
                    text = text.substring(0, text.length() - count);
                }
                case "3" -> {
                    int indx = Integer.parseInt(commandAndArg[1]);
                    System.out.println(text.charAt(indx - 1));
                }
                case "4" -> {
                    text = stack.pop();
                }
            }
        }
    }
}
