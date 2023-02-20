package pl.dolega.task;

import java.util.*;

public class GraphCounter {

    private List<List<Integer>> pairs = new LinkedList<>();
    private int graphCounter;

    public void run() {
        graphCounter = 0;
        String input = getInput();
        int numberOfPairs = getNumberOfPairs(input);
        if (numberOfPairs == 0) {
            graphCounter = 0;
        } else if (getVertices(input).stream().distinct().toList().size() == numberOfPairs * 2) {
            graphCounter = numberOfPairs;
        } else {
            pairs = getPairs(getVertices(input));
            countGraphs();
        }
        System.out.println(graphCounter);
    }

    private void countGraphs() {
        do {
            graphCounter++;
            pairs = getRemainingPairs(pairs);
        } while (pairs.size() != 0);
    }

    private List<List<Integer>> getRemainingPairs(List<List<Integer>> pairs) {

        List<List<Integer>> remainingPairs;

        Set<Integer> graph = new HashSet<>();
        graph.add(pairs.get(0).get(0));
        graph.add(pairs.get(0).get(1));
        pairs.remove(0);

        int j = pairs.size();

        int matchingPairs;

        do {
            matchingPairs = 0;
            for (int i = 0; i < j; i++) {
                int a = pairs.get(i).get(0);
                int b = pairs.get(i).get(1);
                if (graph.contains(a) || graph.contains(b)) {
                    matchingPairs++;
                    graph.add(a);
                    graph.add(b);
                    pairs.remove(i);
                    i--;
                    j--;
                }
            }
            remainingPairs = pairs;
        } while (matchingPairs != 0);
        return remainingPairs;
    }

    private List<List<Integer>> getPairs(List<Integer> vertices) {
        Set<List<Integer>> pairsSet = new HashSet<>();
        List<List<Integer>> pairsList = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i = i + 2) {
            pairsSet.add(Arrays.asList(vertices.get(i), vertices.get(i + 1)).stream().sorted().toList());
        }
        for (int i = 0; i < pairsSet.size(); i++) {
            pairsList.add(pairsSet.stream().toList().get(i));
        }
        return pairsList;
    }

    private List<Integer> getVertices(String input) {
        List<Integer> vertices = Arrays.stream(input.split(" ")).map(Integer::parseInt).toList();
        return vertices.subList(1, vertices.size());
    }

    private int getNumberOfPairs(String input) {
        return Integer.parseInt(String.valueOf(input.charAt(0)));
    }

    private String getInput() {
        System.out.println("Enter integers:");
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        do {
            line = scanner.nextLine();
            stringBuilder.append(line + " ");
        } while (!line.equals(""));
        return stringBuilder.toString();
    }
}
