package test;

import stack.ResizingArrayStack;

import java.util.Iterator;

/**
 * Created by Silocean on 2016-04-19.
 */
public class TestStack {
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("stack");
        stack.pop();
        stack.push("log");
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        /*while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }*/
    }
}
