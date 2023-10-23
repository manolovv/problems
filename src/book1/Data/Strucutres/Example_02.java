package book1.Data.Strucutres;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Example_02 {
    public static void main(String[] args) {

        /*You are given a sequence of strings, each on a new line, until you receive "stop" command.
            First string is a name of a person. On the second line you receive his email.
        Your task is to collect their names and emails, and remove emails whose domain ends with
        "us", "uk" or “com” (case insensitive). Print:  {name} – > {email}*/

        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            int isPositiveNumber = email.indexOf("bg");

            if (isPositiveNumber > 0) {
                map.put(name, email);
            }
            name = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " -> " + value);
        }
    }
}
