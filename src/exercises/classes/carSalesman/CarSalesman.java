package exercises.classes.carSalesman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {

    /*On the first line, you will read a number N which will specify how many lines of engines you will receive, on each
    of the next N lines you will receive information about an Engine in the following format
        "<Model> <Power> <Displacement> <Efficiency>". After the lines with engines, on the next line you will receive
    a number M – specifying the number of Cars that will follow, on each of the next M lines the information about a
    Car will follow in the following format "<Model> <Engine> <Weight> <Color>", where the engine in the format will
    be the model of an existing Engine. When creating the object for a Car, you should keep a reference to the real
    engine in it, instead of just the engines model, note that the optional properties might be missing from the
    formats. Your task is to print each car (in the order you received them) and its information in the format defined bellow.

    <CarModel>:
    <EngineModel>:
    Power: <EnginePower>
    Displacement: <EngineDisplacement>
    Efficiency: <EngineEfficiency>
    Weight: <CarWeight>
    Color: <CarColor>
    */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String input = scanner.nextLine();
            createEngine(input);
        }

        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            String input = scanner.nextLine();
            createCar(input);
        }
        carrList.forEach(System.out::println);
    }

    static List<Engine> engineeList = new ArrayList<>();
    static LinkedList<Car> carrList = new LinkedList<>();

    public static void createCar(String input) {
        String[] split = input.split("\\s+");

        Car carr = new Car();

        String carModel = split[0];
        carr.setModel(carModel);

        String engineModel = split[1];
        engineeList.forEach(e -> {
            if (e.getModel().equals(engineModel)) {
                carr.setEnginee(e);
            }
        });

        if (split.length == 4) {
            String color = split[3];
            int weight = Integer.parseInt(split[2]);

            carr.setColor(color);
            carr.setWeight(weight);

        } else if (split.length == 3) {
            if (isDigit(split[2])) {
                int weight = Integer.parseInt(split[2]);
                carr.setWeight(weight);
            } else {
                String color = split[2];
                carr.setColor(color);
            }
        }
        carrList.add(carr);
    }

    public static void createEngine(String input) {
        String[] split = input.split("\\s+");

        String model = split[0];
        int power = Integer.parseInt(split[1]);
        Engine engine = new Engine(model, power);

        if (split.length == 4) {
            String efficiency = split[3];
            int displacement = Integer.parseInt(split[2]);

            engine.setEfficiency(efficiency);
            engine.setDisplacement(displacement);

        } else if (split.length == 3) {
            if (isDigit(split[2])) {
                int displacement = Integer.parseInt(split[2]);
                engine.setDisplacement(displacement);
            } else {
                String efficiency = split[2];
                engine.setEfficiency(efficiency);
            }
        }
        engineeList.add(engine);
    }

    public static boolean isDigit(String string) {
        for (int i = 0; i < string.length(); i++) {
            int ascii = string.charAt(i);
            if (ascii > 47 && ascii < 58) {
                return true;
            }
        }
        return false;
    }
}

class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    Car() {
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEnginee(Engine enginee) {
        this.engine = enginee;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return (getModel() + "\n" + getEngine() + "\n" + "Weight: " +
                getWeight() + "\nColor: " + getColor());
    }
}

class Engine {
    private final String model;
    private final int power;
    private int displacement;
    private String efficiency;

    Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public String toString() {
        return (getModel() + ": \nPower: " + getPower() + "\nDisplacement: " +
                getDisplacement() + "\nEfficiency: " + getEfficiency());
    }
}