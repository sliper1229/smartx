package com.cc.smartx.algorithm.practice.排序.归并.done;

/**
 * @description:
 * @Author chenlipeng
 * @Date 2020-12-20
 */
public class Code01_MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);

    }

    //process(arr, 0, 1)
    //process(arr, 0, 0);
    //process(arr, 1, 1);
    private static void process(int[] arr, int L, int R) {
        //递归终止条件.
        if (L == R) { // 只剩一个元素
            return;
        }
        //先拆分到最细.
        int M = L + (R - L) / 2;
        process(arr, L, M);
        process(arr, M + 1, R);
        //合并[排].
        merge(arr, L, M, R);
    }

    // [L M]    [M+1 R]
    // 1 3 7   2 4 6
    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1]; // 外排序 额外空间复杂度 O(N)
        int i = 0;

        int p1 = L; // [L M]
        int p2 = M + 1; // [M+1 R]

        // 谁小谁移动
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        // 拷贝回原数组
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
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
