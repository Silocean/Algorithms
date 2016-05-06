package test;

import shortestPath.EdgeWeightedDigraph;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Silocean on 2016-05-06.
 */
public class TestEdgeWeightedDigraph {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/test/EWD.txt"));
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(br);
        System.out.println(G.toString());
    }

}
