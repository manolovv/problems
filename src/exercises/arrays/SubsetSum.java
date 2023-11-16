package exercises.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    /*Write a program, which checks whether there is a subset of given array of N elements, which has a sum S.
    The numbers N, S and the array values are read from the console. Same number can be used many times.
     */

    public static void main(String[] args) {

        int[] arr = {9, 6, 9, 13, 1, 23, 9, 5};
        int s = 14;

        for (int i = 0; i < arr.length - 1; i++) {

            int sum = arr[i];
            List<Integer> found = new ArrayList<>();
            found.add(arr[i]);

            boolean finish = false;
            for (int j = i + 1; j < arr.length; j++) {

                if (sum < s) {
                    sum += arr[j];

                    if (sum == s) {
                        found.add(arr[j]);
                        finish = true;
                        break;

                    } else if (sum > s) {
                        sum -= arr[j];

                    } else {
                        found.add(arr[j]);
                    }
                }
            }
            if (finish) {
                System.out.print("\nS = " + s + " -> ");
                for (int element : found) {
                    System.out.print(element + " ");
                }
            }
        }
    }
}
