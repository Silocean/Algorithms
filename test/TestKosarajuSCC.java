package test;

import digraph.Digraph;
import digraph.KosarajuSCC;
import queue.Queue;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Silocean on 2016-04-25.
 */
public class TestKosarajuSCC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/test/DG.txt"));
        Digraph digraph = new Digraph(br);
        KosarajuSCC kosarajuSCC = new KosarajuSCC(digraph);
        System.out.println(kosarajuSCC.count() + " components");
        int count = kosarajuSCC.count();
        Queue<Integer>[] components = new Queue[count];
        for (int i = 0; i < count; i++) {
            components[i] = new Queue<>();
        }
        for (int v = 0; v < digraph.V(); v++) {
            components[kosarajuSCC.id(v)].enqueue(v);
        }
        for (int i = 0; i < count; i++) {
            for (int w : components[i]) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
