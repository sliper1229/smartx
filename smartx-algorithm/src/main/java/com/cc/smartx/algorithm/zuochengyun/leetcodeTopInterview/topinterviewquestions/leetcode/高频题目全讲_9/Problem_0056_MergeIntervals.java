package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Problem_0056_MergeIntervals {

	public static class Range {
		public int start;
		public int end;

		public Range(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static class RangeComparator implements Comparator<Range> {

		@Override
		public int compare(Range o1, Range o2) {
			return o1.start - o2.start;
		}

	}

	// intervals  N * 2
	public static int[][] merge(int[][] intervals) {
		if (intervals.length == 0) {
			return new int[0][0];
		}
		Range[] arr = new Range[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			arr[i] = new Range(intervals[i][0], intervals[i][1]);
		}
		// 按照开始位置进行排序
		Arrays.sort(arr, new RangeComparator());
		ArrayList<Range> ans = new ArrayList<>();
		int s = arr[0].start;
		int e = arr[0].end;
		for (int i = 1; i < arr.length; i++) {
			// 只有当前的start大于前面的的e，才将区间放到结果中
			if (arr[i].start > e) {
				ans.add(new Range(s, e));
				s = arr[i].start;
				e = arr[i].end;
			// 否则，一直更新s和e
			} else {
				e = Math.max(e, arr[i].end);
			}
		}
		// 最终将s和e形成的区间放到结果集中
		ans.add(new Range(s, e));
		return generateMatrix(ans);
	}

	public static int[][] generateMatrix(ArrayList<Range> list) {
		int[][] matrix = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			matrix[i] = new int[] { list.get(i).start, list.get(i).end };
		}
		return matrix;
	}

}
