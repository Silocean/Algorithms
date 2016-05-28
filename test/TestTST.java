package test;

import trie.TST;
import trie.TrieST;

/**
 * Created by Silocean on 2016-05-13.
 */
public class TestTST {
    public static void main(String[] args) {
        TST<Integer> st = new TST<>();
        st.put("by", 4);
        st.put("sea", 6);
        st.put("sells", 1);
        st.put("shells", 3);
        st.put("she", 0);
        st.put("shore", 7);
        st.put("the", 5);
        System.out.println(st.get("shells"));

    }
}
