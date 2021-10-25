package com.cc.smartx.algorithm.leetcode.editor.cn;
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 178 👎 0

import java.util.List;

public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            // 先确定头
            ListNode head = l1.val < l2.val ? l1 : l2; // 记录头
            ListNode pre = head; // 记录新链表的前一个节点
            ListNode cur1 = head.next;
            ListNode cur2 = l1.val < l2.val ? l2 : l1;
            while (cur1 != null || cur2 != null) {
                if (cur1 == null) {
                    pre.next = cur2;
                    break;
                }
                if (cur2 == null) {
                    pre.next = cur1;
                    break;
                }
                if (cur1.val <= cur2.val) {
                    pre.next = cur1;
                    cur1 = cur1.next;
                } else {
                    pre.next = cur2;
                    cur2 = cur2.next;
                }
                pre = pre.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}