package com.z.mystack;

import com.z.mylist.MyArrayList;

/**
 * @ClassName MyArrayStack
 * @Description my array stack
 * @Author alex
 * @Date 2018/11/17
 **/
public class MyArrayStack<T> implements MyStack<T> {

    private MyArrayList<T> arrayList;

    public MyArrayStack(int capacity) {
        this.arrayList = new MyArrayList<T>(capacity);
    }

    public MyArrayStack() {
        this.arrayList = new MyArrayList<T>();
    }

    @Override
    public int getSize() {
        return arrayList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public void push(T t) {
        arrayList.addLast(t);
    }

    @Override
    public T pop() {
        return arrayList.removeLast();
    }

    @Override
    public T peek() {
        return arrayList.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < arrayList.getSize(); i++) {
            res.append(arrayList.get(i));
            if (i != arrayList.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();

    }

    public static void main(String[] args) {
        MyArrayStack<Integer> myArrayStack = new MyArrayStack<Integer>();
        for (int i = 0; i < 5; i++) {
            myArrayStack.push(i);
            System.out.println(myArrayStack);
        }

        System.out.println(myArrayStack.peek());
        myArrayStack.pop();
        System.out.println(myArrayStack);
    }
}
