package shortestPath;

/**
 * 加权有向边
 * Created by Silocean on 2016-05-06.
 */
public class DirectedEdge {
    private final int v; // 边的起点
    private final int w; // 边的终点
    private final double weight; // 边的权重

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 边的权重
     *
     * @return
     */
    public double weight() {
        return weight;
    }

    /**
     * 指出这条边的顶点
     *
     * @return
     */
    public int from() {
        return v;
    }

    /**
     * 这条边指向的顶点
     *
     * @return
     */
    public int to() {
        return w;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
