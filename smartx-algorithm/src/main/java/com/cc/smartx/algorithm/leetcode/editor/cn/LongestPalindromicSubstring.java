//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3114 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 最长回文子串
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String s = "babad";
        String palindrome = solution.longestPalindrome2(s);
        System.out.println(palindrome);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null) {
                return null;
            }
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expendAroundCenter(s, i, i);
                int len2 = expendAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start + 1) {
                    start = i - (len - 1) / 2;
                    end  = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        public int expendAroundCenter(String s, int l, int r) {
            while (l > 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return r - l + 1;
        }

        public String longestPalindrome2(String s) {
            if (s == null || s.length() == 0) return null;
            int start =0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expendAroundCenter2(s, i, i);
                int len2 = expendAroundCenter2(s, i, i + 1);
                int len = Math.max(len1, len2);
                // babad
                if (len > end - start + 1) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            // 左闭右开
            return s.substring(start, end + 1);
        }

        // 从l和r开始向两次扩展的最大长度
        public int expendAroundCenter2(String s, int l, int r) {
            while (l > 0 && r < s.length()
                    && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return r - l - 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}