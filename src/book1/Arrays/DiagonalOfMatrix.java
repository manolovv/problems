package book1.Arrays;

public class DiagonalOfMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 6, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
        };

        takeDiagonal(matrix);
    }

    static void takeDiagonal(int[][] matrix) {

        int lenght = matrix.length;
        int rows = 0;
        int cols = 0;

        // Diagonal with start position matrix[0][0];
        while ((rows < lenght) && (cols < lenght)) {
            System.out.print(matrix[rows++][cols++] + " ");
        }

        System.out.println();
        System.out.println("------");

        rows = lenght - 1;
        cols = 0;

        // Diagonal with start position matrix[4][0];
        while ((rows >= 0) && (cols < lenght)) {
            System.out.print(matrix[rows--][cols++] + " ");
        }

        System.out.println();
        System.out.println("------");

        rows = 0;
        cols = lenght - 1;

        // Diagonal with start position matrix[0][4];
        while ((rows < lenght) && (cols >= 0)) {
            System.out.print(matrix[rows++][cols--] + " ");
        }

        System.out.println();
        System.out.println("------");

        rows = lenght - 1;
        cols = lenght - 1;

        // Diagonal with start position matrix[4][4];
        while ((rows >= 0) && (cols >= 0)) {
            System.out.print(matrix[rows--][cols--] + " ");
        }
    }
}
