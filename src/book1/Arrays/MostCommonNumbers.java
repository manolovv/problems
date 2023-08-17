package book1.Arrays;

public class MostCommonNumbers {
    private static void sort(int numArray[]) {

        int n = numArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numArray[j] < numArray[i]) {
                    int temp = numArray[j];
                    numArray[j] = numArray[i];
                    numArray[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int array[]= new int[]{1, 23, 3, 4, 1, 99, 4, 4, 11, 7, 6, 1, 4};
        sort(array);
        int currentNum = array[0];
        int lastNum = 1;
        int maxCount =1;
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (currentNum == array[i]) {
                count += 1;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    lastNum = currentNum;
                }
                count = 1;
            }
            currentNum = array[i];
        }
        for (int j = 0; j < maxCount; j++) {
            System.out.print(lastNum + " ");
        }
    }
}
