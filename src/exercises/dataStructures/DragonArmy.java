package exercises.dataStructures;

import java.util.*;

public class DragonArmy {

    /*You need to categorize dragons by their type. For each dragon, identified by name, keep information about his stats.
    Type is preserved as in the order of input, but dragons are sorted alphabetically by name. For each type,
    you should also print the average damage, health and armor of the dragons. For each dragon, print his own stats.
    There may be missing stats in the input, though. If a stat is missing you should assign it default values.
    Default values are as follows: health 250, damage 45, and armor 10. Missing stat will be marked by null.
    The input is in the following format {type} {name} {damage} {health} {armor}. Any of the integers may be
    assigned null value. See the examples below for better understanding of your task.
    If the same dragon is added a second time, the new stats should overwrite the previous ones.
    Two dragons are considered equal if they match by both name and type.
            Output:
     - Print the aggregated data on the console
     - For each type, print average stats of its dragons in format {Type}::({damage}/{health}/{armor})
     - Damage, health and armor should be rounded to two digits after the decimal separator
     - For each dragon, print its stats in format -{Name} -> damage: {damage}, health: {health}, armor: {armor}*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeMap<String, List<Integer>>> map = new LinkedHashMap<>();

        int timeRepeat = Integer.parseInt(scanner.nextLine());
        while (timeRepeat-- > 0) {
            String[] split = scanner.nextLine().split("\\s+");
            String type = split[0];
            String name = split[1];
            int damage = split[2].equals("null") ? 45 : Integer.parseInt(split[2]);
            int health = split[3].equals("null") ? 250 : Integer.parseInt(split[3]);
            int armor = split[4].equals("null") ? 10 : Integer.parseInt(split[4]);

            TreeMap<String, List<Integer>> namesAndPoints = new TreeMap<>();
            List<Integer> points = new ArrayList<>();

            listAdder(points, damage, health, armor);

            namesAndPoints.put(name, points);

            if (!map.containsKey(type)) {
                map.put(type, namesAndPoints);
            } else {
                map.get(type).remove(name);
                map.get(type).put(name, points);
            }

        }
        for (Map.Entry<String, TreeMap<String, List<Integer>>> entry : map.entrySet()) {
            List<Double> result = returnListOfAvr(entry);
            System.out.printf("%n%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), result.get(0), result.get(1), result.get(2));

            for (Map.Entry<String, List<Integer>> value : entry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", value.getKey()
                        , value.getValue().get(0)
                        , value.getValue().get(1)
                        , value.getValue().get(2));
            }
        }
    }

    private static List<Double> returnListOfAvr(Map.Entry<String, TreeMap<String, List<Integer>>> entry) {
        double avrDamage = 0;
        double avrHealth = 0;
        double avrArmor = 0;
        for (List<Integer> element : entry.getValue().values()) {
            avrDamage += element.get(0);
            avrHealth += element.get(1);
            avrArmor += element.get(2);
        }
        avrDamage /= entry.getValue().size();
        avrHealth /= entry.getValue().size();
        avrArmor /= entry.getValue().size();
        List<Double> result = new ArrayList<>();

        result.add(avrDamage);
        result.add(avrHealth);
        result.add(avrArmor);
        return result;
    }

    public static void listAdder(List<Integer> list, int d, int h, int a) {
        int[] points = {d, h, a};
        for (int element : points) {
            list.add(element);
        }
    }
}
