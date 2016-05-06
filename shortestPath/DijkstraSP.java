package shortestPath;

import priorityQueue.IndexMinPriorityQueue;
import stack.LinkedListStack;

/**
 * 最短路径的Dijkstra算法
 * Created by Silocean on 2016-05-06.
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPriorityQueue<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPriorityQueue<>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;
        pq.insert(s, 0.0);

        while (!pq.isEmpty()) {
            relax(G, pq.deleteMin());
        }

    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    /**
     * 从顶点s到v的距离，如果不存在则路径为无穷大
     *
     * @param v
     * @return
     */
    public double distTo(int v) {
        return distTo[v];
    }

    /**
     * 是否存在从顶点s到v的路径
     *
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * 从顶点s到v的路径，如果不存在则为null
     *
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        LinkedListStack<DirectedEdge> path = new LinkedListStack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
