package exercises.arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {6, 3, 9, 12, 4, 6, 2 , 1};
        printArray(arr);
        System.out.println();

        int[] ascendingSort = AscendingSort(arr);
        printArray(ascendingSort);
        System.out.println();

        int[] descendingSort = DescendingSort(arr);
        printArray(descendingSort);
        System.out.println();
    }

    public static int[] DescendingSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static int[] AscendingSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
