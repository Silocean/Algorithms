package test;

import search.BST;

import java.util.Iterator;

/**
 * Created by Silocean on 2016-03-14.
 */
public class TestBST {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.put("a", 1);
        bst.put("b", 2);
        bst.put("c", 3);
        bst.put("d", 4);
        bst.put("e", 5);
        bst.put("f", 6);
        bst.put("g", 7);
        // System.out.println(bst.min());
        Iterator iterator = bst.keys().iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("========================");
        bst.delete("c");
        iterator = bst.keys().iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
