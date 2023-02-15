package pl.dolega;

import pl.dolega.task.DistinctElements;
import pl.dolega.task.Pairs;

public class App {

    public static void main( String[] args ) {

        DistinctElements distinctElements = new DistinctElements();
        Pairs pairs = new Pairs();

        distinctElements.run();
        pairs.run();


    }

}
