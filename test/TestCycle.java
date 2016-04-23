package test;

import graph.Cycle;
import graph.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Silocean on 2016-04-21.
 */
public class TestCycle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Graph/G.txt"));
        Graph graph = new Graph(br);
        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.hasCycle());
    }
}
