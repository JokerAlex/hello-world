package com.z.myqueue;

/**
 * @ClassName MyLinkedQueue
 * @Description my linked queue
 * @Author alex
 * @Date 2018/11/17
 **/
public class MyLinkedQueue<T> implements MyQueue<T> {
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

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void enqueue(T t) {
        if (tail == null) {
            tail = new Node<T>(t);
            head = tail;
        } else {
            tail.next = new Node<T>(t);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        T res = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return res;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return head.data;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d\n", size));
        res.append("front [");
        Node<T> cur = head;
        while (cur != null) {
            res.append(cur.data).append("->");
            cur = cur.next;
        }
        res.append("NULL] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
