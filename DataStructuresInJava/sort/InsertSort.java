package com.z.sort;

import java.util.Random;

/**
 * @ClassName InsertSort
 * @Description insert sort
 *  1.最好时间复杂度O(n),最坏时间复杂度O(n^2),平均时间复杂度O(n^2).
 *  2.原地排序
 *  3.稳定
 * @Author alex
 * @Date 2018/11/25
 **/
public class InsertSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 50;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(n);
            System.out.print(num + " ");
            a[i] = num;
        }
        System.out.println();

        InsertSort<Integer> insertSort = new InsertSort<Integer>();
        insertSort.sort(a);
        insertSort.printT(a);
    }
}
