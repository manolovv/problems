package book1.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class AreTwoArraysEuqal {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter first array elements: ");
        int a = input.nextInt();
        System.out.print("Enter second array elements: ");
        int b = input.nextInt();
        int[] array1 = new int[a];
        int[] array2 = new int[b];

        System.out.println("Enter first array values: ");
        for (int i = 0; i < array1.length; i++){
            array1[i] = input.nextInt();
        }

        System.out.println("Enter second array values: ");
        for (int j = 0; j < b; j++){
            array2[j] = input.nextInt();
        }

        if (Arrays.equals(array1, array2)){
            System.out.println("Arrays is euqal!");
        }
        else{
            System.out.println("Its not same!");
        }
    }
}
