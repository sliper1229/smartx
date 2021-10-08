package com.cc.smartx.algorithm.zuochengyun.stage01.class02.done;

import java.util.Arrays;

public class Code06_QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L < R) {
            //随机选一个位置, 跟最右侧做交换, 时间复杂读 N*logN
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);

            // 分区，分成大于区、等于区、小于区，固定等于区数据的位置
            int[] p = partition(arr, L, R);

            //递归
            process(arr, L, p[0]); // 小于区
            process(arr, p[1], R); // 大于区
        }
    }

    // arr[L, R], L R 都包含
    // 6, 3, 5, 7, 2, 4, 1
    // 小于区推着等于区往右走
    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1; //小于区的右边界
        int more = R; //大于区的左边界
        int index = L;

        // 当前位置不能和大于区域撞上
        while (index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, ++less, index++); // 这里必须交换，划分出等于区
            } else if (arr[index] > arr[R]) {
                swap(arr, --more, index); // 不能index++, 还需要和前面的比
            } else {
                index++;
            }

        }

        // 跟大于区的第一个数交换
        swap(arr, more++, R);

        return new int[]{less, more};
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process2(arr, 0, arr.length - 1);

    }

    private static void process2(int[] arr, int L, int R) {
        if (L < R) { // 终止条件
            //找划分点
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);

            int[] p = partition2(arr, L, R);

            process2(arr, L, p[0]); //小于区为右边界
            process2(arr, p[1], R); // 大于区为左边界
        }
    }

    // 荷兰国旗问题
    private static int[] partition2(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int index = l;

        while (index < more) {
            if (arr[index] < arr[r]) {
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[r]) { // 不能++
                swap(arr, --more, index);
            } else {
                index++;
            }
        }
        swap(arr, more++, r);
        return new int[]{less, more};
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println((arr[i]));
        }
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
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
            quickSort2(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort2(arr);
        printArray(arr);

    }


}
