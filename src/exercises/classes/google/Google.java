package exercises.classes.google;

import java.util.*;

public class Google {

    /*Google is always watching you, so it should come as no surprise that they know everything about you
    (even your pokemon collection), since you’re a really good at writing classes Google asked you
    to design a Class that can hold all the information they need for people.From the console you will receive
    an unkown amount of lines until the command "End" is red, on each of those lines there will be information
    about a person in one of the following formats:
            "<Name> company <companyName> <department> <salary>"
            "<Name> pokemon <pokemonName> <pokemonType>"
            "<Name> parents <parentName> <parentBirthday>"
            "<Name> children <childName> <childBirthday>"
            "<Name> car <carModel> <carSpeed>"
    You should structure all information about a person in a class with nested subclasses.
    People names are unique - there won't be 2 people with the same name, a person can also have only 1 company
    and car, but can have multiple parents, children and pokemons. After the command "End" is received on the
    next line you will receive a single name, you should print all information about that person.
    Note that information can change during the input, for instance if we receive multiple lines which specify
    a person company, only the last one should be the one remembered. The salary must be formated to two decimal
    places after the seperator. Note: print the information in format:
    {personName}
    Company:
    {companyName} {companyDepartment} {salary}
	...
    Children:
    {childName} {childBirthday}
    {childName} {childBirthday}
    */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, User> users = new LinkedHashMap<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] split = input.split("\\s+");
            String userName = split[0];
            String choice = split[1];

            users.putIfAbsent(userName, new User());

            switch (choice) {
                case "company" -> setCompany(split, users, userName);
                case "pokemon" -> addPokemon(split, users, userName);
                case "parents" -> addParent(split, users, userName);
                case "children" -> addChildren(split, users, userName);
                case "car" -> setCar(split, users, userName);
            }
        }
        String keyName = scanner.nextLine();
        System.out.println(keyName + "\n" + users.get(keyName).toString());
    }

    private static void setCar(String[] split, LinkedHashMap<String, User> users, String userName) {
        String carModel = split[2];
        String carSpeed = split[3];

        Car car = new Car(carModel, carSpeed);
        users.get(userName).setCar(car);
    }

    private static void addChildren(String[] split, LinkedHashMap<String, User> users, String userName) {
        String childrenName = split[2];
        String childrenBDay = split[3];

        Children children = new Children(childrenName, childrenBDay);
        users.get(userName).addChildren(children);
    }

    private static void addParent(String[] split, LinkedHashMap<String, User> users, String userName) {
        String parentName = split[2];
        String parentBDay = split[3];

        Parent parent = new Parent(parentName, parentBDay);
        users.get(userName).addParent(parent);
    }

    private static void addPokemon(String[] split, LinkedHashMap<String, User> users, String userName) {
        String pokemonName = split[2];
        String pokemonType = split[3];

        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
        users.get(userName).addPokemon(pokemon);
    }

    private static void setCompany(String[] split, LinkedHashMap<String, User> users, String userName) {
        String companyName = split[2];
        String department = split[3];
        String salary = split[4];

        Company company = new Company(companyName, department, salary);
        users.get(userName).setCompany(company);
    }
}

class User {
    private Company company;
    private Car car;
    private final List<Parent> parents;
    private final List<Children> childrens;
    private final List<Pokemon> pokemons;

    User() {
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addParent(Parent parent) {
        parents.add(parent);
    }
    public void addChildren(Children children) {
        childrens.add(children);
    }
    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Company: \n");
        if (company != null) {
            sb.append(this.company);
        }

        sb.append("Car: \n");
        if (car != null) {
            sb.append(this.car).append(System.lineSeparator());
        }

        sb.append("Parents: \n");
        parents.forEach(e -> sb.append(e).append(" ").append(System.lineSeparator()));
        sb.append("Children: \n");
        childrens.forEach(e -> sb.append(e).append(" ").append(System.lineSeparator()));
        sb.append("Pokemon: \n");
        pokemons.forEach((e -> sb.append(e).append(" ").append(System.lineSeparator())));

        return sb.toString();
    }
}
class Company {
    private final String name;
    private final String department;
    private final String salary;

    Company(String name, String department, String salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ");
        sb.append(this.department).append(" ");
        double salary = Double.parseDouble(this.salary);
        sb.append(String.format("%.2f", salary)).append("\n");

        return sb.toString();
    }
}

class Car {
    private final String model;
    private final String speed;

    Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    public String toString() {
        return this.model + " " +
                this.speed;
    }
}

class Parent {
    private final String name;
    private final String bDay;

    Parent(String name, String bDay) {
        this.name = name;
        this.bDay = bDay;
    }
    public String toString() {

        return this.name + " " +
                this.bDay + " ";
    }
}

class Children {
    private final String name;
    private final String bDay;

    Children(String name, String bDay) {
        this.name = name;
        this.bDay = bDay;
    }
    public String toString() {

        return this.name + " " +
                this.bDay + " ";
    }
}

class Pokemon {
    private final String name;
    private final String type;

    Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public String toString() {

        return this.name + " " +
                this.type + " ";
    }
}
