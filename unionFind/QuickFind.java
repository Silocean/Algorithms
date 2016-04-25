package unionFind;

/**
 * Created by Tracy on 2016-04-23.
 */
public class QuickFind {
    private int[] id; // 分量id（以触点作为索引）
    private int count; // 分量数量

    public QuickFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
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
        return id[p];
    }

    /**
     * 在p和q之间添加一条连接
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        // 如果p和q已经在同一分量中则不采取任何行动
        if (pID == qID) return;
        // 将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }
        count--;
    }
}
