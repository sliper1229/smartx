package com.cc.smartx.algorithm.practice;

import java.util.*;

/**
 * @description: 大根堆、栈、队列
 * @Author chenlipeng
 * @Date 2021-01-15
 */
public class Practice03 {

    public static void main(String[] args) {

        //默认小根堆
        //单次扩容时间复杂度 O(logN)
        //大根堆
        //add、poll：给一个，弹一个，不改变已有结构
        //如果是随机改变堆里面某一个元素的值，默认堆，调整代价比较高
        //如果有需求，必须手写堆
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new AgeDescCompararor());
        priorityQueue.add(new Student());
        priorityQueue.offer(new Student());
        Student poll1 = priorityQueue.poll();
        Student peek1 = priorityQueue.peek();
        priorityQueue.isEmpty();
        priorityQueue.size();

        // 队列
        Queue<Student> queue = new LinkedList<>();
        queue.add(new Student());
        queue.offer(new Student());
        Student poll = queue.poll(); // 查看并弹出
        Student peek = queue.peek(); // 只查看
        queue.isEmpty();
        queue.size();

        //栈
        Stack<Student> stack = new Stack<>();
        stack.push(new Student());
        Student pop = stack.pop();
        stack.isEmpty();
        stack.size();

    }

    public static class AgeDescCompararor implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static class Student {
        public int name;
        public int age;
    }

}
