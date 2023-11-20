package book1.Arrays;

import java.util.Scanner;

public class PrintTriangleExample {
    public static void main(String[] args) {

        Scanner Input = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = Input.nextInt();

        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= row; col++){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
