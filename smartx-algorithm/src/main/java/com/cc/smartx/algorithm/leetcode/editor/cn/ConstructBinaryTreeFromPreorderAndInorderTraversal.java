//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 873 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        System.out.println(treeNode);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            return buildTree(preorder, 0, preorder.length - 1, inMap, 0);
        }

        /**
         * @param preorder
         * @param preStart
         * @param preEnd
         * @param inStart  上一个index的位置
         * @param inMap
         * @return
         */
        private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                   Map<Integer, Integer> inMap, int inStart) {
            if (preStart > preEnd) {
                return null;
            }
            Integer index = inMap.get(preorder[preStart]);
            int leftLen = index - inStart;
            TreeNode root = new TreeNode(preorder[preStart]);
            root.left = buildTree(preorder, preStart + 1, preStart + leftLen, inMap, inStart);
            root.right = buildTree(preorder, preStart + leftLen + 1, preEnd, inMap, index + 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}