package book1.Objects;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

public class GenerateRandomAd {
    private static String[] INCIDENT = {"Вече се чувствам добре", "Успях да се променя", "Той направи чудо",
            "Не мога да повярвам, но вече се чъвствам страходно", "Опитайте и вие. Аз съм много доволна"};
    private static String[] PHRASES = {"Продъкта е отличен", "Това е страхотен продукт", "Постоянно ползвам този продукт" +
            "Това е най добрият продукт от тази категория"};
    private static String[] FIRST_NAME = {"Диана", "Стела", "Елена", "Петя", "Катя"};
    private static String[] LAST_NAME = {"Иванова", "Петрова", "Кирова", "Ванкова", "Миленова"};
    private static String[] CITY = {"София", "Пловдив", "Варна", "Русе", "Бургас"};

    public static String takeRandomElement(String[] arr) {
        int randomIndex = ThreadLocalRandom.current().nextInt(arr.length);
        String randomPhrase = arr[randomIndex];
        return  randomPhrase;
    }

    public static void main(String[] args) {

        System.out.printf("%s, %s! - %n- %s %s, %s !!!", takeRandomElement(INCIDENT), takeRandomElement(PHRASES),
                takeRandomElement(FIRST_NAME),
                takeRandomElement(LAST_NAME), takeRandomElement(CITY));

    }

}
