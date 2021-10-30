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
     * @param args
     */
    public static void main(String[] args) {

        // Integer.toBinaryString()显示时，正数高位的0默认不打印，负数则会打印出符号位1
        // 右移(>>)
        // 无符号右移(>>>)

        int i = 6;
        //6的二进制是110
        System.out.println("i：" + Integer.toBinaryString(i));
        //6向左移1位后，变成1100，对应的10进制是12
        System.out.println("无符号左移：" + Integer.toBinaryString(i << 1));
        System.out.println("无符号左移：" + (i << 1));

        int j = -2147483648;
        //-2147483648的二进制是10000000000000000000000000000000
        System.out.println("j：" + Integer.toBinaryString(j));
        System.out.println("无符号左移：" + Integer.toBinaryString(j << 1));
        System.out.println("无符号左移：" + (j << 1));

        System.out.println("========================");

        //6的二进制是110
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i >> 1));
        //6向右移1位后，变成11，对应的10进制是3
        System.out.println(i >> 1);

        j = -2147483648;
        //-2147483648的二进制是
        //10000000000000000000000000000000
        System.out.println(Integer.toBinaryString(j));
        System.out.println(Integer.toBinaryString((j >> 1) >> 1));//右移两位还是负数
        //11100000000000000000000000000000
        System.out.println((j >> 1) >> 1);
        //-536870912

        System.out.println("=====================");

        j = -2147483648;
        //-2147483648的二进制是
        //10000000000000000000000000000000
        System.out.println(Integer.toBinaryString(j));
        System.out.println(Integer.toBinaryString((j >>> 1) >>> 1));//负数变为正数
        //100000000000000000000000000000    此时首位的两个0省略不显示
        System.out.println((j >>> 1) >>> 1);
        //536870912

    }


}
