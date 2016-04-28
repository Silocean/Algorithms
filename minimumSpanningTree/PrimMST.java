package minimumSpanningTree;

import priorityQueue.IndexMinPriorityQueue;
import queue.Queue;

/**
 * 最小生成树Prim算法的即时实现
 * Created by Silocean on 2016-04-28.
 */
public class PrimMST {
    private Edge[] edgeTo; // 距离树最近的边
    private double[] distTo; // distTo[w] = edgeTo[w].weight()
    private boolean[] marked; // 如果v在树中则为true
    private IndexMinPriorityQueue<Double> pq; // 有效的横切边

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPriorityQueue<>(G.V());
        distTo[0] = 0d;
        pq.insert(0, 0d); // 用顶点0和权重0初始化pq
        while (!pq.isEmpty()) {
            visit(G, pq.deleteMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue; // v-w失效
            if (e.weight() < distTo[w]) { // 连接w和树的最佳边Edge变为e
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    public double weight() {
        double weight = 0d;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
    }
}
