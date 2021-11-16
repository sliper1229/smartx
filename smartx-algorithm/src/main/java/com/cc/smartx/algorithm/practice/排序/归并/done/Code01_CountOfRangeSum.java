package com.cc.smartx.algorithm.practice.排序.归并.done;

/**
 * 1、将原数组转化成前缀和数组
 * 2、原[lower，upper] -> 前缀和X 转换成求[x-upper, x-lower]
 * 3、sum[]X之前有多少个在[x-upper, x-lower]之间
 * 4、改归并排序merge过程
 */
// 这道题直接在leetcode测评：
// https://leetcode.com/problems/count-of-range-sum/
public class Code01_CountOfRangeSum {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 原数组转换为前缀和数组
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        return process(sum, 0, nums.length - 1, lower, upper);
    }

    private static int process(long[] sum, int L, int R, int lower, int upper) {
        if (L == R) {
            return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
        }
        int M = L + (R - L) / 2;
        return process(sum, L, M, lower, upper)
                + process(sum, M + 1, R, lower, upper)
                + merge(sum, L, M, R, lower, upper);

    }

    private static int merge(long[] sum, int l, int m, int r, int lower, int upper) {
        return 0;
    }

}
