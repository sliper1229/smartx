package com.cc.smartx.algorithm.practice.二叉树.done;

public class SubTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * q是p的子树
     */
    // Time: O(m*n), Space: O(h)
    public boolean isSubTree(TreeNode p, TreeNode q) {
        if (q == null) return true;
        if (p == null) return false;
        return isSameTree(p, q)
                || isSubTree(p.left, q)
                || isSubTree(p.right, q);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

}
