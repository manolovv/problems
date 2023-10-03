package book1.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Arrays_13 {
    public static void main(String[] args) {

        //Write a program, which creates a rectangular array with size of n by m elements.
        // The dimensions and the elements should be read from the console.
        // Find a platform with size of (3, 3) with a maximal sum.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int r = scanner.nextInt();
        System.out.print("Enter cows: ");
        int c = scanner.nextInt();

        int[][] matrix = new int[r][c];

        inputMatrix(scanner, r, c, matrix);

        printMatrix(r, c, matrix);

        getResult(matrix);
    }

    private static void getResult(int[][] matrix) {
        int sum = 0;
        int bestSum = 0;
        int bestRow = 0;
        int bestCol = 0;

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
                sum = 0;
            }
            printResult(matrix, bestSum, bestRow, bestCol);
        }
    }

    private static void printResult(int[][] matrix, int bestSum, int bestRow, int bestCol) {
        System.out.println("Best 3x3 submatrix is: ");
        System.out.printf("%d, %d, %d%n", matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1], matrix[bestRow][bestCol + 2]);
        System.out.printf("%d, %d, %d%n", matrix[bestRow +1][bestCol], matrix[bestRow +1][bestCol + 1], matrix[bestRow +1][bestCol + 2]);
        System.out.printf("%d, %d, %d%n", matrix[bestRow + 2][bestCol], matrix[bestRow + 2][bestCol + 1], matrix[bestRow + 2][bestCol + 2]);
        System.out.printf("The sum is: %d !", bestSum);
    }

    private static void printMatrix(int r, int c, int[][] matrix) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void inputMatrix(Scanner scanner, int r, int c, int[][] matrix) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("[%d][%d] = ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
