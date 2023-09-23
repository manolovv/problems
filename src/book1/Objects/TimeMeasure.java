package book1.Objects;

import java.util.Scanner;

public class TimeMeasure {
    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        System.out.println(time / 1000 + " Time from 1970 in seconds");
        System.out.println(time / 10000 + " Time from 1970 in minutes");
    }
}
