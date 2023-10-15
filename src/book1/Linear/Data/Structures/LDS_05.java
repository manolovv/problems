package book1.Linear.Data.Structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LDS_05 {
    public static void main(String[] args) {

        /*Write a program, which removes all negative numbers from a sequence.
                Example: array = {19, -10, 12, -6, -3, 34, -2, 5} --> {19, 12, 34, 5}*/

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of list: ");
        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter next integer: ");
            list.add(scanner.nextInt());
        }

        searchForPositiveNumbers(list);

    }

    public static void searchForPositiveNumbers(List<Integer> list) {

        ArrayList<Integer> positiveNumberList = new ArrayList<>(list.size());

        for (int current : list) {

            if (current >= 0) {
                positiveNumberList.add(current);
            }
        }
        for (int current : positiveNumberList) {
            System.out.print(current + " ");
        }
    }
}
