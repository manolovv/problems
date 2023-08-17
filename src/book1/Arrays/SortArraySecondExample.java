package book1.Arrays;

import java.util.Arrays;

public class SortArraySecondExample {
    static void sel_sort (int numArray[]) {

        int n = numArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numArray[j] > numArray[i]) {
                    int temp = numArray[j];
                    numArray[j] = numArray[i];
                    numArray[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {2, 3, 723, 7, 3, 234, 1, 2, 265, 3};
        System.out.println("Original array is: " + Arrays.toString(array));

        sel_sort(array);
        System.out.println("The descending array is: " + Arrays.toString(array));
    }
}
