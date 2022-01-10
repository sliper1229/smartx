package com.cc.smartx.algorithm.practice.二叉树.done;

import java.util.*;

public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 路径定义：根节点 -> 叶子节点
     * 问题：是否存在路径和等于给定值
     * 解法1：递归，先序遍历
     */
    public boolean hasPathSumRecursive(TreeNode root, int sum) {
        if (root == null) return false;
        // 是否是叶子节点
        if (root.left == null && root.right == null) return root.val == root.val;
        return hasPathSumIterative(root.left, sum - root.val)
                || hasPathSumIterative(root.right, sum - root.val);
    }

    /**
     * 路径定义：根节点 -> 叶子节点
     * 问题：是否存在路径和等于给定值
     * 解法2：迭代，先序遍历
     */
    public boolean hasPathSumIterative(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> sumStack = new Stack<>();
        sumStack.push(sum);
        while (!stack.isEmpty()) {
            root = stack.pop();
            int s = sumStack.pop();
            if (root.left == null && root.right == null && root.val == s) {
                return true;
            }
            if (root.left != null) {
                stack.push(root.left);
                sumStack.push(s - root.val);
            }
            if (root.right != null) {
                stack.push(root.right);
                sumStack.push(s - root.val);
            }
        }
        return false;
    }


    /**
     * 路径定义：根节点 -> 叶子节点
     * 问题：找出路径和等于给定值的所有路径
     * 解法1：递归，先序遍历
     */
    // Time: O(n), Space: O(n)
    public List<List<Integer>> allPathSumRecursive(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        path(root, sum, elem, result);
        return result;
    }

    private void path(TreeNode root, int sum, List<Integer> elem, List<List<Integer>> result) {
        if (root == null) return;
        elem.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            // 这里要尤其注意！！！！！！！
            // result.add(elem);
            result.add(new ArrayList<>(elem));
        }
        path(root.left, sum - root.val, elem, result);
        path(root.right, sum - root.val, elem, result);
        // 深度优先遍历恢复现场
        elem.remove(elem.size() - 1);
    }

    /**
     * 路径定义：根节点 -> 叶子节点
     * 问题：找出路径和等于给定值的所有路径
     * 解法2：迭代，先序遍历
     */
    public List<List<Integer>> allPathSumIterative(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        int curSum = 0;

        // 先序遍历
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                elem.add(root.val);
                curSum += root.val;
                visited.add(root);
                stack.push(root);
                root = root.left;
            }
            TreeNode n = stack.peek();
            if (n.right == null || visited.contains(n.right)) {
                if (n.left == null && n.right == null && curSum == sum)
                    result.add(new ArrayList<>(elem));
                stack.pop();
                elem.remove(elem.size() - 1);
                curSum -= n.val;
                root = null;
            } else root = n.right;
        }
        return result;
    }

    /**
     * 路径定义：根节点 -> 叶子节点
     * 问题：所有路径求和
     * 解法1：递归
     */
    public int sumNumbers (TreeNode root) {
        if (root == null) return 0;
        return process(root, 0);
    }

    public int process(TreeNode root, int num) {
        if (root == null) return 0;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) return num;
        int sum = process(root.left, num)
                + process(root.right, num);
        return sum;
    }



}
