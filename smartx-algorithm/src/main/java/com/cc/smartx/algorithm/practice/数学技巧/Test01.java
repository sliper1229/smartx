package com.cc.smartx.algorithm.practice.数学技巧;

/**
 * 1、反转整型数字
 * 2、字符串转整型
 * 3、获取某一位的数字 先取整，再取余、
 * 4、回文数字 / 数字反转
 * 5、获取一个数字的位数
 */
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
        // 1、记录正负号
        boolean neg = ((x >>> 31) & 1) == 1;
        // 2、转化成负数
        x = neg ? x : -x;
        // 3、
        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;
        int res = 0;
        // 4、进去while循环
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

    // 获取某一位的数字 先取整，再取余
    public static int getDigit(int x, int d) {
        return (x / ((int) Math.pow(10, d - 1))) % 10;
    }

    // 回文数字 / 数字反转
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        // 反转后的结果
        long y = 0;
        while (temp != 0) {
            int num = temp % 10; // 取第一位
            y = y * 10 + num;
            temp = temp / 10; //
        }

        return y == x;
    }

    // 获取一个数字的位数
    public static int maxbits(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            num /= 10;
        }
        return res;
    }

}
