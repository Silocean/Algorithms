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
     * @param digraph
     * @param s
     */
    public DirectedDFS(Digraph digraph, int s) {
        marked = new boolean[digraph.V()];
        dfs(digraph, s);
    }

    /**
     * 从digraph中找到从sources中的所有顶点可达的所有顶点
     *
     * @param digraph
     * @param sources
     */
    public DirectedDFS(Digraph digraph, Iterable<Integer> sources) {
        marked = new boolean[digraph.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(digraph, s);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
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
