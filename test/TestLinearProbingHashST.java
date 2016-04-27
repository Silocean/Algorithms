package test;

import hashTable.LinearProbingHashST;

/**
 * Created by Silocean on 2016-04-17.
 */
public class TestLinearProbingHashST {
    public static void main(String[] args) {
        LinearProbingHashST<Character, Integer> l = new LinearProbingHashST<>();
        String str = "SEARCHEXAMPLE";
        for (int i = 0; i < str.length(); i++) {
            l.put(str.charAt(i), i);
        }

        System.out.println(l.get('E'));

        System.out.println(l.contains('Z'));

    }
}
