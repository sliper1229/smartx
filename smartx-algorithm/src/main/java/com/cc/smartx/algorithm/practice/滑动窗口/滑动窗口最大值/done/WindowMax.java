package com.cc.smartx.algorithm.practice.滑动窗口.滑动窗口最大值.done;

import java.util.LinkedList;

public class WindowMax {
    // [L..R)
    private int L;
    private int R;
    private int[] arr;
    private LinkedList<Integer> qmax;

    public WindowMax(int[] a) {
        arr = a;
        L = -1;
        R = 0;
        qmax = new LinkedList<>();
    }

    public void addNumFromRight() {
        if (R == arr[arr.length]) {
            return;
        }
        while (!qmax.isEmpty() && arr[R] >= arr[qmax.peekLast()]) {
            qmax.pollLast();
        }
        qmax.addLast(R);
        R++;
    }

    public void removeNumFromLeft() {
        if (L >= R - 1) {
            return;
        }
        L++;
        if (L == qmax.peekFirst()) {
            qmax.pollFirst();
        }
    }

    public Integer getMax() {
        if (!qmax.isEmpty()) {
            return qmax.peekFirst();
        }
        return null;
    }


}
