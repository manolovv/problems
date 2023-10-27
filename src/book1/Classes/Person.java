package book1.Classes;

import java.util.*;
import java.util.stream.Collectors;

public class Person {

    /*Create Person class with two fields String name and int age, write a program that reads from the console N lines
    of personal information and then prints all people whose age is more than 30 years, sorted in alphabetical order.
    Note: you can use stream() to filter people.*/

    public String name;
    public int age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Integer> persons = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split("\\s+");
            String name = split[0];
            int ages = Integer.parseInt(split[1]);
            persons.put(name, ages);
        }
        List<Map.Entry<String, Integer>> collectPerson = persons.entrySet().stream()
                .filter(e -> e.getValue() > 30)
                .toList();

        for (Map.Entry<String, Integer> person : collectPerson) {
            System.out.println(person.getKey() + " - " + person.getValue());
        }
    }
}
//For Example:
/*input:
        5
        Nikolai 33
        Yordan 88
        Tosho 22
        Lyubo 44
        Stanislav 11
output
        Lyubo - 44
        Nikolai - 33
        Yordan – 88*/
