package search;

/**
 * 顺序查找（基于无序链表）
 * Created by Silocean on 2016-04-27.
 */
public class SequentialSearchST<Key, Value> {

    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 查找给定的键，返回相关联的值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value; // 命中
            }
        }
        return null; // 未命中
    }

    /**
     * 查找给定的键，找到则更新其值，否则在表中新建节点
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value; // 命中，更新
                return;
            }
        }
        first = new Node(key, value, first); // 未命中，新建节点（插入链表头）
    }

}
