package book1.Arrays;

public class DiagonalsOfMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 6, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
        };

        int length = matrix.length;
        int row = 0;
        int col = length - 1;

        while (row < length) {
            int innerRow = row;
            int innerCol = col;

            while ((innerRow < length) && (innerCol < matrix[0].length)) {
                System.out.print(matrix[innerRow++][innerCol++] + " ");
            }

            System.out.println();
            if (col > 0) {
                col--;
            }

            if (col <= 0) {
                row++;
            }
        }
    }
}
