package search;

import queue.Queue;

/**
 * 二分查找（基于有序数组）
 * Created by Silocean on 2016-04-27.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    /**
     * 表中的键值对数量
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取键key对应的值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return values[i];
        else return null;
    }

    /**
     * 将键值对存入表中
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    /**
     * 小于key的键的数量
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    /**
     * 最小的键
     *
     * @return
     */
    public Key min() {
        return keys[0];
    }

    /**
     * 最大的键
     *
     * @return
     */
    public Key max() {
        return keys[N - 1];
    }

    /**
     * 排名为k的键
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        return keys[k];
    }

    /**
     * 小于等于key的最大键
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) return keys[i];
        else return keys[i - 1];
    }

    /**
     * 大于等于key的最小键
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    /**
     * 键key是否存在于表中
     *
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * 从表中删除key及其对应的value
     *
     * @param key
     */
    public void delete(Key key) {
        if (isEmpty()) return;
        int i = rank(key);
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < N - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        N--;
        keys[N] = null;
        values[N] = null;
    }

    /**
     * 表中所有键的集合（已排序）
     *
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue q = new Queue();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }
}
