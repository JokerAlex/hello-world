package com.z.mytree;

/**
 * @ClassName MyAvlTree
 * @Description my avl tree
 * @Author alex
 * @Date 2018/11/21
 **/
public class MyAvlTree<T extends Comparable<T>> {
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        int hight;

        Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.hight = 0;
        }

        Node(T data) {
            this(data, null, null);
        }
    }

    private Node<T> root;

    public MyAvlTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getHeight(Node<T> node) {
        return node == null ? -1 : node.hight;
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
        return balance(node);
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

        return balance(node);
    }

    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + "\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private Node<T> balance(Node<T> node) {
        if (node == null) {
            return null;
        }

        if (getHeight(node.left) - getHeight(node.right) > 1) {
            if (getHeight(node.left.left) >= getHeight(node.left.right)) {
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }
        } else if (getHeight(node.right) - getHeight(node.left) > 1) {
            if (getHeight(node.right.right) >= getHeight(node.right.left)) {
                node = rotateWithRightChild(node);
            } else {
                node = doubleWithRightChild(node);
            }
        }

        node.hight = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }

    //       k2               k1
    //      /  \             /  \
    //     k1   Z   ===>    X   k2
    //    /  \                 /  \
    //   X    Y               Y    Z

    private Node<T> rotateWithLeftChild(Node<T> k2) {
        Node<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.hight = Math.max(getHeight(k2.left), getHeight(k2.right)) + 1;
        k1.hight = Math.max(getHeight(k1.left), k2.hight) + 1;
        return k1;
    }

    //       k2                 k1
    //      /  \               /  \
    //     Z   k1     ===>    k2   Y
    //        /  \           /  \
    //       X    Y         Z    X

    private Node<T> rotateWithRightChild(Node<T> k2) {
        Node<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.hight = Math.max(getHeight(k2.left), getHeight(k2.right)) + 1;
        k1.hight = Math.max(getHeight(k1.right), k2.hight) + 1;
        return k1;
    }

    //           k3                      k2
    //          /  \                   /    \
    //         k1   D                 /      \
    //        /  \        ===>      k1        k3
    //       A   k2                /  \      /  \
    //          /  \              A    B    C    D
    //         B    C

    private Node<T> doubleWithLeftChild(Node<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    //           k1                     k3
    //          /  \                  /    \
    //         D    k2               /      \
    //             /  \    ===>    k1        k2
    //            k3   A          /  \      /  \
    //           /  \            D    B    C    A
    //          B    C

    private Node<T> doubleWithRightChild(Node<T> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    public static void main(String[] args) {
        MyAvlTree<Integer> tree = new MyAvlTree<Integer>();
        int[] a = {5, 6, 3, 4, 2, 1, 10, 8, 9, 7};

        for (int i : a) {
            tree.insert(i);
        }
        tree.printTree();
    }
}
