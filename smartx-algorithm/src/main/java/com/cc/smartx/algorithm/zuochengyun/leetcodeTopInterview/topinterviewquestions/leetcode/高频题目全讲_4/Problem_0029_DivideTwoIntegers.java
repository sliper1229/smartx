package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_4;

public class Problem_0029_DivideTwoIntegers {

	// 两数相加 = 无进位相加信息 + 进位信息，直到进位信息为0
	// 无进位相加信息 = a和b异或，a ^ b
	// 进位信息 = a与上b左移一位，(a & b) << 1
	public static int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}

	// 取相反数
	public static int negNum(int n) {
		return add(~n, 1);
	}

	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}

	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				res = add(res, a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
	}

	public static boolean isNeg(int n) {
		return n < 0;
	}

	// 除数左移至最接近被除数，又不超过被除数
	public static int div(int a, int b) {
		int x = isNeg(a) ? negNum(a) : a;
		int y = isNeg(b) ? negNum(b) : b;
		int res = 0;
		for (int i = 31; i > negNum(1); i = minus(i, 1)) {
			if ((x >> i) >= y) {
				res |= (1 << i);
				x = minus(x, y << i);
			}
		}
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}

	public static int divide(int dividend, int divisor) {
		// 除数是系统最小
		if (divisor == Integer.MIN_VALUE) {
			return dividend == Integer.MIN_VALUE ? 1 : 0;
		}
		// 除数不是系统最小，被除数是系统最小
		if (dividend == Integer.MIN_VALUE) {
			// 溢出
			if (divisor == negNum(1)) {
				return Integer.MAX_VALUE;
			}
			// 最小加1相除
			int res = div(add(dividend, 1), divisor);
			// 补偿 最小加1 / 除数 + (被除数 - 最小加1相除) / 除数
			return add(res, div(minus(dividend, multi(res, divisor)), divisor));
		}
		// dividend不是系统最小，divisor也不是系统最小
		return div(dividend, divisor);
	}
	// div(a,b) a和b都不能是系统最小

	// 现场福利函数
	public static String printNumBinary(int num) {
		StringBuilder builder = new StringBuilder();
		for (int i = 31; i >= 0; i--) {
			builder.append(((num >> i) & 1) == 0 ? '0' : '1');
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		int num = -1;
		System.out.println(printNumBinary(num));
	}

}
