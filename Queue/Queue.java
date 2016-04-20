package Queue;

import java.util.Iterator;

/**
 * 先进先出队列（链表实现）
 * Created by Silocean on 2016-04-20.
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first; // 最早添加的节点
    private Node last; // 最近添加的节点
    private int N; // 队列中的元素数量

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
        // return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 向队列尾添加元素
     *
     * @param item
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    /**
     * 从队列头删除元素
     *
     * @return
     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) first = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
