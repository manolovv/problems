package book1.Arrays;

import java.util.Arrays;

public class Arrays_05 {
    public static void main(String[] args) {

        //Write a program, which finds the maximal sequence of consecutively placed increasing integers.
        //Example: {3, 2, 3, 4, 2, 2, 4} --> {2, 3, 4}.

        int[] arr = {3, 5, 2, 4, 5, 6, 9, 10, 11, 12, 13, 8, 7, 5};

        int count = 1;
        int bestCount = 0;
        int position = 0;
        int bestPosition = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1] + 1) {
                count++;
                position = i;
            }else {
                count = 1;
                position = 0;
            }

            if (count > bestCount) {
                bestCount = count;
                bestPosition = position;
            }
        }
        int startPosition;
        int firstNumber;
        startPosition = bestPosition - bestCount + 1;
        firstNumber = arr[startPosition];

        int[] arrOfIncreasing = new int[bestCount];
        for (int i = 0; i < arrOfIncreasing.length; i++) {
            arrOfIncreasing[i] = firstNumber++;
        }
        System.out.println(Arrays.toString(arrOfIncreasing));

    }
}
