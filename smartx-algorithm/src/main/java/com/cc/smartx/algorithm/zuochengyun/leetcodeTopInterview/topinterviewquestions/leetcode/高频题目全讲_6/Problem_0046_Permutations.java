package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem_0046_Permutations {

	public static List<List<Integer>> onClass(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		HashSet<Integer> rest = new HashSet<>();
		for (int num : nums) {
			rest.add(num);
		}
		ArrayList<Integer> path = new ArrayList<>();
		f(rest, path, ans);
		return ans;
	}

	// rest中有剩余数字，已经选过的数字不在rest中，选过的数字在path里
	public static void f(HashSet<Integer> rest, ArrayList<Integer> path, List<List<Integer>> ans) {
		if (rest.isEmpty()) {
			ans.add(path);
		} else {
			for (int num : rest) {
				ArrayList<Integer> curPath = new ArrayList<>(path);
				curPath.add(num);
				HashSet<Integer> clone = cloneExceptNum(rest, num);
				f(clone, curPath, ans);
			}
		}
	}

	public static HashSet<Integer> cloneExceptNum(HashSet<Integer> rest, int num) {
		HashSet<Integer> clone = new HashSet<>(rest);
		clone.remove(num);
		return clone;
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		process(nums, 0, ans);
		return ans;
	}

	// 在[index.....]做好决定, 结果放在ans里
	public static void process(int[] nums, int index, List<List<Integer>> ans) {
		if (index == nums.length) {
			ArrayList<Integer> cur = new ArrayList<>();
			for (int num : nums) {
				cur.add(num);
			}
			ans.add(cur);
		} else {
			// index位置一次跟index及后面的位置进行交换
			for (int j = index; j < nums.length; j++) {
				HashSet<Integer> set = new HashSet();
				if (!set.contains(nums[j])) {
					set.add(nums[j]);
					// index位置做决定：index位置跟index及后面的位置进行交换
					swap(nums, index, j);
					// index+1位置做决定
					process(nums, index + 1, ans);
					// 恢复现场
					swap(nums, index, j);
				}
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
