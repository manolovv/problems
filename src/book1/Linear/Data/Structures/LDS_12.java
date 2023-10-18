package book1.Linear.Data.Structures;
import java.util.ArrayDeque;
import java.util.Scanner;

public class LDS_12 {
    public static void main(String[] args) {

        /*Each robot has a processing time, the time it needs to process a product.
        When a robot is free it should take a product for processing and log his name, product and processing start time.
        Each robot processes a product coming from the assembly line.
        A product is coming from the line each second (so the first product should appear at [start time + 1 second]).
        If a product passes the line and there is not a free robot to take it, it should be queued at the end of the line again.
        The robots are standing on the line in the order of their appearance.*/


                Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Robot Name and Process Time: ");
        String[] input = scanner.nextLine().split(";");

        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] current = input[i].split("-");
            String name = current[0];
            int time = Integer.parseInt(current[1]);
            robots[i] = name;
            processTime[i] = time;
        }

        System.out.print("Enter start time: ");
        String[] startTime = scanner.nextLine().split(":");
        int hours = Integer.parseInt(startTime[0]);
        int minutes = Integer.parseInt(startTime[1]);
        int seconds = Integer.parseInt(startTime[2]);

        int inSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> queue = new ArrayDeque<>();

        System.out.print("Enter product: ");
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            queue.offer(command);
            System.out.print("Enter product: ");
            command = scanner.nextLine();
        }

        while (!queue.isEmpty()) {
            inSeconds++;

            String product = queue.poll();

            boolean isTrue = false;
            for (int i = 0; i < robots.length; i++) {

                if (workTime[i] == 0 && !isTrue) {
                    workTime[i] = processTime[i];
                    printCurrentTime(robots[i], product, inSeconds);
                    isTrue = true;
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }
            if (!isTrue) {
                queue.offer(product);
            }
        }
    }

    public static void printCurrentTime(String robot, String product, int inSeconds) {
        int s = inSeconds % 60;
        int m = (inSeconds / 60) % 60;
        int h = (inSeconds / (60 * 60)) % 24;

        System.out.println(robot + "-" + product + "-" + String.format(" [%02d:%02d:%02d] ", h, m, s));
    }
}
