package test;

import graph.Graph;
import graph.SymbolGraph;

import java.io.BufferedReader;

/**
 * Created by Silocean on 2016-04-21.
 */
public class TestSymbolGraph {
    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        SymbolGraph symbolGraph = new SymbolGraph(br, ";");
        Graph graph = symbolGraph.G();
        for (int w : graph.adj(symbolGraph.index("Bai"))) {
            System.out.println(symbolGraph.name(w));
        }
    }
}
