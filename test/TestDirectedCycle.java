package test;

import digraph.Digraph;
import digraph.DirectedCycle;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Silocean on 2016-04-25.
 */
public class TestDirectedCycle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/test/DG.txt"));
        Digraph digraph = new Digraph(br);
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if (directedCycle.hasCycle()) {
            for (int w : directedCycle.cycle()) {
                System.out.print(w + " ");
            }
        }
    }
}
