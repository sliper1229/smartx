package com.cc.smartx.algorithm.zuochengyun.leetcodeTopInterview.topinterviewquestions.leetcode.高频题目全讲_3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_0023_MergeKSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        // 把所有的节点加入到小根堆里
        for (ListNode listNode : lists) {
        	if (listNode != null) {
				heap.add(listNode);
			}
        }
        // 创建一个dummy节点 or 先从堆里面弹出一个节点，确定头节点
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        // 堆不为空
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            p.next = min;
            p = p.next;
            if (min.next != null) {
                heap.add(min.next);
            }
        }
        return dummy.next;
    }

}
