package book1.Data.Strucutres;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Example_07 {

    /*You are given a sequence of access logs in format <IP> <user> <duration>.
    Write a program to aggregate the logs data and print for each user the total duration of his sessions and a list of
    unique IP addresses in format "<user>: <duration> [<IP1>, <IP2>, …]". Order the users alphabetically. Order the IPs
    alphabetically. In our example, the output should be the following:
    - alex: 62 [10.10.17.33, 212.50.118.81]
    - peter: 303 [10.10.17.34, 10.10.17.35, 192.168.0.11]*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] split = input.split("\\s+");
            String name = split[1];
            int duration = Integer.parseInt(split[2]);
            String ip = split[0];

            map.putIfAbsent(name, new TreeMap<String, Integer>());

            TreeMap<String, Integer> secondMap = map.get(name);
            secondMap.putIfAbsent(ip, 0);
            secondMap.put(ip, secondMap.get(ip) + duration);
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : map.entrySet()) {
            TreeMap<String, Integer> duration = map.get(entry.getKey());
            Integer reduce = duration.values().stream().reduce(0, Integer::sum);
            System.out.print(entry.getKey() + ": " + reduce);

            for (Map.Entry<String, Integer> secondEntry : duration.entrySet()) {
                System.out.print(" [" + secondEntry.getKey() + "] ");
            }
            System.out.println();
        }
    }
}
/*
Example-->
Input:
        7
        192.168.0.11 peter 33
        10.10.17.33 alex 12
        10.10.17.35 peter 30
        10.10.17.34 peter 120
        10.10.17.34 peter 120
        212.50.118.81 alex 46
        212.50.118.81 alex 4
Output:
        alex: 62 [10.10.17.33] [212.50.118.81]
        peter: 303 [10.10.17.34] [10.10.17.35] [192.168.0.11]*/
