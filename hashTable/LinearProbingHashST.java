package hashTable;

/**
 * 基于线性探测的符号表
 * Created by Silocean on 2016-04-17.
 */
public class LinearProbingHashST<Key, Value> {

    private int N; // 符号表中的键值对总数
    private int M = 16; // 线性探测表的大小
    private Key[] keys; // 键
    private Value[] values; // 值

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * 插入
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        if (N > M / 2) {
            resize(M * 2);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    /**
     * 查找
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    /**
     * 删除（不能直接删除键，需要将簇中被删除键右侧的所有键重新插入散列表中）
     *
     * @param key
     */
    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], values[i]);
            }
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    public int size() {
        return N;
    }
}
