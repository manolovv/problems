package exercises.arrays;

public class ConsecutiveEqualsElements {

    /*Write a program, which finds the maximal sequence of consecutive equal elements in an array. E.g.:
    {1, 1, 2, 3, 3, 2, 2, 2, 1} -> {2, 2, 2}
    */

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3, 3, 2, 2, 2, 1};

        int count = 1;
        int element = 0;
        int bestCount = 0;
        int bestElement = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int k = i + 1;

            if (arr[i] == arr[k]) {
                count++;
                element = arr[i];
            } else {
                if (count > bestCount) {
                    bestCount = count;
                    bestElement = element;
                }
                count = 1;
            }
        }
        for (int i = 0; i < bestCount; i++) {
            System.out.print(bestElement + " ");
        }
    }
}
