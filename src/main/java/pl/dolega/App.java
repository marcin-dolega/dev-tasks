package pl.dolega;

import pl.dolega.task.DistinctElements;
import pl.dolega.task.GraphCounter;
import pl.dolega.task.Pairs;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DistinctElements distinctElements = new DistinctElements();
        Pairs pairs = new Pairs();
        GraphCounter graphCounter = new GraphCounter();

        boolean exit = false;

        do {
            System.out.println(
                    "1. task-1\n" +
                            "2. task-2\n" +
                            "3. task-3\n" +
                            "0. quit\n" +
                            "Choose task:"
            );

            String option;

            while (true) {
                option = scanner.nextLine();
                if (option.matches("[0-3]")) {
                    break;
                } else {
                    System.out.println("Invalid input, try again:");
                }
            }

            switch (option) {
                case "1":
                    distinctElements.run();
                    System.out.println();
                    break;
                case "2":
                    pairs.run();
                    System.out.println();
                    break;
                case "3":
                    graphCounter.run();
                    System.out.println();
                    break;
                case "0":
                    exit = true;
                    break;
            }
        } while (!exit);

        scanner.close();
    }

}
