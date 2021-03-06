//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1620 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 删除链表的倒数第 N 个结点
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
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

        // 1 -> 2 -> 3 -> 4 -> 5    n = 5
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = null;
            ListNode cur = head;
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
            // 删除的是头
            if (pre == null) {
                pre = head.next;
            }
            // 删除的不是头节点
            pre.next = pre.next.next;
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}