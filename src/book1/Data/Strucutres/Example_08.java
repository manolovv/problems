package book1.Data.Strucutres;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Example_08 {

    /*You’ve beaten all the content and the last thing left to accomplish is own a legendary item.
    However, it’s a tedious process and requires quite a bit of farming.
    Anyway, you are not too pretentious – any legendary will do. The possible items are:
    Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as
    2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race.
    At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, motes,
    ordered by quantity in descending order, each on a new line. Finally, print the collected junk items, in alphabetical order.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> key = new TreeMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        key.put("shards", 0);
        key.put("fragments", 0);
        key.put("motes", 0);


        String[] split = scanner.nextLine().toLowerCase().split("\\s+");

        boolean bol = false;
        int lastQuantity = 0;
        String lastElement = "";

        for (int i = 1; i < split.length; i += 2) {
            String material = split[i];
            int quantity = Integer.parseInt(split[i - 1]);


            if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                key.computeIfPresent(material, (k, v) -> v + quantity);
                lastQuantity = key.get(material);

                if (lastQuantity >= 250) {
                    lastQuantity -= 250;
                    int finalLastQuantity = lastQuantity;
                    key.computeIfPresent(material, (k, v) -> v - finalLastQuantity);
                    junk.computeIfPresent(material, (k, v) -> v + finalLastQuantity);
                    lastElement = material;
                    bol = true;
                } else {
                    junk.put(material, 0);
                    junk.computeIfPresent(material, (k, v) -> v + quantity);
                }
            } else {
                junk.put(material, 0);
                junk.computeIfPresent(material, (k, v) -> v + quantity);
            }
        }
        if (bol) {
            switch (lastElement) {
                case "shards" -> {
                    System.out.println("Shadowmourne obtained!");
                }
                case "fragments" -> {
                    System.out.println("Valanyr obtained!");
                }
                case "motes" -> {
                    System.out.println("Dragonwrath obtained!");
                }
            }
        }
        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
