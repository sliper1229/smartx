package com.cc.smartx.algorithm.mianshi;

/**
 *
 * 实现一个循环队列，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
 * 应支持如下操作：
 * 1、MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * 2、Front: 从队首获取元素。如果队列为空，返回 -1 。
 * 3、Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * 4、enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * 5、deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * 6、isEmpty(): 检查循环队列是否为空。
 * 7、isFull(): 检查循环队列是否已满。
 *
 *
 *
 * @description:
 * @Author chenlipeng
 * @Date 2021-02-21
 */
public class Q02 {

    class MyCircularQueue {

        private int[] queue;
        // 队首位置
        private int headIndex;
        // 元素数量
        private int count;
        // 容量
        private int capacity;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.queue = new int[k];
            this.headIndex = 0;
            this.count = 0;
        }

        public boolean enQueue(int value) {
            if (this.count == this.capacity)
                return false;
            this.queue[(this.headIndex + this.count) % this.capacity] = value;
            this.count += 1;
            return true;
        }

        public boolean deQueue() {
            if (this.count == 0)
                return false;
            this.headIndex = (this.headIndex + 1) % this.capacity;
            this.count -= 1;
            return true;
        }

        public int Front() {
            if (this.count == 0)
                return -1;
            return this.queue[this.headIndex];
        }

        public int Rear() {
            if (this.count == 0)
                return -1;
            int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
            return this.queue[tailIndex];
        }

        public boolean isEmpty() {
            return (this.count == 0);
        }

        public boolean isFull() {
            return (this.count == this.capacity);
        }
    }




}
