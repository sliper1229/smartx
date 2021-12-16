package com.cc.smartx.algorithm.practice.二叉树;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 1、如果当前节点为空，或者等等于 p 或 q，返回当前节点
 * 2、否则递归到左右子树进行处理，返回值分别为left 和 right
 * 3、如果 left 和 right都非空，则当前节点是最低公共祖先
 * 4、如果 left 和 right 一个非空，则返回非空的那个节点，如果都为空，则返回空
 */
public class Code07_LowestCommonAncestor {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

    /**
     * 解法1
     * @param head
     * @param o1
     * @param o2
     * @return
     */
	public static Node lca(Node head, Node o1, Node o2) {
	    HashMap<Node, Node> fatherMap = new HashMap<Node, Node>();
	    fatherMap.put(head, head);
        process(head, fatherMap);

        Node cur = o1;
        HashSet<Node> set = new HashSet<Node>();
        while (cur != fatherMap.get(cur)) {
            set.add(cur);
            cur = fatherMap.get(cur);
        }
        set.add(head);

        cur = o2;
        while (cur != fatherMap.get(cur)) {
            if (set.contains(cur)) {
                return cur;
            }
        }

        return head;
    }

    public static void process(Node head, HashMap<Node, Node> fatherMap) {
	    if (head == null) {
	        return;
        }
	    fatherMap.put(head.left, head);
	    fatherMap.put(head.right, head);
	    process(head.left, fatherMap);
	    process(head.right, fatherMap);
    }


    /**
     * 解法2
     *
     * @param head
     * @param o1
     * @param o2
     * @return
     */
	public static Node lowestAncestor(Node head, Node o1, Node o2) {
		if (head == null || head == o1 || head == o2) {
			return head;
		}
		Node left = lowestAncestor(head.left, o1, o2);
		Node right = lowestAncestor(head.right, o1, o2);
		if (left != null && right != null) {
			return head;
		}
		return left != null ? left : right;
	}

	// ��������--����һ
	public static class Record1 {
		private HashMap<Node, Node> map;

		public Record1(Node head) {
			map = new HashMap<Node, Node>();
			if (head != null) {
				map.put(head, null);
			}
			setMap(head);
		}

		private void setMap(Node head) {
			if (head == null) {
				return;
			}
			if (head.left != null) {
				map.put(head.left, head);
			}
			if (head.right != null) {
				map.put(head.right, head);
			}
			setMap(head.left);
			setMap(head.right);
		}

		public Node query(Node o1, Node o2) {
			HashSet<Node> path = new HashSet<Node>();
			while (map.containsKey(o1)) {
				path.add(o1);
				o1 = map.get(o1);
			}
			while (!path.contains(o2)) {
				o2 = map.get(o2);
			}
			return o2;
		}

	}

	// ��������--������
	public static class Record2 {
		private HashMap<Node, HashMap<Node, Node>> map;

		public Record2(Node head) {
			map = new HashMap<Node, HashMap<Node, Node>>();
			initMap(head);
			setMap(head);
		}

		private void initMap(Node head) {
			if (head == null) {
				return;
			}
			map.put(head, new HashMap<Node, Node>());
			initMap(head.left);
			initMap(head.right);
		}

		private void setMap(Node head) {
			if (head == null) {
				return;
			}
			headRecord(head.left, head);
			headRecord(head.right, head);
			subRecord(head);
			setMap(head.left);
			setMap(head.right);
		}

		private void headRecord(Node n, Node h) {
			if (n == null) {
				return;
			}
			map.get(n).put(h, h);
			headRecord(n.left, h);
			headRecord(n.right, h);
		}

		private void subRecord(Node head) {
			if (head == null) {
				return;
			}
			preLeft(head.left, head.right, head);
			subRecord(head.left);
			subRecord(head.right);
		}

		private void preLeft(Node l, Node r, Node h) {
			if (l == null) {
				return;
			}
			preRight(l, r, h);
			preLeft(l.left, r, h);
			preLeft(l.right, r, h);
		}

		private void preRight(Node l, Node r, Node h) {
			if (r == null) {
				return;
			}
			map.get(l).put(r, h);
			preRight(l, r.left, h);
			preRight(l, r.right, h);
		}

		public Node query(Node o1, Node o2) {
			if (o1 == o2) {
				return o1;
			}
			if (map.containsKey(o1)) {
				return map.get(o1).get(o2);
			}
			if (map.containsKey(o2)) {
				return map.get(o2).get(o1);
			}
			return null;
		}

	}

	// for test -- print tree
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		head.right.right.left = new Node(8);
		printTree(head);
		System.out.println("===============");

		Node o1 = head.left.right;
		Node o2 = head.right.left;

		System.out.println("o1 : " + o1.value);
		System.out.println("o2 : " + o2.value);
		System.out.println("ancestor : " + lowestAncestor(head, o1, o2).value);
		System.out.println("===============");

	}

}
