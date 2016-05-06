package test;

import shortestPath.DijkstraSP;
import shortestPath.DirectedEdge;
import shortestPath.EdgeWeightedDigraph;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Silocean on 2016-05-06.
 */
public class TestDijkstraSP {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/test/EWD.txt"));
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(br);
        int s = 0;
        DijkstraSP sp = new DijkstraSP(G, s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + " to " + v);
            System.out.printf(" (%4.2f): ", sp.distTo(v));
            if (sp.hasPathTo(v)) {
                for (DirectedEdge e : sp.pathTo(v)) {
                    System.out.print(e + " ");
                }
            }
            System.out.println();
        }
    }
}
