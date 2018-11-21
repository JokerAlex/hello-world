package com.z.mytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MyBinarySearchTree
 * @Description my binary search tree without repeating element
 * @Author alex
 * @Date 2018/11/21
 **/
public class MyBinarySearchTree<T extends Comparable<T>> {

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(T data) {
            this(data, null, null);
        }
    }

    private Node<T> root;

    public MyBinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T t) {
        return contains(root, t);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new IllegalArgumentException("tree is empty");
        }
        return findMin(root).data;
    }

    public T findMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("tree is empty");
        }
        return findMax(root).data;
    }

    public void insert(T t) {
        root = insert(root, t);
    }

    public void remove(T t) {
        root = remove(root, t);
    }

    public void printTree() {
        if (isEmpty()) {
            throw new IllegalArgumentException("tree is empty");
        }

        System.out.println("preOrder:");
        preOrder(root);
        System.out.println();

        System.out.println("inOrder:");
        inOrder(root);
        System.out.println();

        System.out.println("postOrder:");
        postOrder(root);
        System.out.println();

        System.out.println("levelOrder:");
        levelOrder();
        System.out.println();
    }

    private boolean contains(Node<T> node, T t) {
        if (node == null) {
            return false;
        }

        int compareResult = t.compareTo(node.data);

        if (compareResult < 0) {
            return contains(node.left, t);
        } else if (compareResult > 0) {
            return contains(node.right, t);
        } else {
            return true;
        }
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node<T> findMax(Node<T> node) {
        if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    private Node<T> insert(Node<T> node, T t) {
        if (node == null) {
            return new Node<T>(t);
        }

        int compareResult = t.compareTo(node.data);

        if (compareResult < 0) {
            node.left = insert(node.left, t);
        } else if (compareResult > 0) {
            node.right = insert(node.right, t);
        }
        return node;
    }

    private Node<T> remove(Node<T> node, T t) {
        if (node == null) {
            return null;
        }

        int compareResult = t.compareTo(node.data);

        if (compareResult < 0) {
            node.left = remove(node.left, t);
        } else if (compareResult > 0) {
            node.right = remove(node.right, t);
        } else {
            if (node.left != null && node.right != null) {
                node.data = findMin(node.right).data;
                node.right = remove(node.right, node.data);
            } else {
                node = node.left != null ? node.left : node.right;
            }
        }

        return node;
    }

    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + "\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + "\t");
            inOrder(node.right);
        }
    }

    private void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + "\t");
        }
    }

    private void levelOrder() {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<T> cur = queue.poll();
            System.out.print(cur.data + "\t");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
        int[] a = {5, 6, 3, 4, 2, 1, 10, 8, 9, 7};

        for (int i : a) {
            tree.insert(i);
        }
        tree.printTree();
    }
}
