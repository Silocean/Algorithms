package test;

import bag.Bag;
import digraph.Digraph;
import digraph.DirectedDFS;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Silocean on 2016-04-24.
 */
public class TestDirectedDFS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/test/DG.txt"));
        Digraph digraph = new Digraph(br);
        Bag<Integer> sources = new Bag<>();
        sources.add(2);
        DirectedDFS directedDFS = new DirectedDFS(digraph, sources);
        for (int v = 0; v < digraph.V(); v++) {
            if (directedDFS.marked(v)) {
                System.out.print(v + " ");
            }
        }
    }
}
