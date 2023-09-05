package book1.Methods;

import java.util.Scanner;

public class BiggestElementInArrPart {
    public static int biggestElement(int start, int end, int... arr) {
        int maxNum = arr[start];
        for (int i = start; i < end; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter array lenght: ");
        int lenght = input.nextInt();
        int[] arr = new int[lenght];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter current arr element: ");
            arr[i] = input.nextInt();
        }

        System.out.print("Enter start position: ");
        int start = input.nextInt();

        System.out.print("Enter end position: ");
        int end = input.nextInt();

        System.out.printf("Start position is %d, end position is %d, biggest between is %d",
                start, end, biggestElement(start, end, arr));
    }
}
