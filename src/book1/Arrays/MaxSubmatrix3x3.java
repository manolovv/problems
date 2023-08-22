package book1.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSubmatrix3x3 {
    public static void main(String[] args) {

        //Scanner input = new Scanner(System.in);
        //System.out.print("Enter matrix rows: ");
        //int rows = input.nextInt();
        //System.out.print("Enter matrix cols: ");
        //int cols = input.nextInt();

        int sum = 0;
        int bestSum = 0;
        int bestRow = 0;
        int bestCol = 0;

        int[][] matrix = {
                { 2, 4, 6, 7, 1, 0, 24, 54, 32, 56, 32 },
                { 2, 2, 9, 10, 3, 7, 66, 53, 86, 45, 75 },
                { 7, 17, 7, 3, 6, 2, 23, 74, 12, 57, 99 },
                { 1, 13, 9, 4, 5, 6, 34, 3, 2, 4, 6 }
        };
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > bestSum) {
                    bestSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.printf("%d , %d , %d %n", matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1], matrix[bestRow][bestCol + 2]);
        System.out.printf("%d , %d , %d %n", matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1], matrix[bestRow + 1][bestCol + 2]);
        System.out.printf("%d , %d , %d %n", matrix[bestRow + 2][bestCol], matrix[bestRow + 2][bestCol + 1], matrix[bestRow + 2][bestCol + 2]);
        System.out.printf("Trey sum are equal to: %d", bestSum);
    }
}
