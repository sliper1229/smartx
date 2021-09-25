//编写一个程序，找到两个单链表相交的起始节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表 
// 👍 957 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import com.cc.smartx.algorithm.zuochengyun.stage01.class03.HeapTest;

/**
 * 相交链表
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);

        ListNode intNode = new ListNode(7);
        intNode.next = new ListNode(8);

        head1.next.next.next = intNode;
        head2.next.next = intNode;

        ListNode intersectionNode = solution.getIntersectionNode(head1, head2);
        ListNode intersectionNode2 = solution.getIntersectionNode2(head1, head2);

        System.out.println(intersectionNode.val);
        System.out.println(intersectionNode2.val);

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

        // 长链表先走差值步 O(M+N) O(1)
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = 0, lenB = 0;
            ListNode p1 = headA, p2 = headB;
            while (p1 != null) {
                lenA++;
                p1 = p1.next;
            }
            while (p2 != null) {
                lenB++;
                p2 = p2.next;
            }

            p1 = headA;
            p2 = headB;
            if (lenA > lenB) {
                for (int i = 0; i < lenA - lenB; i++) {
                    p1 = p1.next;
                }
            } else {
                for (int i = 0; i < lenB - lenA; i++) {
                    p2 = p2.next;
                }
            }

            while (p1 != null && p2 != null) {
                if (p1.val == p2.val) {
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            return null;
        }

        // O(M+N) O(1)
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                p1 = p1 != null ? p1.next : headB;
                p2 = p2 != null ? p2.next : headA;
            }
            return p1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}