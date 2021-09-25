//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 
// 👍 391 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 删除二叉搜索树中的节点
 */
public class DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();

        String str = "123";
        String[] split = str.split("\\.");
        System.out.println(split[0]);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        /**
         * 解法一：使用递归
         *
         * @param root
         * @param key
         * @return
         */
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else {
                if (root.left == null) {
                    return root.right;
                }
                if (root.right == null) {
                    return root.left;
                }
                TreeNode leftMax = root.left;
                while (leftMax.right != null) {
                    leftMax = leftMax.right;
                }

                leftMax.right = root.right;
                // 注意点1
                root = root.left;
            }
            // 注意点2
            return root;
        }

        /**
         * 解法二：使用迭代
         *
         * @param root
         * @param key
         * @return
         */
        public TreeNode deleteNode2(TreeNode root, int key) {
            TreeNode node = root;
            while (node != null) {
                if (node.val > key) {
                    node = node.left;
                } else if (node.val < key) {
                    node = node.right;
                } else {
                    if (node.left == null) {

                    }
                    TreeNode leftMax = node.left;
                    while (leftMax.right != null) {
                        leftMax = leftMax.right;
                    }

                    leftMax.right = node.right;
                    break;
                }
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}