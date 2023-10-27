package book1.Data.Strucutres;

import java.util.*;

public class Example_06 {

    /*So many people! It’s hard to count them all. But that’s your job as a statistician.
    You get raw data for a given city and you need to aggregate it.
    On each input line you’ll be given data in format: "city|country|population".
    There will be no redundant whitespaces anywhere in the input. Aggregate the data by country
    and by city and print it on the console. For each country, print its total population and on separate
    lines the data for each of its cities. Countries should be ordered by their total population in descending order
    and within each country, the cities should be ordered by the same criterion. If two countries/cities have the same population,
    keep them in the order in which they were entered. Check out the examples; follow the output format strictly!*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] split = input.split("[|]");
            String country = split[1];
            String city = split[0];
            int population = Integer.parseInt(split[2]);

            map.putIfAbsent(country, new TreeMap<>());

            Map<String, Integer> cityMap = map.get(country);
            cityMap.putIfAbsent(city, 0);
            cityMap.put(city, cityMap.get(city) + population);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            Map<String, Integer> cities = entry.getValue();
            Integer reduce = cities.values().stream().reduce(0, Integer::sum);

            System.out.println(entry.getKey() + " (total population: " + reduce + ")");

            for (Map.Entry<String, Integer> cEntry : cities.entrySet()) {
                System.out.println("=>" + cEntry.getKey() + ": " + cEntry.getValue());
            }
        }
    }
}
//Example:
/*
Input:
Sofia|Bulgaria|1
Veliko Tarnovo|Bulgaria|2
London|UK|4
Rome|Italy|3
report
Output:
UK (total population: 4)
=>London: 4
Bulgaria (total population: 3)
=>Veliko Tarnovo: 2
=>Sofia: 1
Italy (total population: 3)
=>Rome: 3
*/

