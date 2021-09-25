//给定一个链表，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 104] 
// -105 <= Node.val <= 105 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
// Related Topics 链表 双指针 
// 👍 916 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.HashSet;

/**
 * 环形链表
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        ListNode listNode = new ListNode(3);
        node.next.next = listNode;
        node.next.next.next = new ListNode(4);
        node.next.next.next.next =  listNode;
        boolean hasCycle = solution.hasCycle(node);
        boolean hasCycle2 = solution.hasCycle2(node);
        System.out.println(hasCycle);
        System.out.println(hasCycle2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {

        // 解法1: set  O(N) O(N)
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            HashSet<ListNode> set = new HashSet<ListNode>();
            while (head != null) {
                if (set.contains(head)) {
                    return true;
                }
                set.add(head);
                head = head.next;
            }
            return false;
        }

        // 解法2: 快慢指针.  O(N) O(1)
        public boolean hasCycle2(ListNode head) {
            if (head == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}