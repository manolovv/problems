package book1;

import java.util.Scanner;

public class FindMinAndMaxNumWithoutArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nums: ");
        int numbers = sc.nextInt();
        int smaller = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        System.out.println("Please enter your " + numbers + " numbers.");

        for(int i = 0; i < numbers; i++){

            int current = sc.nextInt();

            if (current > large){
                large = current;
            }
            if (current < smaller){
                smaller = current;
            }
        }
        System.out.println("The biggest from " + numbers + " numbers is: " + large);
        System.out.println("The smaller from " + numbers + " numbers is: " + smaller);
    }
}
