package exercises.arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    /*Write a program, which reads an array of integer numbers from the console and removes a minimal number
    of elements in such a way that the remaining array is sorted in an increasing order.
    Example: {6, 1, 4, 3, 0, 3, 6, 4, 5} -> {1, 3, 3, 4, 5}
    */

    public static void main(String[] args) {

        int[] arr = {6, 1, 4, 3, 0, 3, 6, 4, 5};
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
