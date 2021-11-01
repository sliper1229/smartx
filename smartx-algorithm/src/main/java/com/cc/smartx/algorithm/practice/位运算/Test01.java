package com.cc.smartx.algorithm.practice.位运算;

/**
 * @Description
 * @Author chenlipeng
 * @Date 2021/10/29 2:23 下午
 */
public class Test01 {

    // 两数相除

    // 两数相加 = 无进位相加信息 + 进位信息，直到进位信息为0
    // 无进位相加信息 = a和b异或，a ^ b
    // 进位信息 = a与上b左移一位，(a & b) << 1
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            // 无进位相加
            sum = a ^ b;
            // 进位信息
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    /**
     * https://www.cnblogs.com/tianzhenaichirou/p/14612982.html
     *
     * @param args
     */
    public static void main(String[] args) {
        // Integer.toBinaryString()返回的是补码，正数高位的0默认不打印，负数打印符号位1
        // 左移（<<）
        // 右移（>>） 无符号右移（>>>）
        // 位移运算，都是基于补码来做错的，位移完成，转换成原码
        // 补码 - 1，取反 ===>>> 原码

        // 10000000 00000000 00000000 00111100 [-60原码] [真实数字]
        // 11111111 11111111 11111111 11000011 [-60反码]
        // 11111111 11111111 11111111 11000100 [-60补码] [计算机存储]
        int i = -60;
        System.out.println("-60：" + Integer.toBinaryString(i));

        // 1 1111111 11111111 11111111 11000100 [-60补码]
        // 1 1111111 11111111 11111111 11111100 [-60补码 -> 右移4位, 高位补1]
        // 1 1111111 11111111 11111111 11111011 [-60补码 -> 右移4位, 高位补1 -> -1]
        // 1 0000000 00000000 00000000 00000100 [-60补码 -> 右移4位, 高位补1 -> -1 -> 取反]
        System.out.println("-60 >> 4：" + (i >> 4));
        System.out.println("-60 >> 4：" + Integer.toBinaryString(i >> 4));

        // 1 1111111 11111111 11111111 11000100 [-60补码]
        // 0 0001111 11111111 11111111 11111100 [-60补码 -> 右移4位, 高位补0]
        // 0 0001111 11111111 11111111 11111100 [补码 = 原码 = 反码]
        // 0 0001111 11111111 11111111 11111100 [补码 = 原码 = 反码]
        System.out.println("-60 >>> 4：" + (i >>> 4));
        System.out.println("-60 >>> 4：" + Integer.toBinaryString(i >>> 4));

        // 0 1111111 11111111 11111111 11111111 [补码]
        // 0 1111111 11111111 11111111 11111111 [补码 = 原码 = 反码]
        // 0 1111111 11111111 11111111 11111111 [补码 = 原码 = 反码]
        System.out.println("Integer.MAX_VALUE：" + Integer.MAX_VALUE);
        System.out.println("Integer.MAX_VALUE：" + Integer.toBinaryString(Integer.MAX_VALUE));

        // 1 0000000 00000000 00000000 00000000 [补码]
        // 1 1111111 11111111 11111111 11111111 [补码 -> 补码-1] ?
        System.out.println("Integer.MIN_VALUE：" + Integer.MIN_VALUE);
        System.out.println("Integer.MIN_VALUE：" + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("Math.abs(Integer.MIN_VALUE)：" + Math.abs(Integer.MIN_VALUE));

        System.out.println(~i + 1);

    }


}
