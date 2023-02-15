package pl.dolega;

import pl.dolega.task.DistinctElements;
import pl.dolega.task.GraphCounter;
import pl.dolega.task.Pairs;

import java.util.Scanner;

public class App {

    public static void main( String[] args ) {

        DistinctElements distinctElements = new DistinctElements();
        Pairs pairs = new Pairs();
        GraphCounter graphCounter = new GraphCounter();

        distinctElements.run();
        pairs.run();
        graphCounter.run();


    }

}
