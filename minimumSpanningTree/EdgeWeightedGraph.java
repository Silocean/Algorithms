package minimumSpanningTree;

import bag.Bag;

import java.io.BufferedReader;

/**
 * 加权无向图
 * Created by Silocean on 2016-04-28.
 */
public class EdgeWeightedGraph {

    private final int V; // 顶点总数
    private int E; // 边的总数
    private Bag<Edge>[] adj; // 邻接表

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(BufferedReader br) throws Exception {
        this(Integer.parseInt(br.readLine().split(" ")[0]));
        int e = Integer.parseInt(br.readLine().split(" ")[1]);
        for (int i = 0; i < e; i++) {
            String[] splits = br.readLine().split(" ");
            Edge edge = new Edge(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]),
                    Double.parseDouble(splits[2]));
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
     * 向图中添加一条边
     *
     * @param e
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /**
     * 和v相关联的所有边
     *
     * @param v
     * @return
     */
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    /**
     * 图的所有边
     *
     * @return
     */
    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    b.add(e);
                }
            }
        }
        return b;
    }
}
