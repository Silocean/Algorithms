package test;

import graph.Graph;
import graph.TwoColor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Silocean on 2016-04-21.
 */
public class TestTwoColor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/test/G.txt"));
        Graph graph = new Graph(br);
        TwoColor twoColor = new TwoColor(graph);
        System.out.println(twoColor.isBipartite());
    }
}
