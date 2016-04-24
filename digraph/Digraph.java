package digraph;

import bag.Bag;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 有向图
 * Created by Silocean on 2016-04-24.
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    /**
     * 创建一幅包含V个顶点但没有边的有向图
     *
     * @param V
     */
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    /**
     * 从输入流中读取一幅有向图
     *
     * @param br
     * @throws IOException
     */
    public Digraph(BufferedReader br) throws IOException {
        this(Integer.parseInt(br.readLine()));
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            String[] splits = br.readLine().split(" ");
            addEdge(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * 向有向图中添加一条边v->w
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    /**
     * 由v指出的边所连接的所有顶点
     *
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 该图的反向图
     *
     * @return
     */
    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

}
