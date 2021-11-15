package com.cc.smartx.algorithm.practice.字符串.KMP;

/**
 * KMP：str1, str2字串问题，indexOf()
 * <p>
 * 暴力解法：以每一个位置开头，逐一对比 O(N*M)
 */
public class Code01_KMP {

    // N >= M
    public static int getIndexOf(String str, String match) {
        if (str == null || match == null || match.length() < 1 || str.length() < match.length()) {
            return -1;
        }

        char[] str1 = str.toCharArray();
        char[] str2 = match.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2); // O (M)
        // O(N)
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
                // i2一直从右往左移，移到0位置，i1开始东
            } else if (next[i2] == -1) { // str2中比对的位置已经无法往前跳了
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        // i1 越界  或者  i2越界了
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; // next数组的位置
        int cn = 0;
        while (i < next.length) {
            if (match[i - 1] == match[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) { // 当前跳到cn位置的字符，和i-1位置的字符配不上
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }

}
