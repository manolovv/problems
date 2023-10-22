package book1.Linear.Data.Structures.Sets.Maps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex_01 {
    public static void main(String[] args) {

      /*  Write a simple program that reads from the console a sequence of usernames and keeps a collection with only
        the unique ones. Print the collection on the console in order of insertion.*/

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> names = new LinkedHashSet<>();

        while (n-- > 0) {

            String input = scanner.nextLine();
            names.add(input);

        }

        String output = names.stream().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(output);

    }
}
