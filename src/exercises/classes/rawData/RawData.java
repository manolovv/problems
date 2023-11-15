package exercises.classes.rawData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RawData {

    /*You are the owner of a courier company and you want to make a system for tracking your cars and their cargo.
    Define a class Car that holds information about model, engine, cargo and a collection of exactly 4 tires.
    The engine, cargo and tire should be separate classes, create a constructor that receives all information about
    the Car and creates and initializes its inner components (engine, cargo and tires).
    On the first line of the input you will receive a number N - the number of cars you have, on each of the next
    N lines you will receive information about a car in the format "<Model> <EngineSpeed> <EnginePower> <CargoWeight>" +
        " <CargoType> <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure>" +
        " <Tire4Age>" where the speed, power, weight and tire age are integers, tire pressure is a double.
    After the N lines you will receive a single line with one of 2 commands "fragile" or "flamable" , if the command
        is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1, if the command
        is "flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250. The cars should be
    printed in order of appearing in the input.*/

    static LinkedList<Cars> cars = new LinkedList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> result = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String input = scanner.nextLine();
            createCar(input);
        }

        String input = scanner.nextLine();
        if (input.equals("fragile")) {
            cars.forEach(e -> addFragile(e, result));

        } else if (input.equals("flamable")) {
            cars.forEach(e -> addFlammable(e, result));
        }

        result.forEach(System.out::println);
    }

    private static void addFlammable(Cars e, List<String> result) {
        if (e.getCargo().getType().equals("flamable")) {
            if (e.getEngine().getPower() >= 250) {
                result.add(e.getModel());
            }
        }
    }

    private static void addFragile(Cars e, List<String> result) {
        if (e.getCargo().getType().equals("fragile")) {
            for (Tire tyre : e.getTires()) {
                if (tyre.getPressure() <= 1) {
                    result.add(e.getModel());
                    break;
                }
            }
        }
    }


    private static void createCar(String input) {
        String[] split = input.split("\\s+");

        Engine engine = createEngine(split);

        Cargo cargo = createCargo(split);

        Tires tires = createTires(split);

        String model = split[0];

        Cars car = new Cars(model, engine, cargo, tires.tire1(), tires.tire2(), tires.tire3(), tires.tire4());

        cars.add(car);
    }

    private static Tires createTires(String[] split) {
        Tire tire1 = new Tire(Double.parseDouble(split[5]), Integer.parseInt(split[6]));
        Tire tire2 = new Tire(Double.parseDouble(split[7]), Integer.parseInt(split[8]));
        Tire tire3 = new Tire(Double.parseDouble(split[9]), Integer.parseInt(split[10]));
        Tire tire4 = new Tire(Double.parseDouble(split[11]), Integer.parseInt(split[12]));
        return new Tires(tire1, tire2, tire3, tire4);
    }

    private record Tires(Tire tire1, Tire tire2, Tire tire3, Tire tire4) {
    }

    private static Cargo createCargo(String[] split) {
        String type = split[4];
        return new Cargo(type);
    }

    private static Engine createEngine(String[] split) {
        int hp = Integer.parseInt(split[2]);
        return new Engine(hp);
    }

}

class Cars {
    private final String model;
    private final Engine engine;
    private final Cargo cargo;
    private final Tire tire1;
    private final Tire tire2;
    private final Tire tire3;
    private final Tire tire4;

    Cars(String model, Engine engine, Cargo cargo, Tire tire1, Tire tire2, Tire tire3, Tire tire4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTires() {
        return new Tire[]{tire1, tire2, tire3, tire4};
    }

}

class Engine {
    private final int power;

    Engine(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}

class Tire {
    private final double pressure;

    Tire(double pressure, int ignoredAge) {
        this.pressure = pressure;
    }

    public double getPressure() {
        return pressure;
    }
}

class Cargo {
    private final String type;

    Cargo(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}