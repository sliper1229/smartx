//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 468 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 回文子串个数
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        String input = "aaa";
        int count = solution.countSubstrings(input);
        int count2 = solution.countSubstrings2(input);
        int countSubstringsDp = solution.countSubstringsDp(input);
        System.out.println(count);
        System.out.println(count2);
        System.out.println(countSubstringsDp);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 方法一：暴力求解
        public int countSubstrings(String s) {
            if (s == null) {
                return 0;
            }

            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String substring = s.substring(i, j);
                    String reverse = new StringBuilder(substring).reverse().toString();
                    if (substring.equals(reverse)) {
                        count++;
                    }
                }
            }

            return count;
        }

        // 方法二：中心扩展法
        public int countSubstrings2(String s) {
            if (s == null) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                count += expend(s, i, i);
                count += expend(s, i, i + 1);
            }
            return count;
        }

        private int expend(String s, int left, int right) {
            int count = 0;
            while (left >= 0 && right < s.length()
                    && s.charAt(left--) == s.charAt(right++)) {
                count++;
            }
            return count;
        }

        public int countSubstringsDp(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int count = 0;
            int n = s.length();
            boolean[][] dp = new boolean[n][n];

            for (int i = n - 1; i >= 0; i--) { // n-1 ~ 0
                for (int j = i; j < n; j++) { // i ~ n
                    if (i == j) {
                        dp[i][j] = true;
                    } else if (i + 1 == j && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] ? true : false;
                    }
                    if (dp[i][j]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}