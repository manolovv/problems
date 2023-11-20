package exercises.dataStructures;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {

    /*You are given a sequence of access logs in format <IP> <user> <duration>. For example:
            192.168.0.11 peter 33
            10.10.17.33 alex 12
            10.10.17.35 peter 30
            10.10.17.34 peter 120
            10.10.17.34 peter 120
            212.50.118.81 alex 46
            212.50.118.81 alex 4
    Write a program to aggregate the logs data and print for each user the total duration of his sessions and a
    list of unique IP addresses in format "<user>: <duration> [<IP1>, <IP2>, …]". Order the users alphabetically.
    Order the IPs alphabetically. In our example, the output should be the following:

    alex: 62 [10.10.17.33, 212.50.118.81]
    peter: 303 [10.10.17.34, 10.10.17.35, 192.168.0.11]
    */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String name = input[1];
            int duration = Integer.parseInt(input[2]);

            map.putIfAbsent(name, new TreeMap<>());

            TreeMap<String, Integer> secMap = map.get(name);

            secMap.putIfAbsent(ip, 0);
            secMap.put(ip, secMap.get(ip) + duration);
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : map.entrySet()) {

            int reduce = entry.getValue().values().stream().reduce(0, Integer::sum);
            System.out.print(entry.getKey() + ": " + reduce);

            TreeMap<String, Integer> sec = entry.getValue();
            sec.forEach((key, value) -> {
                System.out.print(" " + key);
            });
            System.out.println();
        }
    }
}
