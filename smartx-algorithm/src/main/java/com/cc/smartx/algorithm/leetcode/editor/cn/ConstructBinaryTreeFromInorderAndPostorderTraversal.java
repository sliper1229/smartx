//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 446 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode treeNode = solution.buildTree(inorder, postorder);
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }

            return buildTree(postorder, 0, postorder.length - 1, inMap, 0);
        }

        private TreeNode buildTree(int[] postorder, int postStart, int postEnd,
                                   Map<Integer, Integer> inMap, int inStart) {
            if (postStart > postEnd) {
                return null;
            }
            int index = inMap.get(postorder[postEnd]);
            int leftLen = index - inStart;
            TreeNode root = new TreeNode(postorder[postEnd]);
            root.left = buildTree(postorder, postStart, postStart + leftLen - 1, inMap,  inStart);
            root.right = buildTree(postorder, postStart + leftLen, postEnd - 1, inMap, index + 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}