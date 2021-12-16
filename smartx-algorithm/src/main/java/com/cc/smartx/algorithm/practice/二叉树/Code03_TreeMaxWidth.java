package com.cc.smartx.algorithm.practice.二叉树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Code03_TreeMaxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 宽度优先遍历 使用队列
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
            Node cur = queue.poll();
            System.out.println(cur.value + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    /**
     * 树的最大宽度
     *
     * @param head
     */
    public static int getMaxWidth2(Node head) {
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


    /**
     * 数的最大宽度
     * @param head
     * @return
     */
    public static int getMaxWidth3(Node head) {
        if (head == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<Node>();
        Integer max = -1;

        while (!queue.isEmpty()) {
            max = Math.max(queue.size(), max);
            for (int i = 0; i < queue.size(); i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return max;
    }


    /**
     * 树的最大宽度
     *
     * @param head
     * @return
     */
    public static int getMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        int maxWidth = 0;
        int curWidth = 0;
        int curLevel = 0;

        // 节点所在层
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        Node node = null;
        Node left = null;
        Node right = null;

        while (!queue.isEmpty()) {
            node = queue.poll();
            left = node.left;
            right = node.right;
            if (left != null) {
                levelMap.put(left, levelMap.get(node) + 1);
                queue.add(left);
            }
            if (right != null) {
                levelMap.put(right, levelMap.get(node) + 1);
                queue.add(right);
            }
            if (levelMap.get(node) > curLevel) {
                curWidth = 0;
                curLevel = levelMap.get(node);
            } else {
                curWidth++;
            }
            maxWidth = Math.max(maxWidth, curWidth);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
