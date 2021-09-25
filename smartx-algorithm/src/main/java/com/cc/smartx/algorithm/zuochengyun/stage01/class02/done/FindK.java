package com.cc.smartx.algorithm.zuochengyun.stage01.class02.done;

/**
 * @description:
 * @Author chenlipeng
 * @Date 2021-01-15
 */
public class FindK {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 13, 16, 20};
        int[] arr2 = new int[]{2, 8, 12, 27};
        int k = findK(arr1, arr2, 7);
        System.out.println(k);
    }


    public static int findK(int[] arr1, int[] arr2, int k) {

        int p1 = 0;
        int p2 = 0;
        int temp = 0;
        int count = 0;

        // 谁小谁移动
        while (p1 < arr1.length && p2 < arr2.length) {
            temp = arr1[p1] < arr2[p2] ? arr1[p1++] : arr2[p2++];
            count++;
            if (count == k) {
                return temp;
            }
        }

        if (p1 < arr1.length) {
            return arr1[k - arr2.length];
        }

        if (p2 < arr2.length) {
            return arr2[k - arr1.length];
        }

        return 0;

    }


}
