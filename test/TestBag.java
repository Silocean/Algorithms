package test;

import bag.Bag;

import java.util.Iterator;

/**
 * Created by Silocean on 2016-04-20.
 */
public class TestBag {
    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<Integer>();
        bag.add(1);
        bag.add(5);
        bag.add(6);
        Iterator<Integer> iterator = bag.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
