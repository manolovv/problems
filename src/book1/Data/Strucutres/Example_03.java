package book1.Data.Strucutres;

import java.util.*;

public class Example_03 {
    public static void main(String[] args) {

        /*Вход: 2, 3, 1, 2, 5, 1, 4, 4, 4, 1, 8
        Напиши задача, която изкарва всяко уникално число от поредицата и колко често се среща в самата поредица*/

        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(", ");

        Map<Integer, Integer> map = new HashMap<>();

        for (String s : split) {
            int element = Integer.parseInt(s);

            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                map.computeIfPresent(element, (key, value) -> value + 1);
            }
        }
        map.forEach((key, value) -> System.out.println(key + " -> " + value + " times."));
    }
}