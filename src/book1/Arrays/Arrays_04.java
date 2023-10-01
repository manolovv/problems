package book1.Arrays;

import java.util.Arrays;

public class Arrays_04 {
    public static void main(String[] args) {

        //Condition
        //Write a program, which finds the maximal sequence of consecutive equal elements in an array.

        int[] arr = {1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 6, 6, 7};

        int count = 1;
        int bestCount = 0;
        int position = 0;
        int bestPosition = 0;
        int startPosition = 0;
        int number = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1]) {
                count++;
                position = i + 1;
            }else {
                count = 1;
                position = 0;
            }

            if (count > bestCount) {
                bestCount = count;
                bestPosition = position;
            }
        }
        startPosition = bestPosition - bestCount + 1;
        number = arr[startPosition];

        int[] arrOfEquals = new int[bestCount];
        for (int i = 0; i < arrOfEquals.length; i++) {
            arrOfEquals[i] = number;

        }
        System.out.println(Arrays.toString(arrOfEquals));

    }
}
