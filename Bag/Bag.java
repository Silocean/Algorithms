package Bag;

import java.util.Iterator;

/**
 * 背包（和stack一样也是先进后出的顺序，不过顺序在这里并不重要）
 * Created by Silocean on 2016-04-20.
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first; // 链表的首节点

    private class Node {
        Item item;
        Node next;
    }

    /**
     * 添加元素（和stack的put方法完全相同）
     *
     * @param item
     */
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
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
