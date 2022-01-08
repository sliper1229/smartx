package com.cc.smartx.algorithm.practice.二叉树.done;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeWithPosInOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // [postStart......postEnd]：后序的开始位置和结束位置
    // inStart：中序的开始位置
    private TreeNode buildTree(
            int[] post, int postStart, int postEnd,
            int inStart, Map<Integer, Integer> inMap) {
        if (postStart > postEnd) return null;
        // 根节点
        TreeNode root = new TreeNode(post[postEnd]);
        // 根节点在中序中的位置
        int rootIdx = inMap.get(post[postEnd]);
        // 左子树的后序段
        root.left = buildTree(post, postStart, postStart + (rootIdx - inStart) - 1, inStart, inMap);
        // 右子树的后序段
        root.right = buildTree(post, postStart + (rootIdx - inStart), postEnd - 1, rootIdx + 1, inMap);
        return root;
    }

    // Time: O(n), Space: O(n)
    public TreeNode buildTree(int[] in, int[] post) {
        Map<Integer, Integer> inMao = new HashMap<>();
        for (int i = 0; i < in.length; ++i)
            inMao.put(in[i], i);
        return buildTree(post, 0, post.length - 1, 0, inMao);
    }

}
