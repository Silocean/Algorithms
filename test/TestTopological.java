package test;

import digraph.Digraph;
import digraph.Topological;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Silocean on 2016-04-25.
 */
public class TestTopological {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/test/DG2.txt"));
        Digraph digraph = new Digraph(br);
        Topological topological = new Topological(digraph);
        if (topological.isDAG()) {
            for (int v : topological.order()) {
                System.out.print(v + " ");
            }
        } else {
            System.out.println("Digraph is not a DAG!");
        }
    }
}
