package Graph;

import Bag.Bag;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Silocean on 2016-04-21.
 */
public class TestCC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Graph/G.txt"));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        Graph graph = new Graph(v);
        for (int i = 0; i < e; i++) {
            String[] splits = br.readLine().split(" ");
            graph.addEdge(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));
        }
        CC cc = new CC(graph);
        int M = cc.count();
        System.out.println(M + " components");
        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<Integer>();
        }
        for (int i = 0; i < graph.V(); i++) {
            components[cc.id(i)].add(i);
        }
        for (int i = 0; i < M; i++) {
            for (int x : components[i]) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
