package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_7;

public class Problem_0050_PowXN {

	public static double myPow1(double x, int n) {
		if (n == 0) {
			return 1D;
		}

		// 负的转成正的时，系统最小值的绝对值是自己
		if (n == Integer.MIN_VALUE) {
			return (x == 1D || x == -1D) ? 1D : 0;
		}

		// 负的转成正的
		int pow = Math.abs(n);

		// a的75次方 75=1001011
		// a^75 = a^1 * a^2 * a^8 * a^64

		double t = x;
		double ans = 1D;
		while (pow != 0) {
			// pow当前二进制为不为0
			if ((pow & 1) != 0) {
				ans *= t;
			}
			pow >>= 1;
			t = t * t;
		}
		return n < 0 ? (1D / ans) : ans;
	}

	public static double myPow2(double x, int n) {
		if (n == 0) {
			return 1D;
		}
		// 系统最小处理
		int pow = Math.abs(n == Integer.MIN_VALUE ? n + 1 : n);
		double t = x;
		double ans = 1D;
		while (pow != 0) {
			if ((pow & 1) != 0) {
				ans *= t;
			}
			pow >>= 1;
			t = t * t;
		}
		// 系统最小处理
		if (n == Integer.MIN_VALUE) {
			ans *= x;
		}
		return n < 0 ? (1D / ans) : ans;
	}

	public static void main(String[] args) {
		System.out.println("world shut up!");
		int a = Integer.MIN_VALUE;
		int b = -a;
		System.out.println(b);

		System.out.println("==============");

		double test = 1.00000001D;
		int N = Integer.MIN_VALUE;
		System.out.println(test == 1D);
		System.out.println(test + "的" + N + "次方，结果：");
		System.out.println(Math.pow(test, (double) N));
		System.out.println(myPow1(test, N));
		System.out.println(myPow2(test, N));
	}

}
