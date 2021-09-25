//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 278 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 反转字符串中的单词 III
 */
public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        String reverseWords = solution.reverseWords("Let's take LeetCode contest");
        System.out.println(reverseWords);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) return s;
            char[] ch = s.toCharArray();
            int n = s.length();
            int start = 0;
            int end = 0;
            while (start < n) {
                while (end < n && s.charAt(end) != ' ') end++;
                for (int i = start, j = end - 1; i < j; i++, j--) {
                    swap(ch, i, j);
                }
                start = end + 1;
                end = start;
            }
            return new String(ch);
        }

        private void swap(char[] ch, int i, int j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}