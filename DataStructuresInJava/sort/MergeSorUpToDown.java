package com.z.sort;

import java.util.Random;

/**
 * @ClassName MergeSorUpToDown
 * @Description up to down merge sort
 * @Author alex
 * @Date 2018/11/25
 **/
public class MergeSorUpToDown<T extends Comparable<T>> extends Sort<T> {
    private T[] aux;
    @Override
    public void sort(T[] a) {
        aux = (T[]) new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(T[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private void merge(T[] a, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                //i > mid 左半边用尽（取右半边的元素）
                a[k] = aux[j++];
            } else if (j > high) {
                //j > high 右半边用尽（取左半边的元素）
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                //左半边的当前元素小于右半边的当前元素（取左半边的元素），稳定性
                a[k] = aux[i++];
            } else {
                //左半边的当前元素大于右半边的当前元素（取右半边的元素）
                a[k] = aux[j++];
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

        MergeSorUpToDown<Integer> mergeSorUpToDown = new MergeSorUpToDown<Integer>();
        mergeSorUpToDown.sort(a);
        mergeSorUpToDown.printT(a);
    }
}
