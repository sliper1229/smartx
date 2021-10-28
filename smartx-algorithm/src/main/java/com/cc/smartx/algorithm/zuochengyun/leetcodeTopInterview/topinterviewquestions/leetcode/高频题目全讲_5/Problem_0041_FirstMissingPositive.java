package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_5;

// 缺失的第一个正数
public class Problem_0041_FirstMissingPositive {

	// 荷兰过期问题
    public static int firstMissingPositive(int[] arr) {
		// [0...l-1]：[i] = i+1
		// [1...r]：最好的结果是r
		int l = 0;
		int r = arr.length;

		while (l < r) {
			// [l] = l + 1
			if (arr[l] == l + 1) {
				l++;
			// [l] > r
			// [l] <= l
			// l上的数应该去的位置已经躺好了
			} else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
				swap(arr,l,--r);
			// 让当前位置去改去的地方
			} else {
				swap(arr, l, arr[l] - 1);
			}
		}
		return l + 1;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
