package com.z.mystack;

/**
 * @ClassName MyStack
 * @Description my stack interface
 * @Author alex
 * @Date 2018/11/17
 **/
public interface MyStack<T> {

    int getSize();

    boolean isEmpty();

    void push(T t);

    T pop();

    T peek();
}
