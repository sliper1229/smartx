package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_10;

import java.util.Stack;

public class Problem_0084_LargestRectangleInHistogram {

	// 以每个数做为高度，往两边扩，找左右两边比当前高度小的位置
	// 单调栈
	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		// 只放下标
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			// 相等时也弹出
			while (!stack.isEmpty()
					&& height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}

	// TODO 单调栈解法

}
