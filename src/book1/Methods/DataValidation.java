package book1.Methods;

import java.util.Scanner;

public class DataValidation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("That time is it in HH? : ");
        int hours = input.nextInt();
        System.out.print("That time is it in MM? : ");
        int minutes = input.nextInt();

        if (validHours(hours) && validMinutes(minutes)) {
            System.out.printf("The time is %d:%d now.", hours, minutes);
        } else {
            System.out.print("Incorrect time!");
        }
    }

    public static boolean validHours(int hours) {
        boolean result = (hours >= 0) && (hours <= 23);
        return result;
    }

    public static boolean validMinutes(int minutes) {
        boolean result = (minutes >= 0) && (minutes <= 59);
        return result;
    }
}
