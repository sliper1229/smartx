//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5141 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        int abcabcbb = solution.lengthOfLongestSubstring2("abcabcbb");
        System.out.println(abcabcbb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            return max;
        }

        // T:O(N) S:O(N)
        public int lengthOfLongestSubstring2(String s) {
            if (s == null || s.length() == 0) return 0;
            int n = s.length();
            HashMap<Character, Integer> map = new HashMap<>(); // key=char value=index
            int left = 0;
            int maxLen = 0;

            for (int i = 0; i < n; i++) { // 0 ~ n
                if (map.containsKey(s.charAt(i))) {
                    left = map.get(s.charAt(i)) + 1;
                }
                map.put(s.charAt(i), i);
                maxLen = Math.max(maxLen, i - left + 1);
            }

            return maxLen;
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

}