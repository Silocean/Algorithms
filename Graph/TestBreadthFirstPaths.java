package Graph;

/**
 * Created by Silocean on 2016-04-21.
 */
public class TestBreadthFirstPaths {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);
        int s = 0;
        BreadthFirstPaths search = new BreadthFirstPaths(graph, s);
        for (int v = 0; v < graph.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("-" + x);
                    }
                }
            }
            System.out.println();
        }
    }
}
