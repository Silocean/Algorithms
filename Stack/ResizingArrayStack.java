package Stack;

import java.util.Iterator;

/**
 * Created by Silocean on 2016-04-19.
 */
public class ResizingArrayStack<Item> implements Iterator<Item> {
    private Item[] a = (Item[]) new Object[1]; // 栈元素列表
    private int N = 0; // 元素数量
    private int index = N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 动态调整栈大小
     *
     * @param max
     */
    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * 添加元素到栈顶
     *
     * @param item
     */
    public void push(Item item) {
        if (N == a.length) resize(a.length * 2);
        a[N++] = item;
    }

    /**
     * 从栈顶删除元素
     *
     * @return
     */
    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    @Override
    public boolean hasNext() {
        return index > 0;
    }

    @Override
    public Item next() {
        return a[--index];
    }

    @Override
    public void remove() {

    }
}
