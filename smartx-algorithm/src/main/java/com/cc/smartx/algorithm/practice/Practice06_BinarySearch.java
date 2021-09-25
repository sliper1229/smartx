package com.cc.smartx.algorithm.practice;

public class Practice06_BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 4, 4, 4, 5, 6, 7};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 3));
        System.out.println(binarySearch2(arr, 0, arr.length - 1, 3));
        System.out.println(binarySearch3(arr, 0, arr.length - 1, 100));
    }

    /**
     * 在arr[0..R]范围上，找满足=value的位置
     */
    public static Integer binarySearch(int[] arr, int L, int R, int value) {
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] > value) {
                R = mid - 1;
            } else if (arr[mid] < value) {
                L = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 在arr[0..R]范围上，找满足=value的最左位置
     */
    public static Integer binarySearch2(int[] arr, int L, int R, int value) {
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] > value) {
                R = mid - 1;
            } else if (arr[mid] < value) {
                L = mid + 1;
            } else {
                index = mid; // 记住上一个位置
                R = mid - 1;
            }
        }
        return index;
    }

    /**
     * 在arr[0..R]范围上，找满足>=value的最左位置
     */
    public static Integer binarySearch3(int[] arr, int L, int R, int value) {
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid; // 记住上一个位置
                R = mid - 1;
            } else if (arr[mid] < value) {
                L = mid + 1;
            }
        }
        return index;
    }

}
