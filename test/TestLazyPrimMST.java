package test;

import minimumSpanningTree.Edge;
import minimumSpanningTree.EdgeWeightedGraph;
import minimumSpanningTree.LazyPrimMST;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Silocean on 2016-04-28.
 */
public class TestLazyPrimMST {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/test/EWG.txt"));
        EdgeWeightedGraph G = new EdgeWeightedGraph(br);
        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }
        System.out.println(mst.weight());
    }

}
