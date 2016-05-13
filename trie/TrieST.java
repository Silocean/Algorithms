package trie;

import queue.Queue;

/**
 * 基于单词查找树的符号表
 * Created by Silocean on 2016-05-13.
 */
public class TrieST<Value> {
    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

    private static int R = 256; // 基数
    private Node root; // 单词查找树的根节点

    /**
     * 键key所对应的值
     *
     * @param key
     * @return
     */
    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.value;
    }

    /**
     * 返回以x作为根节点的单词查找树中与key相关的值
     *
     * @param x
     * @param key
     * @param d
     * @return
     */
    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d); // 找到第d个字符所对应的子单词查找树
        return get(x.next[c], key, d + 1);
    }

    /**
     * 向表中插入键值对
     *
     * @param key
     * @param value
     */
    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    /**
     * 如果key存在于以x为根节点的子单词查找树中则更新与它相关联的值
     *
     * @param x
     * @param key
     * @param value
     * @param d
     * @return
     */
    private Node put(Node x, String key, Value value, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.value = value;
            return x;
        }
        char c = key.charAt(d); // 找到第d个字符所对应的子单词查找树
        x.next[c] = put(x.next[c], key, value, d + 1);
        return x;
    }

    /**
     * 符号表中的所有键
     *
     * @return
     */
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    /**
     * 所有以pre为前缀的键
     *
     * @param pre
     * @return
     */
    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) return;
        if (x.value != null) q.enqueue(pre);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

}
