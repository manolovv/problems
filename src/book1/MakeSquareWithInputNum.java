package book1;

import java.util.Scanner;

public class MakeSquareWithInputNum {
    public static void main(String[] args) {

        Scanner Input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = Input.nextInt();

        for (int rows = 0; rows <= n; rows++){
            for (int cols = 0; cols <= n; cols++){
                System.out.print(cols + "  ");
            }
            System.out.println();
        }
    }
}
