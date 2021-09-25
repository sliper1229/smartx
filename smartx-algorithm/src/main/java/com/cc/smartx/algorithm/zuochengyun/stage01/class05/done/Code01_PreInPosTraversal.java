package com.cc.smartx.algorithm.zuochengyun.stage01.class05.done;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 先序：一边弹，一边放，先右后左
 * 中序：一路向左，先弹后右
 * 后序；一边弹，一边转移，先左后右
 *
 * @description:
 * @Author chenlipeng
 * @Date 2021-01-15
 */
public class Code01_PreInPosTraversal {

    public static class Node {
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static void preOrderTraversal(Node head) {
        if (head == null) {
            return;
        }

        // 一边弹，一边放，先右后左
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        System.out.println("");

    }


    public static void inOrderTraversal(Node head) {
        if (head == null) {
            return;
        }

        //一路向左，先弹后右
        Stack<Node> stack = new Stack<>();
        //stack.push(head); 注意！！！！
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
                ;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println("");
    }

    public static void postOrderTraversal(Node head) {
        if (head == null) {
            return;
        }

        //一边弹，一边转移，先左后右
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);

            if (head.left != null) {
                stack1.push(head.left);
            }

            if (head.right != null) {
                stack1.push(head.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
        System.out.println("");
    }


    public static void w(Node head) {
        if (head == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);

        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (head.left != null) {
                queue.add(head.left);
            }

            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.left = new Node(1);
        head.right = new Node(2);
        head.left.left = new Node(3);
        head.left.right = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);

        preOrderTraversal(head);
        inOrderTraversal(head);
        postOrderTraversal(head);
        w(head);

    }






}
