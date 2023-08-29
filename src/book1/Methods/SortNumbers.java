package book1.Methods;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {

        int[] num = sortArr(23, 4, 12, 0, -1, 20, 3, 7, 2);
        printArr(num);
    }

    public static int[] sortArr(int... num) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[i]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        return num;
    }

    public static void printArr(int... num) {
        for (int i = 0; i < num.length; i++) {
            System.out.printf("%d ", num[i]);
        }
    }
}
