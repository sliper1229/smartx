package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_9;

public class Problem_0076_MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		char[] str = s.toCharArray();
		char[] target = t.toCharArray();
		// 欠账表
		int[] map = new int[256];
		for (char cha : target) {
			map[cha]++;
		}
		// 总的欠账数量
		int all = target.length;
		// 子串以L开头，至少需要多长，才能覆盖t
		// L、R，如果R在右移的过程中，不欠款了，让L移动，如果L移动欠款，让R继续移动
		// 先扩再缩
		// 表示窗口，左闭右开，[L..R)  [0,0)
		int L = 0;
		int R = 0;
		// -1(从来没找到过合法的)
		// 记录下最小长度的左右下标
		int minLen = -1;
		int ansl = -1;
		int ansr = -1;

		while (R != str.length) {
			map[str[R]]--;
			if (map[str[R]] >= 0) {
				all--;
			}
			if (all == 0) {
				// 不欠账，让L向右移动
				while (map[str[L]] < 0) {
					map[str[L++]]++;
				}
				// 更新更小的
				if (minLen == -1 || minLen > R - L + 1) {
					minLen = R - L + 1;
					ansl = L;
					ansr = R;
				}
				all++;		
				map[str[L++]]++;
			}
			R++;
		}
		return minLen == -1 ? "" : s.substring(ansl, ansr + 1);
	}

}
