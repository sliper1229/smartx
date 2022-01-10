package com.cc.smartx.algorithm.practice.二叉树.done;

import java.util.Stack;

public class SameTree {

    public class TreeNode {
        int val;
        SubTree.TreeNode left;
        SubTree.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Time: O(n), Space: O(n)
    public boolean isSameTreeRecursive(SubTree.TreeNode p, SubTree.TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val
                && isSameTreeRecursive(p.left, q.left)
                && isSameTreeRecursive(p.right, q.right);
    }

    // Time: O(n), Space: O(n)
    public boolean isSameTreeIterative(SubTree.TreeNode p, SubTree.TreeNode q) {
        Stack<SubTree.TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            p = stack.pop();
            q = stack.pop();
            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            stack.push(p.left);
            stack.push(q.left);
            stack.push(p.right);
            stack.push(q.right);
        }
        return true;
    }

}
