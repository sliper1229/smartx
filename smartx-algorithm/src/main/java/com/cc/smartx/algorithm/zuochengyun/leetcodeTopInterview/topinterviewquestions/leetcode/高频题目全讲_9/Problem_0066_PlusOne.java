package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_9;

public class Problem_0066_PlusOne {

	public static int[] plusOne(int[] digits) {
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		// 所有位上都是9，加一之后位数增加一位，最高位为1，其他位都是0
		int[] ans = new int[n + 1];
		ans[0] = 1;
		return ans;
	}

}
