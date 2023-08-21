package book1.Arrays;

import java.util.Scanner;

public class SquareOfMatrix2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows; ");
        int rows = input.nextInt();
        System.out.print("Enter number of cols: ");
        int cols = input.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = (col * rows + 1) + row;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
