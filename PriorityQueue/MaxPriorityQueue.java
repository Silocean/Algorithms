package priorityQueue;

/**
 * 优先队列
 * Created by Silocean on 2016-03-25.
 */
public class MaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0; // 存储于pa[1...N]中，pq[0]没有使用

    public MaxPriorityQueue(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key k) {
        pq[++N] = k;
        swim(N);
    }

    public Key deleteMax() {
        Key max = pq[1]; // 从根节点得到最大元素
        exch(1, N--); // 将其和最后一个节点交换
        // pq[N + 1] = null;
        sink(1); // 修复堆的有序性
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 由下至上的堆有序化
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 由上至下的堆有序化
     *
     * @param k
     */
    public void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

}
