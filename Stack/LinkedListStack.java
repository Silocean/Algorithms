package Stack;

import java.util.Iterator;

/**
 * Created by Silocean on 2016-04-20.
 */
public class LinkedListStack<Item> implements Iterable {
    private Node first; // 栈顶（最近添加的元素）
    private int N;

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
     * 向栈顶添加元素
     *
     * @param item
     */
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * 从栈顶删除元素
     *
     * @return
     */
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator iterator() {
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
