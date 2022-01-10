package com.cc.smartx.algorithm.practice.二叉树.done;

public class PathSum2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 路径定义： 父节点 -> 子节点
     * （路径不需要开始于根节点，或结束于叶子节点。但必须是从父节点到子节点）
     * 问题：路径和等于目标值的路径一共有多少条
     * 解法1：嵌套递归
     */
    public int pathSumRecursive(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathFrom(root, sum)
                + pathSumRecursive(root.left, sum)
                + pathSumRecursive(root.right, sum);
    }

    /**
     * 以任意节点开始，找路径和等于指定值的路径
     */
    private int pathFrom(TreeNode root, int sum) {
        if (root == null) return 0;
        int cnt = 0;
        if (root.val == sum) ++cnt;
        cnt += pathFrom(root.left, sum - root.val);
        cnt += pathFrom(root.right, sum - root.val);
        return cnt;
    }

}
