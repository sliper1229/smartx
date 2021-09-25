//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 906 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(4);
        node.left.left = p;
        node.left.right = q;
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);

        TreeNode ancestor2 = solution.lowestCommonAncestor2(node, p, q);
        TreeNode ancestor = solution.lowestCommonAncestor(node, p, q);
        System.out.println(ancestor2.val);
        System.out.println(ancestor.val);

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        /**
         * 解法一：中心扩展法
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return lcaExtend(root, p, q);
        }

        private TreeNode lcaExtend(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            }
            return left != null ? left : right;
        }

        /**
         * 解法二：先遍历获取，每个节点的父节点，再从上往下找第一个公共父节点
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            HashMap<TreeNode, TreeNode> fatherMap = new HashMap<TreeNode, TreeNode>();

            preOrderRe(root, fatherMap);

            TreeNode pf = p;
            LinkedList<TreeNode> pfList = new LinkedList<TreeNode>();
            while (pf != null) {
                pfList.add(pf);
                pf = fatherMap.get(pf);
            }

            TreeNode qf = q;
            LinkedList<TreeNode> qfList = new LinkedList<TreeNode>();
            while (qf != null) {
                qfList.add(qf);
                qf = fatherMap.get(qf);
            }

            int n1 = pfList.size() - 1;
            int n2 = qfList.size() - 1;

            while (n1 > 0 && n2 > 0) {
                if (pfList.get(n1).val != qfList.get(n2).val) {
                    break;
                }
                n1--;
                n2--;
            }
            return pfList.get(n1 + 1);

        }

        /**
         * 先序遍历
         *
         * @param root
         * @param map
         * @return
         */
        public HashMap<TreeNode, TreeNode> preOrderRe(TreeNode root, HashMap<TreeNode, TreeNode> map) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                    map.put(node.left, node);
                }
                if (node.left != null) {
                    stack.push(node.left);
                    map.put(node.right, node);
                }
            }

            return map;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}