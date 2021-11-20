package com.cc.smartx.algorithm.practice.滑动窗口.滑动窗口最大值;

import java.util.LinkedList;

public class Code02_AllLessNumSubArray {

	// 暴力的对数器方法
	public static int right(int[] arr, int sum) {
		if (arr == null || arr.length == 0 || sum < 0) {
			return 0;
		}
		int N = arr.length;
		int count = 0;
		for (int L = 0; L < N; L++) {
			for (int R = L; R < N; R++) {
				int max = arr[L];
				int min = arr[L];
				for (int i = L + 1; i <= R; i++) {
					max = Math.max(max, arr[i]);
					min = Math.min(min, arr[i]);
				}
				if (max - min <= sum) {
					count++;
				}
			}
		}
		return count;
	}

	public static int num(int[] arr, int sum) {
		if (arr == null || arr.length == 0 || sum < 0) {
			return 0;
		}
		int N = arr.length;
		int count = 0;
		LinkedList<Integer> maxWindow = new LinkedList<>();
		LinkedList<Integer> minWindow = new LinkedList<>();
		int R = 0;

		// 两个重要的结论:
		// 1. [L......R]上满足，那么在[L......R]内部的[L'......R']都满足
		// [L......R]达标，内部必达标，怎么缩都达标
		// 2. [L......R]上不满足，那么在[L......R]不管往右扩，都时不达标的
		// [L......R]不达标，怎么扩都不达标

		// 从每一个位置作为开头，求个数
		for (int L = 0; L < N; L++) {

			while (R < N) {
				// 最大窗口 滑动窗口不为空，并且尾部小于当前值，尾部弹出
				while (!maxWindow.isEmpty() && arr[maxWindow.peekLast()] <= arr[R]) {
					maxWindow.pollLast();
				}
				maxWindow.addLast(R);

				//最小窗口
				while (!minWindow.isEmpty() && arr[minWindow.peekLast()] >= arr[R]) {
					minWindow.pollLast();
				}
				minWindow.addLast(R);

				//满足条件，一直往右扩，当不满足条件时，直接退出循环
				if (arr[maxWindow.peekFirst()] - arr[minWindow.peekFirst()] > sum) {
					break;
				} else {
					// R往右扩
					R++;
				}
			}

			count += R - L;
			if (maxWindow.peekFirst() == L) {
				maxWindow.pollFirst();
			}
			if (minWindow.peekFirst() == L) {
				minWindow.pollFirst();
			}
		}
		return count;
	}

	// for test
	public static int[] generateRandomArray(int maxLen, int maxValue) {
		int len = (int) (Math.random() * (maxLen + 1));
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int maxLen = 100;
		int maxValue = 200;
		int testTime = 100000;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxLen, maxValue);
			int sum = (int) (Math.random() * (maxValue + 1));
			int ans1 = right(arr, sum);
			int ans2 = num(arr, sum);
			if (ans1 != ans2) {
				System.out.println("Oops!");
				printArray(arr);
				System.out.println(sum);
				System.out.println(ans1);
				System.out.println(ans2);
				break;
			}
		}
		System.out.println("测试结束");

	}

}
