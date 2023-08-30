package book1.Methods;

import java.util.Scanner;

public class NumberInArr {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter num: ");
        int num = input.nextInt();
        int[] array = {10, 2, 5, 2, 4, 6, 6, 12, 6, 3, 66};

        searchNum(num, array);
    }

    public static void searchNum(int num, int... arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                count++;
            }
        }
        System.out.printf("The number %d is found %d times in the given array.", num, count);
    }
}
