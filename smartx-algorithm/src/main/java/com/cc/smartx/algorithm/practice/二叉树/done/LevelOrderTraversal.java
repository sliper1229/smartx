package com.cc.smartx.algorithm.practice.二叉树.done;

import java.util.*;

public class LevelOrderTraversal {

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

    /**
     * 获取最大宽度
     *
     * @param head
     * @return
     */
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
        int max = 0;

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
     * 按层打印、获取最大宽度、二叉树的右视图
     *
     * @param head
     * @return
     */
    public List<List<Integer>> levelOrderTraversal(Node head) {
        if (head == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int max = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            max = Math.max(max, queue.size());
            // 尤其注意！！！！
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                head = queue.poll();
                temp.add(head.value);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            result.add(temp);
        }

        // Collections.reverse(result);
        for (int i = 0; i < result.size() / 2; ++i) {
            int j = result.size() - 1 - i;
            List<Integer> tmp = result.get(j);
            result.set(j, result.get(i));
            result.set(i, tmp);
        }

        return result;
    }

    /**
     * Z字形遍历
     *
     * @param head
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(Node head) {
        if (head == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean right2left = false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            // 这里用LinkedList
            List<Integer> temp = new LinkedList<>();
            // 尤其注意！！！！
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                head = queue.poll();
                // Z字形遍历
                if (right2left) {
                    temp.add(0, head.value);
                } else {
                    temp.add(head.value);
                }
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            if (right2left) {
                Collections.reverse(temp);
            }
            result.add(temp);
            right2left = !right2left;
        }
        return result;
    }

    /**
     * 右视图
     * @param head
     * @return
     */
    public List<Integer> rightView(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            result.add(queue.peek().value);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                head = queue.poll();
                // 先右再左
                if (head.right != null) {
                    queue.add(head.right);
                }
                if (head.left != null) {
                    queue.add(head.left);
                }
            }
        }
        return result;
    }

}
