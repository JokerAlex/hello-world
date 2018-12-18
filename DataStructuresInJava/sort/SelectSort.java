package com.z.sort;

import java.util.Random;

/**
 * @ClassName SelectSort
 * @Description select sort
 *  1.最好时间复杂度O(n^2),最坏时间复杂度O(n^2),平均时间复杂度O(n^2).
 *  2.原地排序
 *  3.不稳定
 * @Author alex
 * @Date 2018/11/25
 **/
public class SelectSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
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

        SelectSort<Integer> selectSort = new SelectSort<Integer>();
        selectSort.sort(a);
        selectSort.printT(a);
    }
}
