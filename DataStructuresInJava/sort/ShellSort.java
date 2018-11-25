package com.z.sort;

import java.util.Random;

/**
 * @ClassName ShellSort
 * @Description shell sort
 * @Author alex
 * @Date 2018/11/25
 **/
public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] a) {
        int length = a.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h = h / 3;
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

        ShellSort<Integer> shellSort = new ShellSort<Integer>();
        shellSort.sort(a);
        shellSort.printT(a);
    }
}
