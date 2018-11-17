package com.z.myqueue;

import com.z.mylist.MyArrayList;

/**
 * @ClassName MyArrayQueue
 * @Description my array queue
 * @Author alex
 * @Date 2018/11/17
 **/
public class MyArrayQueue<T> implements MyQueue<T> {

    private MyArrayList<T> myArrayList;

    public MyArrayQueue(int capacity) {
        myArrayList = new MyArrayList<T>(capacity);
    }

    public MyArrayQueue() {
        myArrayList = new MyArrayList<T>();
    }

    @Override
    public int getSize() {
        return myArrayList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myArrayList.isEmpty();
    }

    @Override
    public void enqueue(T t) {
        myArrayList.addLast(t);
    }

    @Override
    public T dequeue() {
        return myArrayList.removeFirst();
    }

    @Override
    public T getFront() {
        return myArrayList.getFirst();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < myArrayList.getSize(); i++) {
            res.append(myArrayList.get(i));
            if (i != myArrayList.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        MyArrayQueue<Integer> queue = new MyArrayQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 2 == 1) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
