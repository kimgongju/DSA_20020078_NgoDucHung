package Week10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    Node root; // root of tree

    /**
     * default constructor.
     */
    public Tree() {
        root = null;
    }

    static class Node {
        int data; // value of node
        boolean visited; // check visiting
        Node parent; // parent of node
        List<Node> children; // list children of node

        /**
         * parameterized constructor.
         * @param data int data
         * @param parent Node parent
         * @param children List<Node> children </Node>
         */
        public Node(int data, Node parent, List<Node> children) {
            this.data = data;
            this.parent = parent;
            this.children = children;
            this.visited = false;
        }

        /**
         * override function.
         * @return String change to string
         */
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    /**
     * insert node into tree.
     * @param root Node root
     * @param parent int parent
     * @param newInt int newInt
     */
    static void insertNode(Node root, int parent, int newInt) {
        if (parent == root.data) {
            Node tmp = new Node(newInt, root, new ArrayList<Node>()); // new node

            root.children.add(tmp);

            return;
        }
        for (Node child : root.children) {
            insertNode(child, parent, newInt);
        }
    }

    /**
     * delete node from tree.
     * @param root Node root
     * @param key int key
     */
    static void delete(Node root, int key) {
        if (root.data == key) {
            root = null;

            return;
        }

        int num = root.children.size(); // number of children

        root.children.removeIf((Node child) -> {
            return child.data == key;
        });
        for (Node child : root.children) {
            delete(child, key);
        }
    }

    /**
     * check binary tree.
     * @param root Node root
     * @return boolean true or false
     */
    static boolean isBinaryTree(Node root) {
        if (root.children.size() > 2) {
            return false;
        }
        for (Node child : root.children) {
            if(!isBinaryTree(child)) {
                return false;
            }
        }

        return true;
    }

    /**
     * check BST.
     * @param root Node root
     * @return boolean true or false
     */
    static boolean isBinarySearchTree(Node root) {
        if (!isBinaryTree(root)) {
            return false;
        }
        return isBST(root, null, null);
    }

    /**
     * check BST.
     * @param x Node x
     * @param min Integer min
     * @param max Integer max
     * @return
     */
    public static boolean isBST(Node x, Integer min, Integer max) {
        if (x == null) {
            return true;
        }
        if ((min != null && x.data <= min) || (max != null && x.data >= max)){
            return false;
        }
        Node left = null; // left children
        Node right = null; // right children

        if (x.children.size() > 0) {
            left = x.children.get(0);
        }
        if (x.children.size() > 1) {
            right = x.children.get(1);
        }

        return isBST(left, min, x.data) && isBST(right, x.data, max);
    }

    /**
     * check max binary heap.
     * @param root Node root
     * @return boolean true or false
     */
    static boolean isMaxBinaryHeap(Node root) {
        if (root == null) {
            return true;
        }
        if (root.children.size() > 2) {
            return false;
        }
        Node left = null; // left children
        Node right = null; // right children

        if (root.children.size() > 0) {
            left = root.children.get(0);
        }
        if (root.children.size() > 1) {
            right = root.children.get(1);
        }
        if (left != null && root.data <= left.data) {
            return false;
        }
        if (right != null && root.data <= right.data) {
            return false;
        }

        return isMaxBinaryHeap(left) && isMaxBinaryHeap(right);
    }

    /**
     * calculate height.
     * @param root Node root
     * @return int height
     */
    static int height(Node root) {
        int curHeight = 0;

        for (Node child : root.children) {
            curHeight = Math.max(height(child) + 1, curHeight);
        }

        return curHeight;
    }

    /**
     * print tree.
     * @param root Node root
     */
    static void print(Node root) {
        Queue<Node> q = new LinkedList<>(); // new queue

        q.add(root);
        while (!q.isEmpty()) {
            Node top = q.poll(); // top of queue

            System.out.println(top);
            for (Node child : root.children) {
                q.add(child);
            }
        }
    }

    /**
     * preorder print.
     * @param root Node root
     */
    static public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        for (Node child : root.children) {
            preorder(child);
        }
    }

    /**
     * postorder print.
     * @param root Node root
     */
    static public void postorder(Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postorder(child);
        }
        System.out.println(root);
    }

    public static void main(String[] args) {

    }
}