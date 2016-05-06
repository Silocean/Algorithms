package shortestPath;

import bag.Bag;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 加权有向图
 * Created by Silocean on 2016-05-06.
 */
public class EdgeWeightedDigraph {
    private final int V; // 顶点总数
    private int E; // 边的总数
    private Bag<DirectedEdge>[] adj; // 邻接表

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedDigraph(BufferedReader br) throws IOException {
        this(Integer.parseInt(br.readLine()));
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            String[] splits = br.readLine().split(" ");
            DirectedEdge edge = new DirectedEdge(Integer.parseInt(splits[0]),
                    Integer.parseInt(splits[1]), Double.parseDouble(splits[2]));
            addEdge(edge);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * 将e添加到该有向图中
     *
     * @param e
     */
    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    /**
     * 从v指出的边
     *
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /**
     * 该有向图中的所有边
     *
     * @return
     */
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                bag.add(e);
            }
        }
        return bag;
    }


    @Override
    public String toString() {
        String str = V + "vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            str += v + ": ";
            for (DirectedEdge e : adj(v)) {
                str += e.toString() + ";";
            }
            str += "\n";
        }
        return str;
    }


}
