package exercises.classes.pokemonTrainer;

import java.util.*;

public class PokemonTrainer {
    /*You wanna be the very best pokemon trainer, like no one ever was, so you set out to catch pokemons.
    Define a class Trainer and a class Pokemon. Trainer has a name, number of badges and a collection of pokemon.
    Pokemon has a name, an element and health, all values are mandatory. Every Trainer starts with 0 badges.
    From the console you will receive an unknown number of lines until you receive the command "Tournament",
    each line will carry information about a pokemon and the trainer who caught it in the format
    "<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>" where TrainerName is the name of the Trainer
    who caught the pokemon, names are unique there cannot be 2 trainers with the same name. After receiving the
    command "Tournament" an unknown number of lines containing one of three elements "Fire", "Water", "Electricity"
    will follow until the command "End" is received. For every command you must check if a trainer has at
        least 1 pokemon with the given element, if he does he receives 1 badge, otherwise all his pokemon lose 10
    health, if a pokemon falls to 0 or less health he dies and must be deleted from the trainer’s collection.
    After the command "End" is received you should print all trainers in the format "<TrainerName> <Badges> <NumberOfPokemon".
    */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> map = new HashMap<>();

        fillPlayersContent(scanner, map);

        calculatePlayersFit(scanner, map);

        printResult(map);
    }

    private static void fillPlayersContent(Scanner scanner, Map<String, Trainer> map) {
        String input;
        while (!"Tournament".equals(input = scanner.nextLine())) {
            String[] split = input.split("\\s+");

            String trainerName = split[0];
            String pokemonElement = split[2];
            int pokemonHealth = Integer.parseInt(split[3]);

            Pokemon pokemon = new Pokemon(pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName);
            map.putIfAbsent(trainerName, trainer);
            map.get(trainerName).addPokemon(pokemon);
        }
    }

    private static void calculatePlayersFit(Scanner scanner, Map<String, Trainer> map) {
        String command;
        while (!"End".equals(command = scanner.nextLine())) {

            for (Map.Entry<String, Trainer> entry : map.entrySet()) {

                int pokemonCount = 0;
                boolean hasNotElement = true;
                for (Pokemon pokemon1 : entry.getValue().getPokemonList()) {
                    pokemonCount++;

                    hasNotElement = setBadge(entry, pokemon1, command, hasNotElement);
                }

                if (hasNotElement) {
                    reductionHealth(entry, pokemonCount);
                }
            }
        }
    }

    private static void printResult(Map<String, Trainer> map) {
        for (Trainer trainer1 : map.values()) {
            System.out.printf("%s %d %d%n", trainer1.getName(), trainer1.getBadges(), trainer1.getPokemonList().size());
        }
    }

    private static void reductionHealth(Map.Entry<String, Trainer> entry, int pokemonCount) {
        for (int i = 0; i < pokemonCount; i++) {

            int health = entry.getValue().getPokemonList().get(i).getHealth();
            health -= 10;
            entry.getValue().getPokemonList().get(i).setHealth(health);

            entry.getValue().getPokemonList().removeIf(e -> e.getHealth() <= 0);
        }
    }

    private static boolean setBadge(Map.Entry<String, Trainer> entry, Pokemon pokemon1, String command, boolean hasNotElement) {
        if (pokemon1.getElement().equals(command)) {

            int badges = entry.getValue().getBadges();
            badges += 1;
            entry.getValue().setBadges(badges);
            hasNotElement = false;
        }
        return hasNotElement;
    }
}

class Trainer {
    private final String name;
    private int badges;
    private final List<Pokemon> pokemonList;

    Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }
}

class Pokemon {
    private final String element;
    private int health;

    Pokemon(String element, int health) {
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
