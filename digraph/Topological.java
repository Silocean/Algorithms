package digraph;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 拓扑排序
 * Created by Silocean on 2016-04-25.
 */
public class Topological {

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

    private Iterable<Integer> order; // 顶点的拓扑排序

    public Topological(Digraph G) {
        DirectedCycle directedCycle = new DirectedCycle(G);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    /**
     * 拓扑排序的所有顶点
     *
     * @return
     */
    public Iterable<Integer> order() {
        return order;
    }

    /**
     * G是有向无环图吗？
     *
     * @return
     */
    public boolean isDAG() {
        return order != null;
    }
}
