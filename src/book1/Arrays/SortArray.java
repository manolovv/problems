package book1.Arrays;

import java.util.Arrays;

public class SortArray {

    static void  sel_sort (int numArray[]) {

        int n = numArray.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (numArray[j] < numArray[minIndex]) {
                    minIndex = j;

                    int temp = numArray[minIndex];
                    numArray[minIndex] = numArray[i];
                    numArray[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int array[] = {23, 12, 4, 123, 53, 2, 5};
        System.out.println("Original array: " + Arrays.toString(array));

        sel_sort(array);
        System.out.println("Ascending order: " + Arrays.toString(array));
    }
}
