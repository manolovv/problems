package book1.Linear.Data.Structures;

import java.util.*;

public class LDS_03 {
    public static void main(String[] args) {

        /*Write a program that reads from the console a sequence of positive integer numbers.
        The sequence ends when an empty line is entered. Print the sequence sorted in ascending order.*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer: ");
        String num = scanner.nextLine();

        ArrayList<Integer> list = new ArrayList<>();

        while (!num.isEmpty()) {

            list.add(Integer.parseInt(num));
            num = scanner.nextLine();
        }

        Collections.sort(list);
        System.out.println(list);

    }
}
