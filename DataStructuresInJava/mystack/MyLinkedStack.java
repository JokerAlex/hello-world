package com.z.mystack;

import com.z.mylist.MyLinkedList;

/**
 * @ClassName MyLinkedStack
 * @Description my linked list
 * @Author alex
 * @Date 2018/11/17
 **/
public class MyLinkedStack<T> implements MyStack<T> {
    private MyLinkedList<T> myLinkedList;

    public MyLinkedStack() {
        myLinkedList = new MyLinkedList<T>();
    }

    @Override
    public int getSize() {
        return myLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myLinkedList.isEmpty();
    }

    @Override
    public void push(T t) {
        myLinkedList.addFirst(t);
    }

    @Override
    public T pop() {
        return myLinkedList.removeFirst();
    }

    @Override
    public T peek() {
        return myLinkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(myLinkedList);
        return res.toString();
    }

    public static void main(String[] args) {
        MyLinkedStack<Integer> myLinkedStack = new MyLinkedStack<Integer>();

        for (int i = 0; i < 5; i++) {
            myLinkedStack.push(i);
            System.out.println(myLinkedStack);
        }

        System.out.println(myLinkedStack.peek());
        myLinkedStack.pop();
        System.out.println(myLinkedStack);
    }
}
