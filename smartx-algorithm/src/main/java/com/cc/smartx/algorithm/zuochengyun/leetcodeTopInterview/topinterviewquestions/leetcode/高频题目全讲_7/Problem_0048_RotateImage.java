package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_7;

public class Problem_0048_RotateImage {

	public static void rotate(int[][] matrix) {
		// 左上角
		int tR = 0;
		int tC = 0;
		// 右上角
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		// 从外圈转到内圈
		while (tR < dR) {
			rotateEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		int times = dC - tC;
		int tmp = 0;
		for (int i = 0; i != times; i++) { 
			tmp = m[tR][tC + i];
			m[tR][tC + i] = m[dR - i][tC];
			m[dR - i][tC] = m[dR][dC - i];
			m[dR][dC - i] = m[tR + i][dC];
			m[tR + i][dC] = tmp;
		}
	}

}
