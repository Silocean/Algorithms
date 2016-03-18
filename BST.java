/**
 * 二叉查找树
 * Created by Silocean on 2016-03-17.
 */
public class BST {

    private Node root;

    private class Node {
        public Node(int key) {
            this.key = key;
        }

        private int key;
        private Node left, right;
    }

    /**
     * 插入
     *
     * @param key
     */
    public void put(int key) {
        root = this.put(root, key);
    }

    private Node put(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = put(node.left, key);
        else if (key > node.key) node.right = put(node.right, key);
        return node;
    }

    /**
     * 查找
     *
     * @param key
     * @return
     */
    public Node get(int key) {
        return this.get(root, key);
    }

    private Node get(Node node, int key) {
        if (node == null) return null;
        if (key < node.key) return get(node.left, key);
        else if (key > node.key) return get(node.right, key);
        return node;
    }

    /**
     * 顺序打印所有节点
     */
    public void printAll() {
        this.print(root);
    }

    private void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.key + " ");
            print(node.right);
        }
    }

}
