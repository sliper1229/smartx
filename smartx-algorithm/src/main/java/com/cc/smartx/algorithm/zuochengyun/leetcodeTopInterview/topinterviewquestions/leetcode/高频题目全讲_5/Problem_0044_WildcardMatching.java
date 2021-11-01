package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_5;

public class Problem_0044_WildcardMatching {

	public static boolean isMatch1(String str, String pattern) {
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		return process1(s, p, 0, 0);
	}

	// ? : 可以替换成任意单一小写字母，不能空字符
	// * ： 可以代替任意字符串，可以使空字符串

	// 递归含义：s[si....] 能否被 p[pi....] 匹配出来
	// ===>>> si位置能被匹配出来 + s[si+1....] 能否被 p[pi+1....] 匹配出来
	// 先搞定边界（base case），再搞定当前位置，当前位置的下一个位置自己玩递归

	// 斜率优化
	public static boolean process1(char[] s, char[] p, int si, int pi) {
		// si结束
		if (si == s.length) { // s -> ""
			// 空串匹配空串
			if (pi == p.length) { // p -> ""
				return true;
			} else {
				// p -> "..."
				// p[pi] == '*' && p[pi+1...] -> ""
				return p[pi] == '*' && process1(s, p, si, pi + 1);
			}
		}
		// pi结束
		if (pi == p.length) { // p -> "" s
			return si == s.length;
		}

		// s从si出发.... p从pi出发...
		// s[si] -> 小写字母
		// p[pi] -> 小写、?、*
		if (p[pi] != '?' && p[pi] != '*') {
			return s[si] == p[pi] && process1(s, p, si + 1, pi + 1);
		}
		// si.. pi.. pi ? *
		if (p[pi] == '?') {
			return process1(s, p, si + 1, pi + 1);
		}
		for (int len = 0; len <= s.length - si; len++) {
			if (process1(s, p, si + len, pi + 1)) {
				return true;
			}
		}
		return false;
	}

	// 斜率优化：观察临近的格子，能不能枚举行为替代掉
	public static boolean isMatch2(String str, String pattern) {
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		int N = s.length;
		int M = p.length;
		boolean[][] dp = new boolean[N + 1][M + 1];
		dp[N][M] = true;
		for (int pi = M - 1; pi >= 0; pi--) {
			dp[N][pi] = p[pi] == '*' && dp[N][pi + 1];
		}
		for (int si = N - 1; si >= 0; si--) {
			for (int pi = M - 1; pi >= 0; pi--) {
				if (p[pi] != '?' && p[pi] != '*') {
					dp[si][pi] = s[si] == p[pi] && dp[si + 1][pi + 1];
					// continue
					continue;
				}
				if (p[pi] == '?') {
					dp[si][pi] = dp[si + 1][pi + 1];
					// continue
					continue;
				}
				// p[pi] == '*'
				dp[si][pi] = dp[si][pi + 1] || dp[si + 1][pi];
			}
		}
		return dp[0][0];
	}

	// 最终做的化简
	public static boolean isMatch3(String str, String pattern) {
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		int N = s.length;
		int M = p.length;
		boolean[][] dp = new boolean[N + 1][M + 1];
		dp[N][M] = true;
		for (int pi = M - 1; pi >= 0; pi--) {
			dp[N][pi] = p[pi] == '*' && dp[N][pi + 1];
		}
		for (int si = N - 1; si >= 0; si--) {
			for (int pi = M - 1; pi >= 0; pi--) {
				if (p[pi] != '*') {
					dp[si][pi] = (p[pi] == '?' || s[si] == p[pi]) && dp[si + 1][pi + 1];
				} else {
					dp[si][pi] = dp[si][pi + 1] || dp[si + 1][pi];
				}
			}
		}
		return dp[0][0];
	}

}
