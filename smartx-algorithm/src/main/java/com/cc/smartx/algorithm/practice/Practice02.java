package com.cc.smartx.algorithm.practice;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @description: StringBuilder
 * @Author chenlipeng
 * @Date 2021-01-10
 */
public class Practice02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.next(); //以换行作为分割符
            StringBuilder sb = new StringBuilder(input);
            //所有的操作都加锁
            StringBuffer sb2 = new StringBuffer(input);

            String toString = sb.toString();

            //Arrays.copyOf ->System.arraycopy
            //System.arraycopy
            //https://blog.csdn.net/gschen_cn/article/details/79345955
            sb.append("abc");

            //Arrays.copyOf
            sb.trimToSize();

            int indexOf = sb.indexOf("abc");
            int lastIndexOf = sb.lastIndexOf("abc");

            StringBuilder reverse = sb.reverse();

            //System.arraycopy
            sb.replace(0, sb.length(), "b");
        }

    }


}
