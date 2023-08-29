package book1.Methods;

import java.util.Scanner;

public class FarenheitToCelcius {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.print("Enter your bodytemperature in Farenheit: ");
        double temperature = Input.nextInt();

        temperature = ConvertFromFtoCelcius(temperature);
        System.out.println("Your body temperature in Celcius degrees is: " + temperature);

        if (temperature > 37) {
            System.out.println("You are ill!");
        }
    }

    public static double ConvertFromFtoCelcius(double tempF) {
        double temperatureInCelcius = (tempF - 32) * 5 / 9;
        return temperatureInCelcius;
    }
}
