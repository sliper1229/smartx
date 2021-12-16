package com.cc.smartx.algorithm.practice.二叉树;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 搜索二叉树：每一个节点，每棵左子树都比当前节点小，每棵右子树都比当前节点大
 * 中序遍历-升序
 */
public class Code04_IsBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int preValue = Integer.MIN_VALUE;

    /**
     * 搜索二叉树-递归
     *
     * @param head
     * @return
     */
    public static boolean checkBST(Node head) {
        if (head == null) {
            return true;
        }

        boolean isLeftBst = checkBST(head.left);

        // 打印行为
        if (!isLeftBst) {
            return false;
        }
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }

        return checkBST(head.right);
    }

    /**
     * 搜索二叉树-递归-傻瓜式
     *
     * @param head
     * @return
     */
    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> inOrderList = new LinkedList<>();
        process(head, inOrderList);
        int pre = Integer.MIN_VALUE;
        for (Node cur : inOrderList) {
            if (pre >= cur.value) {
                return false;
            }
            pre = cur.value;
        }
        return true;
    }

    /**
     * 中序遍历
     *
     * @param node
     * @param inOrderList
     */
    public static void process(Node node, LinkedList<Node> inOrderList) {
        if (node == null) {
            return;
        }
        process(node.left, inOrderList);
        inOrderList.add(node);
        process(node.right, inOrderList);
    }

    /**
     * 搜索二叉树-非递归
     *
     * @param head
     * @return
     */
    public static boolean checkBST2(Node head) {
        if (head == null) {
            return true;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        int preValue = Integer.MIN_VALUE;

        while (!stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();

                // 打印行为
                if (head.value >= preValue) {
                    preValue = head.value;
                } else {
                    return false;
                }

                head = head.right;
            }
        }

        return true;
    }


    /////// 搜索二叉树 树型DP

    public static class ReturnData {
        public boolean isBST;
        public Integer max;
        public Integer min;

        public ReturnData(boolean isBST, Integer max, Integer min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    /**
     * 树型DP
     * @param x
     * @return
     */
    public static ReturnData process2(Node x) {
        if (x == null) {
            return null;
        }

        ReturnData leftData = process2(x.left);
        ReturnData rightData = process2(x.right);

        int min = x.value;
        int max = x.value;
        if (leftData != null) {
            Math.min(min, leftData.min);
            Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

        boolean isBST = true;
        if (leftData != null && (!leftData.isBST || leftData.max >= x.value)) {
            isBST = false;
        }

        if (rightData != null && (!rightData.isBST || x.value >= rightData.min)) {
            isBST = false;
        }

        return new ReturnData(isBST, min, max);
    }


}
