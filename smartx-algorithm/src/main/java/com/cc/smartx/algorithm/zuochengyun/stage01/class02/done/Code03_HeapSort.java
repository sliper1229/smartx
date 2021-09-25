package com.cc.smartx.algorithm.zuochengyun.stage01.class02.done;

public class Code03_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //1.构建大根堆heapUp.
        for (int i = 0; i < arr.length; i++) {
            heapUp(arr, i);
        }

        //2.heapDown.
        int heapSize = arr.length;
        for (int i = 0; i < arr.length; i++) {
            heapSize--;
            swap(arr, 0, heapSize);
            heapDown(arr, 0, heapSize);
        }

    }

    private static void heapDown(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) { //只要有左孩子，一直比较下去
            int larger =
                    // 有右孩子，并且比做孩子大，取大孩子
                    left + 1 < heapSize && arr[left + 1] > arr[left]
                            ? left + 1 : left;
            if (arr[index] >= arr[larger]) {
                break;
            }
            swap(arr, index, larger);
            index = larger;
            left = 2 * index + 1;
        }
    }

    private static void heapUp(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6};
        heapSort(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print((arr[i]) + " ");
        }
    }


}
