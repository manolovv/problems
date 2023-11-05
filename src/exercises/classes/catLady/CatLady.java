package exercises.classes.catLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CatLady {

    /*Ginka has 3 specific breeds of cats "Siamese", "Cymric" and the very famous bulgarian breed
        "Street Extraordinaire", each breed has a specific characteristic about which information
    should be kept. For the Siamese cats their ear size should be kept, for Cymric cats - the length
    of their fur in milimeters and for the Street Extraordinaire the decibels of their meowing during the night.
    From the console you will receive lines of cat information until the command "End" is received,
    the information will come in one of the following formats:
            "Siamese <name> <earSize>"
            "Cymric <name> <furLength>"
            "StreetExtraordinaire <name> <decibelsOfMeows"

    On the last line after the "End" command you will receive the name of a cat, you should print that cat.
    Round the numbers two digits after the decimal separator.
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> catMap = new HashMap<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] split = input.split("\\s+");
            String catName = split[1];
            String catBreed = split[0];
            String catCharacteristic = split[2];

            catMap.putIfAbsent(catName, new Cat(catName, catBreed, catCharacteristic));
        }
        String searchingName = scanner.nextLine();
        Cat neededCat = catMap.get(searchingName);

        System.out.println(neededCat);
    }
}

class Cat {
    private final String name;
    private final String breed;
    private final String characteristics;

    public Cat(String name, String breed, String characteristics) {
        this.name = name;
        this.breed = breed;
        this.characteristics = characteristics;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public String toString() {
        return breed + " " + name + " " + Double.parseDouble(characteristics);
    }
}
