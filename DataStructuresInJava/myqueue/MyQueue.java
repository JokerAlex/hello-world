package com.z.myqueue;

/**
 * @ClassName MyQueue
 * @Description my queue
 * @Author alex
 * @Date 2018/11/17
 **/
public interface MyQueue<T> {

    int getSize();

    boolean isEmpty();

    void enqueue(T t);

    T dequeue();

    T getFront();
}
