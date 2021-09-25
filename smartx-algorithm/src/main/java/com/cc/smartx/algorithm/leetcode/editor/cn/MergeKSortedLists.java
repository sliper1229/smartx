//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1113 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        // 解法一: 一个个合并 O(k*n) O(1)
        public ListNode mergeKLists2(ListNode[] lists) {
            ListNode result = null;
            for (int i = 0; i < lists.length; i++) {
                result = mergeTwolist(result, lists[i]);
            }
            return result;
        }

        // 解法二: 使用小根堆 O(n*logk) O(logk)
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
                    (n1, n2) -> n1.val - n2.val);
            for (ListNode listNode : lists) {
                if (listNode != null) {
                    queue.add(listNode);
                }
            }

            ListNode dummy = new ListNode(0), p = dummy;

            while (!queue.isEmpty()) {
                ListNode min = queue.poll();
                p.next = min;
                p = p.next;
                if (min.next != null) {
                    queue.add(min.next);
                }
            }
            return dummy.next;
        }

        // 解法三: 归并思想  O(n*log(k)) O(log(k))
        public ListNode mergeKLists3(ListNode[] lists) {
            return process(lists, 0, lists.length - 1);
        }

        public ListNode process(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }

            int mid = left + (right - left) / 2;

            ListNode leftNode = process(lists, left, mid);
            ListNode rightNode = process(lists, mid + 1, right);

            return mergeTwolist(leftNode, rightNode);
        }

        public ListNode mergeTwolist(ListNode nodeA, ListNode nodeB) {
            if (nodeA == null && nodeB == null) {
                return null;
            }

            ListNode dummy = new ListNode(0), p = dummy;

            while (nodeA != null && nodeB != null) {
                if (nodeA.val < nodeB.val) {
                    p.next = nodeA;
                    nodeA = nodeA.next;
                } else {
                    p.next = nodeB;
                    nodeB = nodeB.next;
                }
                p = p.next;
            }

            if (nodeA != null) {
                p.next = nodeA;
            }

            if (nodeB != null) {
                p.next = nodeB;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}