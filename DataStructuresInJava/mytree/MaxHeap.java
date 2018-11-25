package com.z.mytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @ClassName MaxHeap
 * @Description max heap
 * @Author alex
 * @Date 2018/11/21
 **/
public class MaxHeap<T extends Comparable<T>> {
    private ArrayList<T> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<T>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<T>();
    }

    public MaxHeap(T[] array) {
        data = new ArrayList<T>(array.length);
        Collections.addAll(data, array);
        for (int i = getParent(array.length - 1); i >= 0; i--) {
            siftDown(i);
        }

    }

    public int getSize() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(T t) {
        data.add(t);
        siftUp(data.size() - 1);
    }

    public T getMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    public T extractMax() {
        T res = getMax();

        swap(0, getSize() - 1);
        data.remove(getSize() - 1);
        siftDown(0);
        return res;
    }

    public T replace(T t) {
        T res = getMax();
        data.set(0, t);
        siftDown(0);
        return res;
    }

    public void printHeap() {
        for (T t : data) {
            System.out.print(t.toString() + "\t");
        }
    }


    private int getParent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("0 has no getParent");
        }
        return (index - 1) / 2;
    }

    private int getLeft(int index) {
        return index * 2 + 1;
    }

    private int getRight(int index) {
        return index * 2 + 2;
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(getParent(index)).compareTo(data.get(index)) < 0) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    private void siftDown(int index) {
        //下标是否越界-左孩子下标比右孩子下标小，如果左的下标越界，就代表越界了
        while (getLeft(index) < getSize()) {
            //maxChildIndex 为左右孩子里值大的下标
            int maxChildIndex = getLeft(index);
            if (getRight(index) < getSize() && data.get(getRight(index)).compareTo(data.get(getLeft(index))) > 0) {
                //如果右孩子下标没有越界，并且右孩子值比左孩子大，将 maxChildIndex 复值为右孩子的下标
                maxChildIndex = getRight(index);
            }

            //如果当前值比左右孩子都大，则下滤结束
            if (data.get(index).compareTo(data.get(maxChildIndex)) >= 0) {
                break;
            }
            swap(index, maxChildIndex);
            index = maxChildIndex;
        }
    }

    private void swap(int i, int j) {
        T t = data.get(i);
        data.set(i, data.get(j));
        data.set(j, t);
    }


    public static void main(String[] args) {
        Random random = new Random();
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(10);
        int n = 20;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            int item = random.nextInt(n);
            a[i] = item;
            System.out.print(item + " ");

            if (maxHeap.getSize() == 10) {
                if (maxHeap.getMax() > item) {
                    maxHeap.replace(item);
                }
            } else {
                maxHeap.add(item);
            }
        }
        System.out.println();
        maxHeap.printHeap();
    }
}
