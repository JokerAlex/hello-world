package com.z.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @ClassName QuickSort
 * @Description quick sort
 * @Author alex
 * @Date 2018/11/25
 **/
public class QuickSort<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(T[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private void shuffle(T[] a) {
        List<T> list = Arrays.asList(a);
        Collections.shuffle(list);
        list.toArray(a);
    }

    private int partition(T[] a, int low, int high) {
        int i = low, j = high + 1;
        T v = a[low];
        while (true) {
            while (less(a[++i], v) && i != high) ;
            while (less(v, a[--j]) && j != low) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
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

        QuickSort<Integer> quickSort = new QuickSort<Integer>();
        quickSort.sort(a);
        quickSort.printT(a);
    }
}
