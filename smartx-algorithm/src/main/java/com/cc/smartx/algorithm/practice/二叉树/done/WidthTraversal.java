package com.cc.smartx.algorithm.practice.二叉树.done;

import com.cc.smartx.algorithm.zuochengyun.stage01.class05.Code03_TreeMaxWidth;

import java.util.*;

public class WidthTraversal {

    public static class Node {
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    /**
     * 宽度优先遍历 原始代码
     *
     * @param head
     */
    public static void w(Node head) {
        if (head == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value + ' ');
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
        System.out.println("");
    }

    // Time: O(n), Space: O(n)
    public List<List<Integer>> levelOrderTraversalFromBottom(Code03_TreeMaxWidth.Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<Code03_TreeMaxWidth.Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> elem = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Code03_TreeMaxWidth.Node s = q.poll();
                elem.add(s.value);
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            result.add(elem);
        }

        for (int i = 0; i < result.size() / 2; ++i) {
            int j = result.size() - 1 - i;
            List<Integer> tmp = result.get(j);
            result.set(j, result.get(i));
            result.set(i, tmp);
        }
        return result;
    }

    public static int getMaxWidth2(Node head) {
        if (head == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        Map<Node, Integer> nodeLevelMap = new HashMap<>();
        nodeLevelMap.put(head, 1);

        int curLevel = 1;
        int curLevelNodes = 0;
        Integer max = 0;

        while (!queue.isEmpty()) {
            head = queue.poll();
            int curNodeLevel = nodeLevelMap.get(head);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 0;
            }

            if (head.left != null) {
                queue.add(head.left);
                nodeLevelMap.put(head.left, nodeLevelMap.get(head) + 1);
            }
            if (head.right != null) {
                queue.add(head.left);
                nodeLevelMap.put(head.right, nodeLevelMap.get(head) + 1);
            }

        }


        return max;
    }


    public static int getMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> nodeLevelMap = new HashMap<>();
        nodeLevelMap.put(head, 1);

        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = nodeLevelMap.get(cur);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }

            if (cur.left != null) {
                nodeLevelMap.put(cur.left, nodeLevelMap.get(cur) + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                nodeLevelMap.put(cur.right, nodeLevelMap.get(cur) + 1);
                queue.add(cur.right);
            }
        }

        return max;
    }

}
