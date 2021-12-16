package com.cc.smartx.algorithm.practice.二叉树;

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

	public static boolean isBalanced(Node head) {
		return process(head).isBalanced;
	}

	public static class ReturnType {
		public boolean isBalanced;
		public int height;

		public ReturnType(boolean isB, int hei) {
			isBalanced = isB;
			height = hei;
		}
	}

	public static ReturnType process(Node x) {
		if (x == null) {
			return new ReturnType(true, 0);
		}

		ReturnType leftData = process(x.left);
		ReturnType rightData = process(x.right);

		int height = Math.max(leftData.height, rightData.height) + 1;

		boolean isBalanced =

                leftData.isBalanced && rightData.isBalanced
                        &&

                        Math.abs(leftData.height - rightData.height) < 2;

		return new ReturnType(isBalanced, height);
	}

}
