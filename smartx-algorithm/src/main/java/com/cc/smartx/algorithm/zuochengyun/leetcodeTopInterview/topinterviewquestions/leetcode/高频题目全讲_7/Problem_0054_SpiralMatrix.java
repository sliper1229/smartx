package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_7;

import java.util.ArrayList;
import java.util.List;

// 螺旋矩阵
public class Problem_0054_SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return ans;
		}
		// 左上角点 （a, b）
		int a = 0;
		int b = 0;
		// 右上角点 （c, d）
		int c = matrix.length - 1;
		int d = matrix[0].length - 1;
		// 0  0  0  0
		// 0  0  0  0
		// 0  0  0  0
		// 可能不是正方形
		// while循环，一圈圈打印
		while (a <= c && b <= d) {
			addEdge(matrix, a++, b++, c--, d--, ans);
		}
		return ans;
	}

	public static void addEdge(int[][] m, int a, int b, int c, int d, List<Integer> ans) {
		// 在一条横线上，直接添加进去
    	if (a == c) {
			for (int i = b; i <= d; i++) {
				ans.add(m[a][i]);
			}
		// 在一条竖线上，直接添加进去
		} else if (b == d) {
			for (int i = a; i <= c; i++) {
				ans.add(m[i][b]);
			}
		// 跟正方形一样
		} else {
			int curC = b;
			int curR = a;
			while (curC != d) {
				ans.add(m[a][curC]);
				curC++;
			}
			while (curR != c) {
				ans.add(m[curR][d]);
				curR++;
			}
			while (curC != b) {
				ans.add(m[c][curC]);
				curC--;
			}
			while (curR != a) {
				ans.add(m[curR][b]);
				curR--;
			}
		}
	}

}
