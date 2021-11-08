package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_10;

public class Problem_0079_WordSearch {

	public static boolean exist(char[][] board, String word) {
		char[] w = word.toCharArray();
		// 以任何一个点出发，如果能走出路径，则返回true
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (process(board, i, j, w, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	// 目前到达了b[i][j]，word[k....]
	// 从b[i][j]出发，能不能搞定word[k....]  true  false
	public static boolean process(char[][] b, int i, int j, char[] w, int k) {
        if(k == w.length) {
			return true;
		}
        // k 有字符
		if (i < 0 || i == b.length || j < 0 || j == b[0].length) {
			return false;
		}
		if (b[i][j] != w[k]) {
			return false;
		}
		char tmp = b[i][j];
		// 不走回头路
		// 深度优先遍历，增加现场
		b[i][j] = 0;
		boolean ans =  process(b, i - 1, j, w, k + 1) 
				|| process(b, i + 1, j, w, k + 1) 
				|| process(b, i, j - 1, w, k + 1)
				|| process(b, i, j + 1, w, k + 1);
		b[i][j] = tmp;
		return ans;
	}

}
