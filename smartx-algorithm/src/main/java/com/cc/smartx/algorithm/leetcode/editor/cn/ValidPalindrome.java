//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 314 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 验证回文串
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        // 不行，只适用于包含字母数字的情形
        boolean palindrome2 = solution.isPalindrome2("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
        System.out.println(palindrome2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // T: O(N)  S: O(1)
        public boolean isPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            for (; i < j; i++, j--) {
                while (i < j && !isAlphanumeric(s.charAt(i))) {
                    i++;
                }
                while (i < j && !isAlphanumeric(s.charAt(j))) {
                    j--;
                }
                if (!isEqualsIgnoreCase(s.charAt(i), s.charAt(j))) {
                    return false;
                }
            }
            return true;
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

        // 不行，只适用于包含字母数字的情形
        public boolean isPalindrome2(String s) {
            String reverse =  new StringBuilder(s).reverse().toString();
            return s.compareToIgnoreCase(reverse) == 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}