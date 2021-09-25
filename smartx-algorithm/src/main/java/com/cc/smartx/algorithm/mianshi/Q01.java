package com.cc.smartx.algorithm.mianshi;

/**
 * @description: 两数相加
 * @Author chenlipeng
 * @Date 2021-01-24
 */
public class Q01 {

    public static String addTwoString(String str1, String str2) {
        if(str1.length() > str2.length()) {
            for(int i = 0; i < str1.length() - str2.length(); i++) {
                str2 = "0" + str2;
            }
        }

        if(str2.length() > str1.length()) {
            for(int i = 0; i < str2.length() - str1.length(); i++) {
                str1 += "0" + str1;
            }
        }

        int n = Math.max(str1.length(), str2.length());

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = n - 1; i >= 0; i--) {
            int num1 = Integer.valueOf(str1.charAt(i) - '0');
            int num2 = Integer.valueOf(str2.charAt(i) - '0');
            int sum = num1 + num2;
            if(flag) {
                sum = sum +1;
            }
            if(sum > 9) {
                flag = true;
                sb.append(String.valueOf((sum % 10)));
            } else {
                flag = false;
                sb.append(String.valueOf(sum));
            }
        }

        if(flag) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
