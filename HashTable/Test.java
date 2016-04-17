package HashTable;

/**
 * Created by Silocean on 2016-04-17.
 */
public class Test {
    public static void main(String[] args) {
        LinearProbingHashST<Character, Integer> l = new LinearProbingHashST<>();
        String str = "SEARCHEXAMPLE";
        for (int i = 0; i < str.length(); i++) {
            l.put(str.charAt(i), i);
        }

        System.out.println(l.get('E'));

    }
}
