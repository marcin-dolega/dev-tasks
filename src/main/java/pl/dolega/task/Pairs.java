package pl.dolega.task;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pairs {

    public void run() {
        getPairs(getInput());
    }

    public String getInput() {
        String input;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integers:");
        while (true) {
            input = scanner.nextLine();
            if (input.matches("[-?0-9 ]+")) {
                break;
            } else {
                System.out.println("Invalid input, try again:");
            }
        }
        scanner.close();
        return input;
    }

    public void getPairs(String input) {
        List<Integer> ints = Arrays.stream(
                        input.split(" "))
                .map(Integer::parseInt)
                .toList();

        ints.stream().sorted().forEach(i -> {
            if ((i < 7) && ints.contains(13 - i)) {
                System.out.println(i + " " + (13 - i));
            }
        });
    }
}
