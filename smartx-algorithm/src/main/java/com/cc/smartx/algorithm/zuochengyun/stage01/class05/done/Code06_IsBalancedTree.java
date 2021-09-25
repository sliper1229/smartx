package com.cc.smartx.algorithm.zuochengyun.stage01.class05.done;

/**
 * 平衡二叉树：任意节点，左树高度 和 右树高度 都不大于1
 */
public class Code06_IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnData {
        public boolean balanced;
        public int height;


        public ReturnData(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    /**
     * 平衡树-树型DP
     * @param head
     * @return
     */
    public static boolean isBalanced(Node head) {
        return process(head).balanced;
    }


    public static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(true, 0);
        }

        ReturnData leftRetrunData = process(head.left);
        ReturnData rightReturnData = process(head.right);

        int height = Math.max(leftRetrunData.height, rightReturnData.height) + 1;

        boolean balanced = false;
        if (leftRetrunData.balanced && rightReturnData.balanced
                && Math.abs(leftRetrunData.height - rightReturnData.height) < 2) {
            balanced = true;
        }

        return new ReturnData(balanced, height);
    }

    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(6);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right.left = new Node(5);
        node.right.right = new Node(7);
        node.right.right.right = new Node(9);
        node.right.right.right.right = new Node(10);

        boolean bst = isBalanced(node);
        System.out.println(bst);
    }
}
