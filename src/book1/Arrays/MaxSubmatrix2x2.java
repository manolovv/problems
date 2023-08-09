package book1.Arrays;

public class MaxSubmatrix2x2 {
    public static void main(String[] args) {

        int[][] matrix = {
                { 2, 4, 6, 7, 1, 0 },
                { 2, 2, 9, 10, 3, 7 },
                { 7, 17, 7, 3, 6, 2 },
                { 1, 13, 9, 4, 5, 6 }
        };
        int bestSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 1; row++){
            for (int col = 0; col < matrix[0].length - 1; col++){
                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > bestSum){
                    bestSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.println("Best SubMatrix is: ");
        System.out.printf("%d %d %n", matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]);
        System.out.printf("%d %d %n", matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]);
        System.out.printf("The sum is: %d", bestSum);
    }
}
