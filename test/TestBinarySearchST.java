package test;

import search.BinarySearchST;

import java.util.Iterator;

/**
 * Created by Silocean on 2016-04-27.
 */
public class TestBinarySearchST {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(7);
        st.put("a", 1);
        st.put("b", 2);
        //st.put("c", 3);
        st.put("d", 4);
        st.put("e", 5);
        st.put("f", 6);
        st.put("g", 7);
        System.out.println(st.get("f"));
        System.out.println("==================");
        Iterator iterator = st.keys("a","g").iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==================");
        System.out.println(st.ceiling("c"));
    }
}
