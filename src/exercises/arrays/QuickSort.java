package exercises.arrays;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {10, 9, 26, 15, 50, 20, 25};

        printArr(arr);
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    public static int partition(int[] arr, int left, int right) {

        int i = left;

        for (int j = left; j < arr.length - 1; j++) {

            if (arr[j] < arr[right]) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left < right) {

            int p = partition(arr, left, right);

            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
