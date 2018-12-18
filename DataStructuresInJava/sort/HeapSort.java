package com.z.sort;

import java.util.Random;

/**
 * @ClassName HeapSort
 * @Description heap sort
 *  1.堆排序包括建堆和排序两个操作，建堆过程的时间复杂度是 O(n),排序过程的时间复杂度是O(nlogn),
 *  所以堆排序的整体时间复杂度是O(nlogn)
 *  2.原地排序
 *  3.不稳定
 * @Author alex
 * @Date 2018/11/25
 **/
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] a) {
        int N = a.length - 1;
        for (int i = (N - 1) / 2; i >= 0; i--) {
            sink(a, i, N);
        }

        while (N > 0) {
            swap(a, 0, N--);
            sink(a, 0, N);
        }
    }

    private void sink(T[] a, int k, int N) {
        while ( 2 * k + 1 < N) {
            int max = 2 * k + 1;
            int right = 2 * k + 2;
            if (right < N && a[right].compareTo(a[max]) > 0) {
                max = right;
            }
            if (a[k].compareTo(a[max]) >= 0) {
                break;
            }
            swap(a, k, max);
            k = max;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 10;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(n);
            System.out.print(num + " ");
            a[i] = num;
        }
        System.out.println();

        HeapSort<Integer> heapSort = new HeapSort<Integer>();
        heapSort.sort(a);
        heapSort.printT(a);
    }
}
