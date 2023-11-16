package exercises.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    /*Write a program, which finds the maximal sequence of increasing elements in an array arr[n].
    It is not necessary the elements to be consecutively placed. E.g.:
    */

    public static void main(String[] args) {

        int[] arr = {9, 6, 2, 7, 4, 7, 6, 5, 8, 4};
        int[] bestLength = new int[arr.length];
        int[] prevIndex = new int[arr.length];
        int lastIndex = -1;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            bestLength[i] = 1;
            prevIndex[i] = -1;

            for (int j = 0; j < i; j++) {

                if (arr[j] <= arr[i] && bestLength[j] + 1 > bestLength[i]) {

                    bestLength[i] = bestLength[j] + 1;
                    prevIndex[i] = j;
                }
            }
            if (bestLength[i] > maxLen) {
                maxLen = bestLength[i];
                lastIndex = i;
            }
        }
        for (int element : bestSubsequence(arr, prevIndex, lastIndex)) {
            System.out.print(element + " ");
        }
    }

    public static List<Integer> bestSubsequence(int[] arr, int[] prev, int lastIndex) {
        List<Integer> result = new ArrayList<>();

        while (lastIndex != -1) {
            result.add(arr[lastIndex]);
            lastIndex = prev[lastIndex];
        }
        Collections.reverse(result);
        return result;
    }
}
