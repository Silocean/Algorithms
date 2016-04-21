package Graph;

/**
 * Created by Silocean on 2016-04-21.
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph graph) {
        marked = new boolean[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s, s);
            }
        }
    }

    private void dfs(Graph graph, int v, int u) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
