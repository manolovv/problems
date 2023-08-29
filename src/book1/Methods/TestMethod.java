package book1.Methods;

import java.util.Scanner;

public class TestMethod {
    public static void helloPerson(String name) {
        System.out.printf("Hello, %s !", name);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = input.next();
        helloPerson(name);
    }
}
