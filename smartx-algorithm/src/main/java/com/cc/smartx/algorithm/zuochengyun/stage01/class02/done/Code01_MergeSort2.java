package com.cc.smartx.algorithm.zuochengyun.stage01.class02.done;

/**
 * @description:
 * @Author chenlipeng
 * @Date 2020-12-20
 */
public class Code01_MergeSort2 {

    private static void mergeSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // 把arr在[L...R]上排有序
    private static void process(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int M = L + (R - L) / 2;
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l +1];

        int p1 = 0, p2 = m + 1, i = 0;

        while(p1 <= l && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= l) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // 拷贝回原数组
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6};
        mergeSort(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println((arr[i]));
        }
    }
}
