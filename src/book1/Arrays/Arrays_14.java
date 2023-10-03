package book1.Arrays;

import java.util.Scanner;

public class Arrays_14 {
    public static void main(String[] args) {

        //Write a program, which finds the longest sequence of equal string elements in a matrix.
        // A sequence in a matrix we define as a set of neighbor elements on the same row, column or diagonal.

        //int[][] matrix = {
        //        {6, 3, 3},
        //        {4, 6, 3},
        //        {4, 2, 6},
        //};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int r = scanner.nextInt();
        System.out.print("Enter cols: ");
        int c = scanner.nextInt();

        String[][] matrix = new String[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("matrix[%d][%d]= %n", i, j);
                matrix[i][j] = scanner.next();
            }
        }

        int count = 1;
        int bestCount = 0;
        String num = null;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length - 1; cols++) {

                if (matrix[rows][cols].equals(matrix[rows][cols + 1])) {
                    count++;
                }
                if (count > bestCount) {
                    bestCount = count;
                    num = matrix[rows][cols];
                }
            }
            count = 1;
        }

        for (int cols = 0; cols < matrix[0].length; cols++) {
            for (int rows = 0; rows < matrix.length - 1; rows++) {

                if (matrix[rows][cols].equals(matrix[rows + 1][cols])) {
                    count++;
                }
                if (count > bestCount) {
                    bestCount = count;
                    num = matrix[rows][cols];
                }
            }
            count = 1;
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                for (int row = i, col = j; row < matrix.length - 1 && col < matrix[0].length - 1; row++, col++) {

                    if (matrix[row][col].equals(matrix[row + 1][col + 1])) {
                        count++;
                    }
                    if (count > bestCount) {
                        bestCount = count;
                        num = matrix[i][j];
                    }
                }
                count = 1;
            }
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int row = i, col = j; row < matrix.length - 1 && col > 0; row++, col--) {

                    if (matrix[row][col].equals(matrix[row + 1][col - 1])) {
                        count++;
                    }
                    if (count > bestCount) {
                        bestCount = count;
                        num = matrix[i][j];
                    }
                }
                count = 1;
            }
        }
        for (int i = 0; i < bestCount; i++) {
            System.out.printf("%s ", num);
        }
    }
}
