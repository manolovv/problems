package book1.Linear.Data.Structures.Sets.Maps;

import java.util.*;

public class Ex_02 {
    public static void main(String[] args) {

        /*On the first line you are given the length of two sets n and m. On the next n + m lines there are n numbers
        that are in the first set and m numbers that are in the second one. Find all non-repeating element that appears
        in both of them, and print them in same order at the console:
        Set with length n = 4: {1, 3, 5, 7}
        Set with length m = 3: {3, 4, 5}
        Set that contains all repeating elements -> {3, 5}*/

        Scanner scanner = new Scanner(System.in);
        String[] length = scanner.nextLine().split("\\s+");
        int first = Integer.parseInt(length[0]);
        int second = Integer.parseInt(length[1]);
        int total = first + second;

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        while (total-- > 0) {
            int input = Integer.parseInt(scanner.nextLine());
            boolean contains = set.contains(input);

            if (!contains) {
                set.add(input);
            } else {
                list.add(input);
            }
        }
        for (int k : list) {
            System.out.print(k + " ");
        }
    }
}
