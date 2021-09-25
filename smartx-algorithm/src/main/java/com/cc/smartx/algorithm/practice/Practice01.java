package com.cc.smartx.algorithm.practice;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @description: 字符串操作
 * @Author chenlipeng
 * @Date 2021-01-10
 */
public class Practice01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            String input = scanner.next();
//            scanner.nextBigDecimal();
//            scanner.nextInt();
//            scanner.nextLong();
//
//            scanner.nextLine();
//            scanner.hasNext();
//            scanner.hasNextLine();
//            scanner.hasNextBigDecimal();
//
//            System.out.println(input);
//        }

//        while (scanner.hasNext()) {
//            String input = scanner.next(); //以空格作为分割符
//            System.out.println(input);
//        }

        while (scanner.hasNextLine()) {
            String input = scanner.next(); //以换行作为分割符
            // 接收多个参数
            String input2 = scanner.next();
            String[] strArr = input.split(",");

            //处理逻辑
            System.out.println(input);
            System.out.println(input2);

            //System.arraycopy
            char[] chars = input.toCharArray();
            //System.arraycopy input -> dst
            char[] dst = new char[100];
            input.getChars(0,2 ,dst, 0);

            char[] chars2 = new char[input.length()];
            for (int i = 0; i < input.length(); i++) {
                //charAt
                chars2[i] = input.charAt(i);
            }
            byte[] bytes = input.getBytes();

            int length = input.length();

            String lowerCase = input.toLowerCase();
            String upperCase = input.toUpperCase();

            //比较字典顺序
            //input.compareTo();
            //input.compareToIgnoreCase();

            // indexOf
            boolean contains = input.contains("a");
            int indexOf = input.indexOf("a");
            int lastIndexOf = input.lastIndexOf("a");
            boolean empty = input.isEmpty();

            boolean startsWith = input.startsWith("a");
            boolean endsWith = input.endsWith("a");
            //返回一个新的字符串，不改变原字符串
            String replace = input.replace('z', 'Z');
            String replaceAll = input.replaceAll("zzz", "ZZZ");
            String replaceFirst = input.replaceFirst("z", "Z");

            int codePointAt = input.codePointAt(0);
            int codePointBefore = input.codePointBefore(5);
            int count = input.codePointCount(0, 5);
            IntStream intStream = input.codePoints();

        }

    }

    // 字母 数字
    public boolean isAlphanumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
                || (ch >= 0 && ch <= 9);
    }

    // 大写+32 = 小写
    // 大写转小写
    public boolean isEqualsIgnoreCase(char ch1, char ch2) {
        if (ch1 >= 'A' && ch1 <= 'Z') {
            ch1 += 32;
        }
        if (ch2 >= 'A' && ch2 <= 'Z') {
            ch2 += 32;
        }
        return ch1 == ch2;
    }


}
