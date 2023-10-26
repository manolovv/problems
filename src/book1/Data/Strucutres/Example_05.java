package book1.Data.Strucutres;

import java.util.*;

public class Example_05 {

    /*Your task is to parse the IP and the username from the input and for every user, you have to display every IP
    from which the corresponding user has sent a message and the count of the messages sent with the corresponding IP.
    In the output, the usernames must be sorted alphabetically while their IP addresses should be displayed in the order
    of their first appearance. The output should be in the following format:
    username:
    IP => count, IP => count.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[2];
            String ip = tokens[0];

            map.putIfAbsent(name, new LinkedHashMap<>());

            LinkedHashMap<String, Integer> ipMap = map.get(name);
            ipMap.putIfAbsent(ip, 0);
            ipMap.put(ip, ipMap.get(ip) + 1);

            input = scanner.nextLine();
        }

        map.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ": ");

                    Map<String, Integer> valuesOfMap = e.getValue();

                    for (Map.Entry<String, Integer> entry : valuesOfMap.entrySet()) {
                        System.out.println(entry.getKey() + " => " + entry.getValue());
                    }

                });

        //Examples:

        /*IP=192.23.30.40 message='Hello&derps.' user=destroyer
        IP=192.23.30.41 message='Hello&yall.' user=destroyer
        IP=192.23.30.40 message='Hello&hi.' user=destroyer
        IP=192.23.30.42 message='Hello&Dudes.' user=destroyer
        end*/

        /*IP=FE80:0000:0000:0000:0202:B3FF:FE1E:8329 message='Hey&son' user=mother
        IP=192.23.33.40 message='Hi&mom!' user=child0
        IP=192.23.30.40 message='Hi&from&me&too' user=child1
        IP=192.23.30.42 message='spam' user=destroyer
        IP=192.23.30.42 message='spam' user=destroyer
        IP=192.23.50.40 message='' user=yetAnotherUsername
        IP=192.23.50.40 message='comment' user=yetAnotherUsername
        IP=192.23.155.40 message='Hello.' user=unknown
        end*/

        //Output:

        /*destroyer:
        192.23.30.40 => 2
        192.23.30.41 => 1
        192.23.30.42 => 1*/

        /*child0:
        192.23.33.40 => 1
        child1:
        192.23.30.40 => 1
        destroyer:
        192.23.30.42 => 2
        mother:
        FE80:0000:0000:0000:0202:B3FF:FE1E:8329 => 1
        unknown:
        192.23.155.40 => 1
        yetAnotherUsername:
        192.23.50.40 => 2*/
    }
}
