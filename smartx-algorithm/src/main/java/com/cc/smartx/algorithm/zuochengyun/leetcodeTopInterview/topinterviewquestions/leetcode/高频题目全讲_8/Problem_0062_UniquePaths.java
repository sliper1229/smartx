package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_8;

public class Problem_0062_UniquePaths {

	public static int uniquePaths(int m, int n) {
		int part = n - 1;
		// 需要走的总步数
		int all = m + n - 2;
		long o1 = 1;
		long o2 = 1;

		// C(9,3) = 9的阶乘 / 3的阶乘 /（9-3）的阶乘
		// all = 9 part = 9 - 3 = 6
		// part + 1 = 7.......9
		// all - part = 1.......3
		// 7.......9 / 1.......3
		for (int i = part + 1, j = 1; i <= all || j <= all - part; i++, j++) {
			o1 *= i;
			o2 *= j;
			// 求最大公约数
			long gcd = gcd(o1,o2);
			o1 /= gcd;
			o2 /= gcd;
		}
		return (int)o1;
	}
	
	// 调用的时候，请保证初次调用时，m和n都不为0
	// 转转相除法
	public static long gcd(long m, long n) {
		return n == 0 ? m : gcd(n, m % n);
	}

}
