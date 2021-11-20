package com.cc.smartx.algorithm.practice.滑动窗口.滑动窗口最大值;

import java.util.LinkedList;

public class WindowMax {
    private int L;
    private int R;
    private int[] arr; // arr[   [L..R)     ]
    private LinkedList<Integer> qmax;

    public WindowMax(int[] a) {
        arr = a;
        L = -1;
        R = 0;
        qmax = new LinkedList<>();
    }

    //L = -1
    // R = 0
    // arr   [-1,1)
    //[ 3,2,1,4,5   ]
    // 0
    // [0,1)  arr[0]
    // 1
    // [-1,2)  arr[0,1]
    public void addNumFromRight() {
        if (R == arr.length) {
            return;
        }
        while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
            qmax.pollLast();
        }
        qmax.addLast(R);
        R++;
    }

    // arr  [L,R)
    public void removeNumFromLeft() {
        if (L >= R - 1) {
            return;
        }
        L++;
        if (qmax.peekFirst() == L) {
            qmax.pollFirst();
        }
    }

    public Integer getMax() {
        if (!qmax.isEmpty()) {
            return arr[qmax.peekFirst()];
        }
        return null;
    }


}
