package com.cc.smartx.algorithm.practice.二叉树.done;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeWithPreInOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // [preStart......preEnd]：先序的开始位置和结束位置
    // inStart：中序的开始位置
    private TreeNode buildTree(int[] pre, int preStart, int preEnd,
                               Map<Integer, Integer> inMap, int inStart) {
        if (preStart > preEnd) return null;
        // 根节点
        TreeNode root = new TreeNode(pre[preStart]);
        // 根节点在中序中的位置
        int rootIdx = inMap.get(pre[preStart]);
        // 左子树的先序段
        root.left = buildTree(pre, preStart + 1, preStart + (rootIdx - inStart), inMap, inStart);
        // 右子树的先序段
        root.right = buildTree(pre, preStart + (rootIdx - inStart) + 1, preEnd, inMap, rootIdx + 1);
        return root;
    }

    // Time: O(n), Space: O(n)
    public TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer, Integer> inPos = new HashMap<>();
        for (int i = 0; i < in.length; ++i)
            inPos.put(in[i], i);
        return buildTree(pre, 0, pre.length - 1, inPos, 0);
    }

}
