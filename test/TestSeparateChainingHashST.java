package test;

import hashTable.SeparateChainingHashST;

import java.util.Iterator;

/**
 * Created by Silocean on 2016-04-27.
 */
public class TestSeparateChainingHashST {

    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>(7);
        st.put("a", 1);
        st.put("b", 2);
        st.put("c", 3);
        st.put("d", 4);
        st.put("e", 5);
        st.put("f", 6);
        st.put("g", 7);
        System.out.println(st.get("g"));
        System.out.println("=====================");
        Iterator iterator = st.keys().iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

}
