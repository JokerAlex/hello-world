package com.z.mylist;

/**
 * @ClassName MyLinkedList
 * @Description my linked list
 * @Author alex
 * @Date 2018/11/17
 **/
public class MyLinkedList<T> {
    private class Node<T> {
        public T data;
        public Node<T> next;

        public Node() {
            this(null, null);
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> dummyHead;

    private int size;

    public MyLinkedList() {
        this.dummyHead = new Node<T>();
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void add(int index, T t) {
        if (index < 0 || index > getSize()) {
            throw new IllegalArgumentException("index is wrong");
        }

        Node<T> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        /*Node<T> temp = new Node<T>(t, null);
        temp.next = cur.next;
        cur.next = temp;*/
        prev.next = new Node<T>(t, prev.next);
        size++;
    }

    public void addFirst(T t) {
        add(0, t);

    }

    public void addLast(T t) {
        add(getSize(), t);
    }

    public T get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index is wrong");
        }

        Node<T> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(getSize() - 1);
    }

    public void set(int index, T t) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index is wrong");
        }

        Node<T> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = t;
    }

    public boolean contains(T t) {
        Node<T> cur = dummyHead.next;
        while (cur.next != null) {
            if (cur.data.equals(t)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public T remove(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index is wrong");
        }

        Node<T> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        T res = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return res;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(getSize() - 1);
    }

    public void removeT(T t) {
        Node<T> prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.data.equals(t)) {
                prev.next = prev.next.next;
                size--;
            } else {
                prev = prev.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node<T> cur = dummyHead.next;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            myLinkedList.addLast(i);
            System.out.println(myLinkedList);
        }

        myLinkedList.addFirst(100);
        System.out.println(myLinkedList);

        myLinkedList.add(3, 100);
        System.out.println(myLinkedList);

        myLinkedList.removeLast();
        System.out.println(myLinkedList);

        myLinkedList.removeT(100);
        System.out.println(myLinkedList);

        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));

        myLinkedList.set(0, 100);
        System.out.println(myLinkedList);
    }
}
