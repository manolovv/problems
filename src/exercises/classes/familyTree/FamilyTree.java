package exercises.classes.familyTree;

import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree {

    /*You want to build your family tree, so you went to ask your grandmother, sadly your grandmother keeps remembering
    information about your predecessors in pieces, so it falls to you to group the information and build the family tree.
    On the first line of the input you will receive either a name or a birthdate in the format "<FirstName> <LastName>"
    or "day/month/year" - your task is to find information about the person in the family tree. On the next lines until
    the command "End" is received you will receive information about your predecessors
    that you will use it to build the family tree.
    The information will be in one of the following formats:
            "FirstName LastName - FirstName LastName"
            "FirstName LastName - day/month/year"
            "day/month/year - FirstName LastName"
            "day/month/year - day/month/year"
            "FirstName LastName day/month/year"
    The first 4 formats reveal a family tie – the person on the left is parent to the person on the right
    (as you can see the format does not need to contain names, for example the 4th format means the person
    born on the left date is parent to the person born on the right date). The last format ties
    different information together – i.e. the person with that name was born on that date. Names and birthdates are
    unique – there won’t be 2 people with the same name or birthdate, there will always be enough entries to
    construct the family tree (all people names and birthdates are known and they have at least one connection to
    another person in the tree).After the command "End" is received you should print all information about the person
    whose name or birthdate you received on the first line – his name, birthday, parents and children
    (check the examples for the format). The people in the parents and children lists should be ordered by
    their first appearance in the input (regardless if they appeared as a birthdate or a name, for example in the first
    input Stamat is before Penka because he first appeared in the second line, while she appears in the third.).*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String Id = scanner.nextLine();

        List<Person> personList = new ArrayList<>();
        Map<String, String> parAndChiMap = new LinkedHashMap<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {

            if (!input.contains("-")) {
                createPerson(input, personList);

            } else {
                sortTree(input, parAndChiMap);
            }
        }

        Person neededPerson = findPeople(personList, Id);
        for (Map.Entry<String, String> entry : parAndChiMap.entrySet()) {

            if (entry.getKey().equals(neededPerson.getName()) || entry.getKey().equals(neededPerson.getbDay())) {
                setChildren(entry, personList, neededPerson);
            }
            if (entry.getValue().equals(neededPerson.getName()) || entry.getValue().equals(neededPerson.getbDay())) {
                setParent(entry, personList, neededPerson);
            }
        }
        String output = printResult(neededPerson);
        System.out.println(output);
    }

    private static void setParent(Map.Entry<String, String> entry, List<Person> personList, Person neededPerson) {
        Person itsParent = findPeople(personList, entry.getKey());
        neededPerson.setParent(itsParent);
    }

    private static void setChildren(Map.Entry<String, String> entry, List<Person> personList, Person neededPerson) {
        Person itsChild = findPeople(personList, entry.getValue());
        neededPerson.setChildren(itsChild);
    }

    private static void sortTree(String input, Map<String, String> parAndChiMap) {
        String[] split = input.split(" - ");
        String parentId = split[0];
        String childrenId = split[1];

        parAndChiMap.putIfAbsent(parentId, childrenId);
    }

    private static void createPerson(String input, List<Person> personList) {
        String[] split = input.split("\\s+");
        String personId = split[0] + " " + split[1];
        String personBDay = split[2];

        personList.add(new Person(personId, personBDay));
    }

    private static Person findPeople(List<Person> personList, String personId) {
        return personList.stream().filter(person ->
                person.getName().equals(personId) ||
                        person.getbDay().equals(personId)).findFirst().orElseThrow();
    }
    public static String printResult(Person person) {
        return person.toString() + System.lineSeparator() +
                "Parents: " + System.lineSeparator() +
                person.getParent().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())) +
                System.lineSeparator() +
                "Children: " + System.lineSeparator() +
                person.getChildren().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}

class Person {
    private final String name;
    private final String bDay;
    private final List<Person> children;
    private final List<Person> parent;

    public Person(String name, String bDay) {
        this.name = name;
        this.bDay = bDay;
        this.parent = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getbDay() {
        return bDay;
    }

    public void setChildren(Person children) {
        this.children.add(children);
    }

    public void setParent(Person parent) {
        this.parent.add(parent);
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Person> getParent() {
        return parent;
    }
    public String toString() {
        return name + " " + bDay;
    }
}
