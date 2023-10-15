package book1.Linear.Data.Structures;

import java.util.ArrayList;
import java.util.Scanner;

public class LDS_07 {
    public static void main(String[] args) {

        /*Write a program that finds in a given array of integers how many times each of them occurs.*/


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of list: ");
        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter next integer: ");
            list.add(scanner.nextInt());
        }
        System.out.print("Enter the searching number: ");
        int searchingNum = scanner.nextInt();

        timesOccurs(list, searchingNum);

    }

    public static void timesOccurs(ArrayList<Integer> list, int searchingNumber) {

        ArrayList<Integer> countNumbers = new ArrayList<>(list.size());

        int startIndx = list.indexOf(searchingNumber);
        int count = 0;

        for (int i = startIndx; i < list.size(); i++) {

            if (list.get(i).equals(searchingNumber)) {
                count++;
            }
        }
        System.out.println(searchingNumber + " --> " + count);
    }
}
