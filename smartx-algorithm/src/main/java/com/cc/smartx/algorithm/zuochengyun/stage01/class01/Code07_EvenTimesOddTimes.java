package com.cc.smartx.algorithm.zuochengyun.stage01.class01;

/**
 * 异或
 */
public class Code07_EvenTimesOddTimes {

    /**
     * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
     * @param arr
     */
	public static void printOddTimesNum1(int[] arr) {
		int eor = 0;
		for (int cur : arr) {
			eor ^= cur;
		}
		System.out.println(eor);
	}

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数
     * @param arr
     */
	public static void printOddTimesNum2(int[] arr) {
		int eor = 0;
		for (int i = 0 ; i < arr.length;i++) {
			eor ^= arr[i];
		}
		// eor = a ^ b
		// eor != 0
		// eor必然有一个位置上是1
		int rightOne = eor & (~eor + 1); // 提取出最右的1
		int onlyOne = 0; // eor'
		for (int cur : arr) {
			if ((cur & rightOne) == 1) {
				onlyOne ^= cur;
			}
		}
		System.out.println(onlyOne + " " + (eor ^ onlyOne));
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 7;

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println(a);
		System.out.println(b);

		int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
		printOddTimesNum1(arr1);

		int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
		printOddTimesNum2(arr2);

	}

}
