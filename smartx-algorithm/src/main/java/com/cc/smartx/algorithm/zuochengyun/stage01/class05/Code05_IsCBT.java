package com.cc.smartx.algorithm.zuochengyun.stage01.class05;

import java.util.LinkedList;

/**
 *
 * 完全二叉树-宽度优先遍历
 *
 * 1、任一节点，有右无左，返回false
 * 2、第一个左右不全的地方，后续的所有节点都为叶节点
 *
 * 完全二叉树 不能使用树型DP
 */
public class Code05_IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        //第一个左右子不全的地方
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                //2、第一个左右不全的地方，后续的所有节点都为叶节点
                    (leaf && (l != null || r != null))

                            ||

                            //1、任一节点，有右无左，返回false
                            (l == null && r != null)
            ) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }

            // 左右不全
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }


    /**
     * 满二叉树 树型DP
     * @param head
     * @return
     */
    public static boolean isFull(Node head) {
        if (head == null) {
            return true;
        }

        Info data = f(head);
        return data.nodes == (1 << data.height - 1);

    }

    public static class Info {
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static Info f(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftData = f(x.left);
        Info rightData = f(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new Info(height, nodes);

    }


}
