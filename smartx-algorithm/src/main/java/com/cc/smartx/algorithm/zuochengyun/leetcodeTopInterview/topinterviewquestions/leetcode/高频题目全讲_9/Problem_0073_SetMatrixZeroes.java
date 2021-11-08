package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_9;

public class Problem_0073_SetMatrixZeroes {

	public static void setZeroes1(int[][] matrix) {
		// 第一行原本是否有0
		boolean row0Zero = false;
		// 第一列原本是否有0
		boolean col0Zero = false;
		int i = 0;
		int j = 0;
		for (i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				row0Zero = true;
				break;
			}
		}
		for (i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				col0Zero = true;
				break;
			}
		}
		for (i = 1; i < matrix.length; i++) {
			for (j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (i = 1; i < matrix.length; i++) {
			for (j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		// 如果第一行原本有0，将第一行全部设为0
		if (row0Zero) {
			for (i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
		// 如果第一列原本有0，将第一列全部设为0
		if (col0Zero) {
			for (i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void setZeroes2(int[][] matrix) {
		boolean col0 = false;
		int i = 0;
		int j = 0;
		for (i = 0; i < matrix.length; i++) {
			for (j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					if (j == 0) {
						col0 = true;
					} else {
						matrix[0][j] = 0;
					}
				}
			}
		}
		for (i = matrix.length - 1; i >= 0; i--) {
			for (j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (col0) {
			for (i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

}
