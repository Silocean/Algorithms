package test;

import stack.LinkedListStack;

import java.util.Iterator;

/**
 * Created by Silocean on 2016-04-20.
 */
public class TestLinkedListStack {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(4);
        stack.push(6);
        stack.pop();
        stack.push(1);
        stack.push(3);
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
