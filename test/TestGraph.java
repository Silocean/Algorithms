package test;

import graph.Graph;

/**
 * Created by Silocean on 2016-04-20.
 */
public class TestGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        System.out.println(graph);
        //System.out.println(graph.maxDegree());
    }
}
