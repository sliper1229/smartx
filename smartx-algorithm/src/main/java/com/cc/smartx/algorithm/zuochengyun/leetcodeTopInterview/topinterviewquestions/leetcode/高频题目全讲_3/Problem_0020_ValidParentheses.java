package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_3;

import java.util.Stack;

public class Problem_0020_ValidParentheses {

	// 遇到左括号压栈，遇到右括号弹出
	// 只有小括号：count计数，遇到左括号++,遇到右括号--，整个过程count不能小于0，到最后count不为0
	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		char[] str = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length; i++) {
			char cha = str[i];
			if (cha == '(' || cha == '[' || cha == '{') {
				stack.add(cha == '(' ? ')' : (cha == '[' ? ']' : '}'));
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char last = stack.pop();
				if (cha != last) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
