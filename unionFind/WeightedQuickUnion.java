package unionFind;

/**
 * Created by Tracy on 2016-04-23.
 */
public class WeightedQuickUnion {
    private int[] id; // 父连接数组（以触点作为索引）
    private int[] sz; // （由触点索引的）各个根节点所对应的分量的大小
    private int count; // 分量数量

    public WeightedQuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    /**
     * 连通分量的数量
     *
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * 如果p和q存在于同一个分量中则返回true
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * p（0~N-1）所在的分量的标识符
     *
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    /**
     * 将p和q的根节点统一
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        // 如果p和q已经在同一分量中则不采取任何行动
        if (i == j) return;
        // 将小树的根节点连接到大树的根节点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}
