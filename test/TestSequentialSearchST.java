package test;

import search.SequentialSearchST;

/**
 * Created by Silocean on 2016-04-27.
 */
public class TestSequentialSearchST {
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        st.put("a", 1);
        st.put("b", 2);
        st.put("c", 3);
        System.out.println(st.get("c"));
    }

}
