package test;

import digraph.BreadthFirstDirectedPaths;
import digraph.DepthFirstDirectedPaths;
import digraph.Digraph;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Silocean on 2016-04-24.
 */
public class TestBreadthFirstDirectedPaths {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/test/DG.txt"));
        Digraph digraph = new Digraph(br);
        int s = 4;
        BreadthFirstDirectedPaths search = new BreadthFirstDirectedPaths(digraph, s);
        if (search.hasPathTo(3)) {
            for (int w : search.pathTo(3)) {
                System.out.print(w + " ");
            }
        }
    }
}
