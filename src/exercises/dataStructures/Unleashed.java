package exercises.dataStructures;

import java.util.*;

public class Unleashed {

    /*On each input line you’ll be given data in format: "singer @venue ticketsPrice ticketsCount". There will be
    no redundant whitespaces anywhere in the input. Aggregate the data by venue and by singer. For each venue, print
    the singer and the total amount of money his/her concerts have made on a separate line. Venues and singers should
    be kept in the same order they were entered.
    If two singers have made the same amount of money, keep them in the order in which they were entered.
    Keep in mind that if a line is in incorrect format, it should be skipped and its data should not be added to the
    output. Each of the four tokens must be separated by a space, everything else is invalid. The venue should be
    denoted with @ in front of it, such as @Sunny Beach*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String singerName;
            String venueName;
            String tickedPrice;
            String tickedCount;
            int sum = 0;

            String[] splitByMA = input.split("@");
            String[] firstSplit = splitByMA[0].split("\\s+");
            String[] secondSplit = splitByMA[1].split("\\s+");

            if (firstSplit.length == 2) {
                singerName = firstSplit[0] + " " + firstSplit[1];
            } else {
                singerName = firstSplit[0];
            }

            if (secondSplit.length == 3) {
                    venueName = secondSplit[0];
                    tickedPrice = secondSplit[1];
                    tickedCount = secondSplit[2];
                    sum = Integer.parseInt(tickedPrice) * Integer.parseInt(tickedCount);
            } else if (secondSplit.length == 4) {
                venueName = secondSplit[0] + " " + secondSplit[1];
                tickedPrice = secondSplit[2];
                tickedCount = secondSplit[3];
                sum = Integer.parseInt(tickedPrice) * Integer.parseInt(tickedCount);
            } else {
                continue;
            }

            Map<String, Integer> secondMap = new LinkedHashMap<>();

            secondMap.put(singerName, sum);

            if (!map.containsKey(venueName)) {
                map.put(venueName, secondMap);
            } else {
                if (!map.get(venueName).containsKey(singerName)) {
                    map.get(venueName).put(singerName, sum);
                } else {
                    int currentSum = map.get(venueName).get(singerName);
                    sum += currentSum;
                    map.get(venueName).put(singerName, sum);
                }
            }
        }
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey());

            for (Map.Entry<String, Integer> secondEntry : entry.getValue().entrySet()) {
                System.out.printf("#  %s -> %d%n", secondEntry.getKey(), secondEntry.getValue());
            }
        }
    }
}
