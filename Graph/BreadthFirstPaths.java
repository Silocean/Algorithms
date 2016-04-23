package graph;

import queue.Queue;
import stack.LinkedListStack;

/**
 * 使用广度优先搜索查找图中的路径
 * Created by Silocean on 2016-04-21.
 */
public class BreadthFirstPaths {
    private boolean[] marked; // 到达该顶点的最短路径是否已知
    private int[] edgeTo; // 到达该顶点的已知路径上的最后一个顶点
    private final int s; // 起点

    public BreadthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true; // 标记起点
        queue.enqueue(s); // 将它加入队列
        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // 从队列中删除下一顶点
            for (int w : graph.adj(v)) {
                if (!marked[w]) { // 对于每个未被标记的相邻顶点
                    edgeTo[w] = v; // 保存最短路径的最后的一条边
                    marked[w] = true; // 标记它，因为最短路径已知
                    queue.enqueue(w); // 并将它加入到队列中
                }
            }
        }
    }

    /**
     * 是否存在从s到v的最短路径
     *
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * s到v的最短路径，如果不存在返回null
     *
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        LinkedListStack<Integer> paths = new LinkedListStack();
        for (int x = v; x != s; x = edgeTo[x]) {
            paths.push(x);
        }
        paths.push(s);
        return paths;
    }
}
