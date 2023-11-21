package exercises.dataStructures;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

    /*
    You are given an input in the format:
    IP=(IP.Address) message=(A&sample&message) user=(username)
    Your task is to parse the IP and the username from the input and for every user, you have to display every IP
    from which the corresponding user has sent a message and the count of the messages sent with the corresponding IP.
    In the output, the usernames must be sorted alphabetically while their IP addresses should be displayed in the
    order of their first appearance. The output should be in the following format:
    username:
    IP => count, IP => count.
    For example, given the following input - IP=192.23.30.40 message='Hello&derps.' user=destroyer, you have to get
    the username destroyer and the IP 192.23.30.40 and display it in the following format:
    destroyer:
            192.23.30.40 => 1.
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();

        String input;
        while (!"end".equals(input = scanner.nextLine())) {
            String[] split = input.split("\\s+");

            int index = split[2].indexOf("=");
            String name = split[2].substring(index + 1);

            int secIndex = split[0].indexOf("=");
            String ip = split[0].substring(secIndex + 1);

            map.putIfAbsent(name, new LinkedHashMap<>());

            LinkedHashMap<String, Integer> secMap = map.get(name);

            secMap.putIfAbsent(ip, 0);
            secMap.put(ip, secMap.get(ip) + 1);

        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": ");

            LinkedHashMap<String, Integer> secEntry = entry.getValue();
            secEntry.forEach((key, value) -> {
                System.out.print(key + " => " + value + "\n");
            });
        }
    }
}
