//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。 
//
// 要求返回这个链表的 深拷贝。 
//
// 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示： 
//
// 
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
// Related Topics 哈希表 链表 
// 👍 464 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
        Solution solution2 = new CopyListWithRandomPointer().new Solution();
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node nod3 = new Node(4);

        head.next = node1;
        head.random = node2;

        node1.next = node2;
        node2.next = nod3;

        Node copyHead = solution.copyRandomList(head);
        Node copyHead2 = solution2.copyRandomList(head);

        System.out.println(copyHead);
        System.out.println(copyHead2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            // 创建新节点 N', 连接在N的后面
            Node p = head;
            while (p != null) {
                Node q = new Node(p.val);
                q.next = p.next;
                p.next = q;
                p = q.next;
            }

            // 设置N'的random
            Node p1 = head;
            while (p1 != null) {
                if (p1.random != null) {
                    p1.next.random = p1.random.next;
                }
                p1 = p1.next.next;
            }

            // 拆分
            Node p2 = head;
            Node q2 = p2.next;
            Node head2 = p2.next;
            // 判断循环终止条件，以链表的最后一个节点
            while (q2 != null) {
                p2.next = q2.next;
                if (q2.next != null) {
                    q2.next = q2.next.next;
                }
                p2 = p2.next;
                q2 = q2.next;
            }

            return head2;

        }
    }

    class solution2 {

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            HashMap<Node, Node> map = new HashMap<>();

            Node p = head;
            while (p != null) {
                map.put(p, new Node(p.val));
                p = p.next;
            }

            for (Map.Entry<Node, Node> entry : map.entrySet()) {
                Node key = entry.getKey();
                Node value = entry.getValue();
                value.next = map.get(key.next);
                value.next = map.get(key.random);
            }
            return map.get(head);
        }


    }

//leetcode submit region end(Prohibit modification and deletion)

}