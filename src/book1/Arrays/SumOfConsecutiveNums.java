package book1.Arrays;

import java.util.Scanner;

public class SumOfConsecutiveNums {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Your input: ");
        int s = input.nextInt();
        int array[] = {1, 2, 3, 9, 8, 6, 5, 4};
        int start = 1;
        int end = 1;
        int sum = 1;
        boolean found = false;

        for (int i = 0; i < array.length - 1; i++) {
            sum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                sum += array[j];
                if (sum == s) {
                    start = i;
                    end = j;
                    found = true;
                }
            }
            if (found) break;
        }
        if (found){
            System.out.print("This is the series of numbers who is equal to input num: ");
            for (int i = start; i <= end; i++) {
                System.out.print(array[i] + " ");
            }
        }else {
            System.out.print("Enter num is not equal to sum on any series of nums.");
        }
    }
}
