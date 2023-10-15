package book1.Linear.Data.Structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LDS_06 {
    public static void main(String[] args) {

        /*Write a program that removes from a given sequence all numbers that appear an odd count of times.*/

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of list: ");
        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter next integer: ");
            list.add(scanner.nextInt());
        }

        findEvenSequences(list);
    }

    private static void findEvenSequences(List<Integer> list) {
        ArrayList<Integer> listOfEventSequence = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i).equals(list.get(j))) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                listOfEventSequence.add(list.get(i));
            }
            count = 1;
        }
        for (int current : listOfEventSequence) {
            System.out.print(current + " ");
        }
    }
}
