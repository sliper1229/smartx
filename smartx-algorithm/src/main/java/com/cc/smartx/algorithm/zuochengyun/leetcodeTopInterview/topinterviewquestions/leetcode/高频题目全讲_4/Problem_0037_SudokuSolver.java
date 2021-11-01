package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_4;

public class Problem_0037_SudokuSolver {

	public static void solveSudoku(char[][] board) {
		boolean[][] row = new boolean[9][10];
		boolean[][] col = new boolean[9][10];
		boolean[][] bucket = new boolean[9][10];
		initMaps(board, row, col, bucket);
		process(board, 0, 0, row, col, bucket);
	}

	public static void initMaps(char[][] board, boolean[][] row, boolean[][] col, boolean[][] bucket) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int bid = 3 * (i / 3) + (j / 3);
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					row[i][num] = true;
					col[j][num] = true;
					bucket[bid][num] = true;
				}
			}
		}
	}

	// 尽量减枝
	public static boolean process(char[][] board, int i, int j,
								  // 三个限制，带着递归一起玩，多余路不走
								  boolean[][] row, boolean[][] col, boolean[][] bucket) {
		// 0 ~ 8九行，i == 9 表示已经填完了
		if (i == 9) {
			return true;
		}
		// 如果到了最后一列，行数增加
		int nexti = j != 8 ? i : i + 1;
		// 如果没到最后一列，列数增加，如果到最后一列，列数变成0
		int nextj = j != 8 ? j + 1 : 0;

		if (board[i][j] != '.') {
			// 如果不能自由发挥，去下个位置填
			return process(board, nexti, nextj, row, col, bucket);
		} else {
			int bid = 3 * (i / 3) + (j / 3);
			// num 从 1 ~ 9 在当前行、当前列和当前格子上尝试
			for (int num = 1; num <= 9; num++) {
				if ((!row[i][num]) && (!col[j][num]) && (!bucket[bid][num])) {
					// 1、必须把当前位置位置填好了
					row[i][num] = true;
					col[j][num] = true;
					bucket[bid][num] = true;
					board[i][j] = (char) (num + '0');

					// 2、且下一个位置填好了
					if (process(board, nexti, nextj, row, col, bucket)) {
						return true;
					}

					// 3、深度优先遍历，恢复现场一定要做好
					row[i][num] = false;
					col[j][num] = false;
					bucket[bid][num] = false;
					board[i][j] = '.';
				}
			}
			return false;
		}
	}

}
