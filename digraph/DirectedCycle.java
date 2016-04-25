package digraph;

import stack.LinkedListStack;

/**
 * 寻找有向环
 * Created by Silocean on 2016-04-25.
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private LinkedListStack<Integer> cycle; // 有向环中所有顶点（如果存在）
    private boolean[] onStack; // 递归调用栈上的所有顶点

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new LinkedListStack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false; // 回溯
    }

    /**
     * 有向图中是否有环
     *
     * @return
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * 有向环中所有顶点（如果存在的话）
     *
     * @return
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }

}
