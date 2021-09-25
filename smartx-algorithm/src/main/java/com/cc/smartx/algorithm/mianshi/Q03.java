package com.cc.smartx.algorithm.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author chenlipeng
 * @Date 2021-03-01
 */
public class Q03 {

    public static void main(String[] args) {
        int[] a = {1, 5, 8, 8, 8, 9, 10};
        int[] b = {11, 9, 9, 9, 8, 5};

        List<Integer> max5 = getMax5(a, b);

        for (int i = 0; i < max5.size(); i++) {
            System.out.println(max5.get(i) + " ");
        }
    }


    /**
     * a = [1, 5, 8, 8, 8, 9, 10]  升序
     * b = [11, 9, 9, 9, 8, 5]  降序
     *
     * @param a
     * @param b
     * @return
     */
    public static List<Integer> getMax5(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int i = n1 - 1;
        int j = 0;
        List<Integer> list = new ArrayList<Integer>();

        while (i >= 0 && j < n2) {
            if (a[i] > b[j]) {
                list.add(a[i--]);
                while (i >= 0 && a[i + 1] == a[i]) {
                    i--;
                }
            } else {
                list.add(b[j++]);
                while (j <= n2 - 1 && b[j] == b[j-1]) {
                    j++;
                }
            }
            if (list.size() == 5) {
                return list;
            }
        }

        while (i >= 0) {
            list.add(a[i]);
            while (i - 1 >= 0 && a[i - 1] == a[1]) {
                i--;
            }
            if (list.size() == 5) {
                return list;
            }
        }

        while (j <= n2-1) {
            list.add(a[i]);
            while (i - 1 >= 0 && a[i - 1] == a[1]) {
                i--;
            }
            if (list.size() == 5) {
                return list;
            }
        }

        return list;
    }

}
