//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 583 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 平衡二叉树
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        boolean balanced = solution.isBalanced(node);
        System.out.println(balanced);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public static class TreeNode {
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


    public static class ResultData {

        public int heiht;

        public boolean isBst;

        public ResultData(int heiht, boolean isBst) {
            this.heiht = heiht;
            this.isBst = isBst;
        }
    }


    class Solution {

        /**
         * 解法一：树型DP
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            return process(root).isBst;
        }

        public ResultData process(TreeNode node) {
            if (node == null) {
                return new ResultData(0, true);
            }

            ResultData leftData = process(node.left);
            ResultData rightData = process(node.right);

            int height = Math.max(leftData.heiht, rightData.heiht) + 1;
            boolean isBst = false;
            if (leftData.isBst && rightData.isBst
                    && Math.abs(leftData.heiht - rightData.heiht) <= 1) {
                isBst = true;
            }

            return new ResultData(height, isBst);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}