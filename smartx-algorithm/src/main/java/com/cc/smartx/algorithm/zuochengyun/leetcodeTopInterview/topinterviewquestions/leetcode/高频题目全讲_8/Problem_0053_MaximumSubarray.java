package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_8;

public class Problem_0053_MaximumSubarray {

	// 最大子序和
	public static int maxSum(int[] nums) {
		int N = nums.length;
		// dp[i] 含义：子数组必须以i结尾的时候，所有可以得到的子数组中，最大累加和是多少？
		int[] dp = new int[N];
		dp[0] = nums[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < N; i++) {
			// 列举可能性
			// 子数组以i结尾，但是只包含i
			int p1 = nums[i];
			// 子数组以i结尾，但是值包含i [......i-1] + nums[i]
			int p2 = nums[i] + dp[i - 1];
			dp[i] = Math.max(p1, p2);
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static int maxSubArray(int[] nums) {
		int cur = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			cur += nums[i];
			max = Math.max(max, cur);
			cur = cur < 0 ? 0 : cur;
		}
		return max;
	}

	// 选组合，不能同时选相邻的数，哪个组合累加和最大
	public static int maxSum2(int[] arr) {
		if (arr == null) {
			return 0;
		}
		int N = arr.length;
		if (N == 0) {
			return 0;
		}
		if (N == 1) {
			return arr[0];
		}
		if (N == 2) {
			return Math.max(arr[0], arr[1]);
		}
		// N > 2
		// dp[i] 含义：[0.....i]所有可能性的最优，所以最大累加和肯定是最后N-1位置，不要求必须以i结尾
		int[] dp = new int[N];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < N; i++) {
			// 只含i
			int p1 = arr[i];
			// 不含i
			int p2 = dp[i - 1];
			// 选i，不选i-1，选i-2
			int p3 = arr[i] + dp[i - 2];
			dp[i] = Math.max(Math.max(p1, p2), p3);
		}
		//
		return dp[N-1];
	}

}
