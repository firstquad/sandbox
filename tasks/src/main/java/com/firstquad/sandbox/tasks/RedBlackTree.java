package com.firstquad.sandbox.tasks;

import java.util.LinkedList;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class RedBlackTree {
    Node root;

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.put(1, "1");
        tree.put(2, "2");
        tree.put(9, "9");
        tree.put(5, "5");
        tree.put(7, "7");
        tree.put(4, "4");
//        System.out.println(tree.get(7));
//        System.out.println(tree.get(2));
//        System.out.println(tree.get(1));
        tree.print();
    }

    public void print() {
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node x = nodes.remove();
            if (x == null)
                continue;
            System.out.println(x);
            nodes.add(x.left);
            nodes.add(x.right);
        }
    }

    public String get(int key) {
        Node x = root;
        while (x != null) {
            if (key > x.key)
                x = x.right;
            else if (key < x.key) {
                x = x.left;
            } else
                return x.value;
        }
        return null;
    }

    public void put(int key, String value) {
        root = put(root, key, value);
    }

    public Node put(Node h, int key, String value) {
        if (h == null) {
            return new Node(key, value, true);
        }

        if (key > h.key) {
            h.right = put(h.right, key, value);
        } else if (key < h.key) {
            h.left = put(h.left, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        } else if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        } else if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
    }

    private Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.isRed = h.isRed;
        h.isRed = true;
        return x;
    }

    private Node rotateRight(Node h) {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.isRed = h.isRed;
        h.isRed = true;
        return x;
    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);

        h.isRed = true;
        h.left.isRed = false;
        h.right.isRed = false;
    }

    private boolean isRed(Node x) {
        return x != null && x.isRed;
    }

    private class Node {
        Node left;
        Node right;
        boolean isRed;
        int key;
        String value;

        public Node(int key, String value, boolean isRed) {
            this.key = key;
            this.value = value;
            this.isRed = isRed;
        }

        @Override
        public String toString() {
            return "value='" + value + "\n";
        }
    }

}
