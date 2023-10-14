package book1.Linear.Data.Structures;

import java.util.ArrayList;
import java.util.Scanner;

public class LDS_01 {
    public static void main(String[] args) {

/*        Write a program that reads from the console a sequence of positive integer numbers.
         The sequence ends when empty line is entered. Calculate and print the sum and the average of the sequence.
         Keep the sequence in List<int>.*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer: ");
        String num = scanner.nextLine();

        ArrayList<Integer> list = new ArrayList<>();

        while (!num.isEmpty()) {

            list.add(Integer.parseInt(num));
            num = scanner.nextLine();
        }

        int sum = 0;
        for (int indx : list) {
            sum += indx;
        }

        System.out.println(sum);
        int average = sum / list.size();
        System.out.println(average);
    }
}
