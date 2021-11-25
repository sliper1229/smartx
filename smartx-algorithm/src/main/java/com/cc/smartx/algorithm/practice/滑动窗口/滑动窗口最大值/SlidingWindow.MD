主流程：

    窗口内最大值：双端队列，头（大）->尾（小）
    双端队列的含义：缩窗口过程中，哪些数会依次成为最大值

    R++，保持双端队列，头（大）->尾（小）
    L++，判断头部是否过期

    a b -> a (<b) (<b) (=b) b

伪代码：

    while (!qmax.isEmpty() && arr[R] >= arr[qmax.peekLast()]) {
        qmax.pollLast();
    }
    qmax.addLast(R);

经典题目：

- [76]最小覆盖子串
- [239]滑动窗口最大值
- [3]无重复字符的最长子串

https://www.jianshu.com/p/c17a7a5296f8
