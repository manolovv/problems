package book1.Arrays;

import java.util.Scanner;

public class SumOfOddNumsFom1ToNWithout7 {
    public static void main(String[] args) {

        Scanner Input = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = Input.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i += 2){
            if (i % 7 == 0){
                continue;
            }
            sum += i;
        }
        System.out.println("Sum = " + sum);
    }
}
