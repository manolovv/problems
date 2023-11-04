package exercises.classes.rawData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String input = scanner.nextLine();
            createCar(input);
        }

        String input = scanner.nextLine();
        List<String> result = new ArrayList<>();

        if (input.equals("fragile")) {
            cars.forEach(e -> {
                if (e.getCargo().getType().equals("fragile")) {
                    for (Tire tyre : e.getTires()) {
                        if (tyre.getPressure() <= 1) {
                            result.add(e.getModel());
                            break;
                        }
                    }
                }
            });

        } else if (input.equals("flamable")) {
            cars.forEach(e -> {
                if (e.getCargo().getType().equals("flamable")) {
                    if (e.getEngine().getPower() >= 250) {
                        result.add(e.getModel());
                    }
                }
            });
        }

        result.forEach(System.out::println);
    }

    static LinkedList<Cars> cars = new LinkedList<>();
    private static void createCar(String input) {
        String[] split = input.split("\\s+");

        int hp = Integer.parseInt(split[2]);
        Engine engine = new Engine(hp);

        String type = split[4];
        Cargo cargo = new Cargo(type);

        Tire tire1 = new Tire(Double.parseDouble(split[5]), Integer.parseInt(split[6]));
        Tire tire2 = new Tire(Double.parseDouble(split[7]), Integer.parseInt(split[8]));
        Tire tire3 = new Tire(Double.parseDouble(split[9]), Integer.parseInt(split[10]));
        Tire tire4 = new Tire(Double.parseDouble(split[11]), Integer.parseInt(split[12]));

        String model = split[0];

        Cars car = new Cars(model, engine, cargo, tire1, tire2, tire3, tire4);

        cars.add(car);
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