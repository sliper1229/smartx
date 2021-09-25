package com.cc.smartx.algorithm.zuochengyun.stage01.class05.done;

/**
 * @description: 搜索二叉树
 * @Author chenlipeng
 * @Date 2021-01-24
 */
public class Code04_IsBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public static boolean isBST(Node head) {
        return process(head).isBST;
    }

    public static class ReturnData {
        public boolean isBST;
        public int value;
        public ReturnData(boolean isBST, int value) {
            this.isBST = isBST;
            this.value = value;
        }
    }


    private static ReturnData process(Node head) {
        if (head == null) {
            return null;
        }

        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        int value = head.value;

        boolean isBST = (leftData != null ? leftData.isBST && leftData.value < value : true)
                && (rightData != null ? rightData.isBST && rightData.value > value : true);

        System.out.println("isBST=" + isBST + " , value=" + value);

        return new ReturnData(isBST, value);
    }

    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(6);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right.left = new Node(5);
        node.right.right = new Node(7);

        boolean bst = isBST(node);
        System.out.println(bst);
    }

}
