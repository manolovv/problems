package exercises.dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {

    /*On each input line you’ll be given data in format: "city|country|population". There will be no redundant
    whitespaces anywhere in the input. Aggregate the data by country and by city and print it on the console.
    For each country, print its total population and on separate lines the data for each of its cities.*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> map = new HashMap<>();

        String input;
        while (!"report".equals(input = scanner.nextLine())) {
            String[] split = input.split("\\|");
            String country = split[1];
            String city = split[0];
            int population = Integer.parseInt(split[2]);

            map.putIfAbsent(country, new HashMap<>());

            Map<String, Integer> secondMap = map.get(country);
            secondMap.put(city, population);
        }

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            int reduce = entry.getValue().values().stream().reduce(0, Integer::sum);
            System.out.println(entry.getKey() + " (total population: " + reduce + ")");

            Map<String, Integer> secMap = entry.getValue();
            secMap.forEach((key, value) -> {
                System.out.println("=>" + key + " (total population: " + value + ")");
            });
            System.out.println();
        }
    }
}
