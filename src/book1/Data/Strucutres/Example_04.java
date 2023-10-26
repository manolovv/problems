package book1.Data.Strucutres;

import java.util.*;
import java.util.stream.Collectors;

public class Example_04 {

    /*You are given a sequence of people and for every person what cards he draws from the deck. The input will be separate lines in the format:
    {personName}: {PT, PT, PT,… PT}
    Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type.
    The input ends when a "JOKER" is drawn. The name can contain any ASCII symbol except ':'.
    The input will always be valid and in the format described, there is no need to check it.
    A single person cannot have more than one card with the same power and type, if he draws such a card he discards it.
    The people are playing with multiple decks. Each card has a value that is calculated by the power multiplied by the type.
    Powers 2 to 10 have the same value and J to A are 11 to 14. Types are mapped to multipliers the following way (S -> 4, H-> 3, D -> 2, C -> 1).
    Finally print out the total value each player has in his hand in the format: {personName}: {value}*/

    public static <Map> void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> map = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] token = input.split(": ");
            String name = token[0];

            List<String> list = List.of(token[1].split(", "));

            map.putIfAbsent(name, new HashSet<>());
            map.get(name).addAll(list);

            input = scanner.nextLine();
        }

        for (String player : map.keySet()) {
            int sum = 0;

            for (String cards : map.get(player)) {
                int result = 0;

                switch (cards.substring(0, cards.length() - 1)) {

                    case "2" -> {
                        result += 2;
                    }
                    case "3" -> {
                        result += 3;
                    }
                    case "4" -> {
                        result += 4;
                    }
                    case "5" -> {
                        result += 5;
                    }
                    case "6" -> {
                        result += 6;
                    }
                    case "7" -> {
                        result += 7;
                    }
                    case "8" -> {
                        result += 8;
                    }
                    case "9" -> {
                        result += 9;
                    }
                    case "10" -> {
                        result += 10;
                    }
                    case "J" -> {
                        result += 11;
                    }
                    case "Q" -> {
                        result += 12;
                    }
                    case "K" -> {
                        result += 13;
                    }
                    case "A" -> {
                        result += 14;
                    }
                    default ->
                            throw new IllegalStateException("Unexpected value: " +
                                    cards.substring(0, cards.length() - 1));
                }

                switch (cards.substring(cards.length() - 1)) {

                    case "S" -> {
                        result *= 4;
                    }
                    case "H" -> {
                        result *= 3;
                    }
                    case "D" -> {
                        result *= 2;
                    }
                    case "C" -> {
                        result *= 1;
                    }
                    default ->
                            throw new IllegalStateException("Unexpected value: " +
                                    cards.substring(cards.length() - 1));
                }
                sum += result;
            }
            System.out.println(player + ": " + sum);
        }
    }
}
