package com.z.sort;

/**
 * @ClassName Sort
 * @Description sort
 * @Author alex
 * @Date 2018/11/25
 **/
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] a);

    boolean less(T t1, T t2) {
        return t1.compareTo(t2) < 0;
    }

    void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    void printT(T[] a) {
        for (T item : a) {
            System.out.print(item.toString() + " ");
        }
    }
}
