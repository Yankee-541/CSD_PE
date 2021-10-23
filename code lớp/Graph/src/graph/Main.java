package graph;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MyGraph my = new MyGraph();
        my.display();
        my.BreadthFirst(10);
//        my.depthFirst(10);
//        System.out.println("\b\b\b");
    }
}
