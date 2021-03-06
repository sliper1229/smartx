package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_6;

public class Problem_0055_JumpGame {

	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length < 2) {
			return true;
		}
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// 主要当前位置大于max，返回false
			if (i > max) {
				return false;
			}
			max = Math.max(max, i + nums[i]);
		}
		return true;
	}

}
