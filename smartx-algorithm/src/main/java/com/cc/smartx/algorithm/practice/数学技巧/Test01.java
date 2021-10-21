package com.cc.smartx.algorithm.practice.数学技巧;

public class Test01 {

    /**
     * 反转整形数字
     *
     * 技巧1:：整形溢出处理，统一转换成负数处理
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        // 记录正负号
        boolean neg = ((x >>> 31) & 1) == 1;
        // 转化成负数
        x = neg ? x : -x;
        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;
        int res = 0;
        while (x != 0) {
            // 判断溢出
            if (res < m || (res == m && x % 10 < o)) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        // 根据正负号返回结果
        return neg ? res : Math.abs(res);
    }

    /**
     * 字符串转整数
     *
     * 技巧1:：整形溢出处理，统一转换成负数处理
     *
     * 技巧二：字符转数字  '0' - ch
     *
     * @param s
     * @return
     */
    public static int string2Integer(String s) {
        char[] str = s.toCharArray();
        boolean posi = str[0] == '-' ? false : true;
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        // 有正负号从1位置开始
        int i = (str[0] == '-' || str[0] == '+') ? 1 : 0;
        for (; i < str.length; i++) {
            // 转化成负数
            cur = '0' - str[i];
            // 判断溢出
            if ((res < minq) || (res == minq && cur < minr)) {
                // 根据符号返回最小值或者最大值
                return posi ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + cur;
        }
        // 如果是正数，且值为最小值大小，说明溢出，返回最大指
        if (posi && res == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        // 根据正负号返回转换结果
        return posi ? -res : res;
    }
}
