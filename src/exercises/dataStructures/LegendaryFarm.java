package exercises.dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarm {

    /*Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as
    2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race.
    At that point, print the corresponding legendary obtained.
          -  Shadowmourne – requires 250 Shards;
          -  Valanyr – requires 250 Fragments;
          -  Dragonwrath – requires 250 Motes;
    Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        String item = "";
        int quantity = 0;
        boolean bol = true;

        while (bol) {
            String[] input = scanner.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < input.length; i++) {

                if (i % 2 != 0) {
                    item = input[i];
                    quantity = Integer.parseInt(input[i - 1]);
                } else {
                    continue;
                }

                map.putIfAbsent(item, 0);
                map.put(item, map.get(item) + quantity);

                switch (item) {
                    case "shards" -> {
                        if (map.get(item) >= 250) {
                            map.put(item, map.get(item) - 250);
                            System.out.println("Shadowmourne obtained !");
                            map.forEach((k, v) -> System.out.println(k + ": " + v));
                            bol = false;
                        }
                    }
                    case "fragments" -> {
                        if (map.get(item) >= 250) {
                            map.put(item, map.get(item) - 250);
                            System.out.println("Valanyr obtained !");
                            map.forEach((k, v) -> System.out.println(k + ": " + v));
                            bol = false;
                        }
                    }
                    case "motes" -> {
                        if (map.get(item) >= 250) {
                            map.put(item, map.get(item) - 250);
                            System.out.println("Dragonwrath  obtained !");
                            map.forEach((k, v) -> System.out.println(k + ": " + v));
                            bol = false;
                        }
                    }
                }
            }
        }
    }
}
