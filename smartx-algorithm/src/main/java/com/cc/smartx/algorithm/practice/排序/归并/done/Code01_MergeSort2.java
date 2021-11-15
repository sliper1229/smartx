package com.cc.smartx.algorithm.practice.排序.归并.done;

/**
 * @description:
 * @Author chenlipeng
 * @Date 2020-12-20
 */
public class Code01_MergeSort2 {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L.....R]上有序
    // arr[L.....M]上有序，arr[M+1.....R]上有序，将两个有序的部分合并
    public static void process(int[] arr, int L, int R) {
        // base case：只剩下一个元素，直接返回
        if (L == R) {
            return;
        }
        // 先拆分到最细
        int M = L + (R - L) / 2;
        //  arr[L.....M]上有序
        process(arr, L, M);
        // arr[M+1.....R]上有序
        process(arr, M + 1, R);
        // 将两个有序的部分合并
        merge(arr, L, M, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
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
