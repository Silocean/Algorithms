package priorityQueue;

/**
 * 索引优先队列
 * Created by Silocean on 2016-04-28.
 */
public class IndexMinPriorityQueue<Key extends Comparable<Key>> {
    private int N; // pq中的元素数量
    private int[] pq; // 索引二叉堆，由1开始
    private int[] qp; // 逆序：qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys; // 有优先级之分的元素

    public IndexMinPriorityQueue(int maxN) {
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void insert(int k, Key key) {
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    public Key min() {
        return keys[pq[1]];
    }

    public int minIndex() {
        return pq[1];
    }

    public int deleteMin() {
        int indexOfMin = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N + 1]] = null;
        qp[pq[N + 1]] = -1;
        return indexOfMin;
    }

    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void delete(int k) {
        int index = qp[k];
        exch(index, N--);
        swim(index);
        sink(index);
        keys[k] = null;
        qp[k] = -1;
    }

    private boolean more(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * 由下至上的堆有序化
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && more(k / 2, k)) {
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
            if (j < N && more(j, j + 1)) j++;
            if (!more(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}
