package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions;

public class Problem_0172_FactorialTrailingZeroes {

	public static int trailingZeroes(int n) {
		int ans = 0;
		while (n != 0) {
			n /= 5;
			ans += n;
		}
		return ans;
	}

}
