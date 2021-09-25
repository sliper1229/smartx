//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1434 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 反转链表
 */
public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode reverseList(ListNode head) {

        //作为temp变量，不会改它的指向

        ListNode pre = null;

        while (head != null) {
            ListNode next = head.next; // temp变量
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}