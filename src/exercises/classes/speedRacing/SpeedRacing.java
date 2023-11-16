package exercises.classes.speedRacing;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Your task is to implement a program that keeps track of cars and their fuel and supports methods for moving the cars.
Define a class Car that keeps track of a car information Model, fuel amount, fuel cost for 1 kilometer and
distance traveled. A Car Model is unique - there will never be 2 cars with the same model.
On the first line of the input you will receive a number N - the number of cars you need to track, on each of
the next N lines you will receive information for a car in the following format
"<Model> <FuelAmount> <FuelCostFor1km>", all cars start at 0 kilometers traveled.

After the N lines until the command "End" is received, you will receive commands in the following format
"Drive <CarModel>  <amountOfKm>", implement a method in the Car class to calculate whether a car can move
that distance or not. If it yes, the car fuel amount should be reduced by the amount of used fuel and its
distance traveled should be increased by the amount of kilometers traveled, otherwise the car should not move
(Its fuel amount and distance traveled should stay the same) and you should print on the console
"Insufficient fuel for the drive". After the "End" command is received, print each car in order of appearing
in input and its current fuel amount and distance traveled in the format "<Model> <fuelAmount>  <distanceTraveled>",
where the fuel amount should be printed to two decimal places after the separator.*/

public class SpeedRacing {

    static List<Car> carList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String input = scanner.nextLine();
            addCar(input);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            tryToDrive(input);

            input = scanner.nextLine();
        }

        printResult();
    }

    private static void printResult() {
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    private static void tryToDrive(String input) {
        String[] split = input.split("\\s+");
        String model = split[1];
        int distance = Integer.parseInt(split[2]);

        for (Car car : carList) {
            if (car.getModel().equals(model)) {
                car.fuelCalculate(distance);
            }
        }
    }

    private static void addCar(String input) {
        String[] split = input.split("\\s+");
        String model = split[0];
        double fuelAmount = Double.parseDouble(split[1]);
        double fuelCost = Double.parseDouble(split[2]);

        Car car = new Car(model, fuelAmount, fuelCost);
        carList.add(car);
    }

}
class Car {
    private final String model;
    private double fuelAmount;
    private final double fuelCostKilometer;
    private int distance;

    Car(String model, double fuelAmount, double fuelCostKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostKilometer = fuelCostKilometer;
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostKilometer() {
        return fuelCostKilometer;
    }

    public int getDistance() {
        return distance;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void fuelCalculate(int km) {
        double fuelNeeded = this.getFuelCostKilometer() * km;
        if (fuelNeeded <= this.getFuelAmount()) {
            this.setFuelAmount(this.getFuelAmount() - fuelNeeded);
            this.setDistance(this.getDistance() + km);
        } else {
            System.out.print("\nInsufficient fuel for the drive..");
        }
    }

    public String toString() {
        return String.format("%s, %.2f, %d", getModel(), getFuelAmount(), getDistance());
    }
}
