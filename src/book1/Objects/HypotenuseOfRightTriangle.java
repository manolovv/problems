package book1.Objects;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class HypotenuseOfRightTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();


        double hypotenuse = Math.sqrt((a * a) + (b * b));
        System.out.printf("%.2f", hypotenuse);
    }
}
