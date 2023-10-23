package book1.Data.Strucutres;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Example_01 {
    public static void main(String[] args) {

        /*You are given a sequence of strings, each on a new line. Every odd line on the console is representing
        a resource (e.g. Gold, Silver, Copper, and so on) , and every even – quantity. Your task is to collect the
        resources and print them each on a new line. Print the resources and their quantities in format:
        {resource} –> {quantity}*/

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            map.put(input, quantity);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " -> " + value);
        }
    }
}
