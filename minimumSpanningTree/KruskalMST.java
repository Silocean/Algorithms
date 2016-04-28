package minimumSpanningTree;

import priorityQueue.MinPriorityQueue;
import queue.Queue;
import unionFind.WeightedQuickUnion;

/**
 * 最小生成树的Kruskal算法
 * Created by Silocean on 2016-04-28.
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPriorityQueue<Edge> pq = new MinPriorityQueue<>(G.E());
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        WeightedQuickUnion uf = new WeightedQuickUnion(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.deleteMin(); // 从qp得到权重最小的边和它的顶点
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) continue; // 忽略失效的边
            uf.union(v, w); // 合并分量
            mst.enqueue(e); // 将边添加到最小生成树中
        }
    }

    public Iterable<Edge> edges() {
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
