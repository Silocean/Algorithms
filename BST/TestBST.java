package BST;

/**
 * Created by Silocean on 2016-03-14.
 */
public class TestBST {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = new int[]{2, 6, 1, 3, 9, 23, 0};
        for (int i = 0; i < arr.length; i++) {
            bst.put(arr[i]);
        }
        bst.printAll();
    }
}
