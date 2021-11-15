package com.cc.smartx.algorithm.practice.排序.快排.done;

import static com.cc.smartx.algorithm.practice.排序.归并.done.Code01_MergeSort2.mergeSort;

public class Code06_QuickSort2 {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // 递归含义：让arr[L......R]上每个数都归位
    // ===》 让某一个数归位，让左侧区域归位，让右侧区域归位
    private static void process(int[] arr, int L, int R) {
       if (L < R) {
           // 选取某个数，让它归位
           swap(arr, R, L + (int) (Math.random() * (R - L + 1)));
           int[] p = partition(arr, L, R);
           // 左侧每个数归位
           process(arr, L, p[0]);
           // 右侧每个数归位
           process(arr, p[1], R);
       }
    }

    private static int[] partition(int[] arr, int L, int R) {
        // 小于区的有边界
        int less = -1;
        // 大于区的左边界
        int more = R;
        int index = 0;

        while (index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --more, index);
            } else {
                index++;
            }
        }
        swap(arr, more++, R);
        return new int[]{less, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            mergeSort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");

    }

}
