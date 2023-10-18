package book1.Linear.Data.Structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LDS_08 {
    public static void main(String[] args) {

        /*The majorant of an array of size N is a value that occurs in it at least N/2 + 1 times.
            Write a program that finds the majorant of given array and prints it. If it does not exist,
                print "The majorant does not exist!".*/

        //Example: {2, 2, 3, 3, 2, 3, 4, 3, 3} --> 3


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of list: ");
        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter next integer: ");
            list.add(scanner.nextInt());
        }
        findTheMajorantNumber(list);

    }

    private static void findTheMajorantNumber(ArrayList<Integer> list) {

        Collections.sort(list);
        int majorantSize = list.size() / 2 + 1;
        int count = 0;
        boolean bol = true;

        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i).equals(list.get(i + 1))) {
                count++;
            } else if (majorantSize <= count) {
                System.out.println("The majorant number is: " + list.get(i));
                bol = false;
                break;
            }
        }
        if (bol) {
            System.out.println("The majorant does not exist!");
        }
    }
}
