package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_3;

public class Problem_0019_RemoveNthNodeFromEndofList {

	public static class ListNode {
		public int val;
		public ListNode next;
	}

	// 删掉的有可能是头
	// 双指针
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur = head;
		ListNode pre = null;
		while (cur != null) {
			n--;
			if (n == -1) {
				pre = head;
			}
			if (n < -1) {
				pre = pre.next;
			}
			cur = cur.next;
		}
		// 不够删
		if (n > 0) {
			return head;
		}
		// 删除头节点
		if (pre == null) {
			return head.next;
		}
		// 删除的不是头节点
		pre.next = pre.next.next;
		return head;
	}

}
