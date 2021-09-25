//编写一个函数，检查输入的链表是否是回文的。
//
//
//
// 示例 1：
//
// 输入： 1->2
//输出： false
//
//
// 示例 2：
//
// 输入： 1->2->2->1
//输出： true
//
//
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表
// 👍 43 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.Stack;

/**
 * 回文链表
 */
public class PalindromeLinkedListLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedListLcci().new Solution();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(1);
        boolean palindrome = solution.isPalindrome(node1);
        boolean palindrome2 = solution.isPalindrome2(node1);
        System.out.println(palindrome);
        System.out.println(palindrome2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                stack.push(head);
                head = head.next;
            }

            while (head != null) {
                if (head.val != stack.pop().val) {
                    return false;
                }
                head = head.next;
            }
            return true;
        }

        // 找到中点
        // 反转链表
        public boolean isPalindrome2(ListNode head) {
            boolean res = true;

            if (head == null) {
                return true;
            }


            // 找链表中点
            ListNode n1 = head;
            ListNode n2 = head;
            while (n2 != null && n2.next.next != null) {
                n1 = n1.next;
                n2 = n2.next.next;
            }

            // n1 -> 中点
            // n2 -> cur
            // n3 -> temp变量
            n2 = n1.next;
            n1.next = null;
            ListNode n3 = null; // temp变量
            // 反转单链表
            while (n2 != null) {
                n3 = n2.next;
                n2.next = n1;
                n1 = n2;
                n2 = n3;
            }

            n3 = n1; // 记住右半部分的头

            // n1 -> 右半部分的头
            // n2 -> 左半部分的头
            n2 = head;
            while (n1 != null && n2 != null) { // 注意条件
                if (n1.val != n2.val) {
                    res = false;
                }
                n1 = n1.next;
                n2 = n2.next;
            }

            // n3 -> cur
            // n1 -> pre
            // n2 -> temp;
            n1 = null;
            // 恢复链表
            while (n3 != null) {
                n2 = n3.next;
                n3.next = n1;
                n1 = n3;
                n3 = n2;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}