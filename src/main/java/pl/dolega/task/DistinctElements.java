package pl.dolega.task;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DistinctElements {

    public void run() {
        getResult(getInput());
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
//        scanner.close();
        return input;
    }

    public void getResult(String input) {
        List<Integer> ints = Arrays.stream(input.split(" ")).map(Integer::parseInt).toList();

        ints.stream().distinct().sorted().forEach(i -> System.out.print(i + " "));

        System.out.println(
                "\ncount: " + (long) ints.size() +
                "\ndistinct: " + (long) ints.stream().distinct().toList().size() +
                "\nmin: " + ints.stream().sorted().toList().get(0) +
                "\nmax: " + ints.stream().sorted().toList().get(ints.size() - 1));
    }
}
