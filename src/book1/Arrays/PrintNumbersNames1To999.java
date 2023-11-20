package book1.Arrays;

import java.util.Scanner;

public class PrintNumbersNames1To999 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter num: ");
        int value = input.nextInt();

        String one = "Едно";
        String two = "Две";
        String three = "Три";
        String four = "Четири";
        String five = "Пет";
        String six = "Шест";
        String seven = "Седем";
        String eight = "Осем";
        String nine = "Девет";
        String ten = "Десет";
        String eleven = "Единадесет";
        String twelve = "Дванадисит";
        String thirteen = "Тринадесет";
        String fourteen = "Четиринадесет";
        String fiveteen = "Петнадесет";
        String sixteen = "Шеснадесет";
        String seventeen = "Седемнадесет";
        String eighteen = "Осемнадесет";
        String nineteen = "Деветнадесет";

        String[] numbers = {
                "",
                " Едно",
                " Две",
                " Три",
                " Четири",
                " Пет",
                " Шест",
                " Седем",
                " Осем",
                " Девет"
        };

        String[] tensNames = {
                "",
                " Десет",
                " Двадесет",
                " Тридесет",
                " Четиресет",
                " Петдесет",
                " Шейсет",
                " Седемдесет",
                " Осемдесет",
                " Деветдесет"
        };

        String[] hundredsNames = {
                "",
                "Сто",
                "Двеста",
                "Триста",
                "Четиристотин",
                "Петстотин",
                "Шестстотин",
                "Седемстотин",
                "Осемстотин",
                "Деветстотин",
        };

        if (value > 0 && value <= 19) {
            switch (value) {
                case 1 -> System.out.println(one);
                case 2 -> System.out.println(two);
                case 3 -> System.out.println(three);
                case 4 -> System.out.println(four);
                case 5 -> System.out.println(five);
                case 6 -> System.out.println(six);
                case 7 -> System.out.println(seven);
                case 8 -> System.out.println(eight);
                case 9 -> System.out.println(nine);
                case 10 -> System.out.println(ten);
                case 11 -> System.out.println(eleven);
                case 12 -> System.out.println(twelve);
                case 13 -> System.out.println(thirteen);
                case 14 -> System.out.println(fourteen);
                case 15 -> System.out.println(fiveteen);
                case 16 -> System.out.println(sixteen);
                case 17 -> System.out.println(seventeen);
                case 18 -> System.out.println(eighteen);
                case 19 -> System.out.println(nineteen);
            }
        } else if (value >= 20 && value <= 99) {
            printTwentyToNinetyNine(value, numbers, tensNames);
        } else { // if number is bigger than 99
            int hundred = value / 100; //201 -> 2
            System.out.print(hundredsNames[hundred]);
            if (value % 100 != 0) {
                printTwentyToNinetyNine (value % 100, numbers, tensNames);
            }
        }
    }

    private static void printTwentyToNinetyNine(int value, String[] numbers, String[] tensNames) {
        int tens = value / 10; //21 -> 2
        System.out.print(tensNames[tens]);
        if (value % 10 != 0) {
            System.out.print(" и ");

            int secondNumber = value % 10; //21 -> 1
            System.out.print(numbers[secondNumber]);
        }
    }

    //21 / 10-> 2
    //21 % 10-> 1

    //221 / 100-> 2
    //221 % 100-> 21
}
