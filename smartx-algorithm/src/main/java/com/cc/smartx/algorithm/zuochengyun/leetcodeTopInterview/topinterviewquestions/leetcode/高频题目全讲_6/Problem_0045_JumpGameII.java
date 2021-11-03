package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_6;

public class Problem_0045_JumpGameII {

	public static int jump(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		// 当前最少跳几步能到i位置
		int step = 0;
		// 跳的步数不超过step步最右能到哪
		int cur = 0;
		// 跳的步数不超过 step+1 步最右能到哪
		int next = arr[0];

		// 3 2 1 4 2 1 0 3 1 2
		// step内只能到cur，下一步最多跳next

		// i <= cur，step步内能到i，此时判断一下next能不能更大
		// i > cur，当前位置不足以到i，step++，cur=next

		for (int i = 1; i < arr.length; i++) {
//            if(next >= arr.length - 1){
//                return step + 1;
//            }
			if (cur < i) {
				step++;
				cur = next;
			}
			next = Math.max(next, i + arr[i]);
		}
		return step;
	}

}
