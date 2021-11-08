package com.cc.smartx.algorithm.practice.滑动窗口.单调栈;

public class Test01 {

    // [84]柱状图中最大的矩形

    // 滑动窗口的最大值
    // R不动，只能L往右动，L移动过程中，谁可能成为最大值
    // [.........R]
    // 通俗理解：我级别比你高，活得比你还长，所以你是没机会当老大的！！！！！！
    // 3 5 2 7 1 6
    // 双端队列
    // 头（大） ------------> 尾（小）
    // while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
    // 	qmax.pollLast();
    // }
    // qmax.addLast(R);


    // 单调栈：找左边比自己小的最近的位置和右边比自己小的最近的位置（找小）
    // 找小：栈底（小）--------> 栈顶（大）
    // 左边比它自己小的在它下面，右边比自己的小的是谁让它弹出的位置

    // 进栈：维持栈底（小）--------> 栈顶（大）
    // 出栈：生成记录

    // 当前比栈顶大，入栈
    // 当前比栈顶小，出栈

    // a在b的上面：b (>a) a -> (>a)出栈，a入栈 -> b  a
    // 多个在一起：a (>a)(>a)(>a) a (>a)(>a)(>a) a ->  (>a)出栈，a入栈 -> a a a
    // b压在a的上面，1、b和a挨着 2、b和a中间都是比b大的值，b将中间数都弹出了
    // 多个a在一起，1、多个a挨着 2、a和a中间都是比a大的值，a将中间的都弹出了

    // 最后栈底部，为全局最小的数
    // 最后留在栈中的数，没有右边比它小的数

    // 留在栈中的是，找到了左边比自己小的值，没找到右边比自己小的值
    // 从栈中弹出，是找到了左边比自己小的值和右边比自己小的值


    // 前缀和数组

}
