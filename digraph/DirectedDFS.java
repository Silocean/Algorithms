package digraph;

/**
 * 有向图的可达性
 * Created by Silocean on 2016-04-24.
 */
public class DirectedDFS {
    private boolean[] marked;

    /**
     * 从digraph中找出s可达的所有顶点
     *
     * @param G
     * @param s
     */
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * 从digraph中找到从sources中的所有顶点可达的所有顶点
     *
     * @param G
     * @param sources
     */
    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * v是可达的吗？
     *
     * @param v
     * @return
     */
    public boolean marked(int v) {
        return marked[v];
    }
}
