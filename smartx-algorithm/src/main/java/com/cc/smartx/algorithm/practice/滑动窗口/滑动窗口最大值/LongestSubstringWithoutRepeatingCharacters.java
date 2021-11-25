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

package com.cc.smartx.algorithm.practice.滑动窗口.滑动窗口最大值;

import java.util.Arrays;
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
            if (s == null || s.equals("") || s.length() == 0) return 0;
            // index[]索引数组  下标是字符、下标处的值表示在字符串中的位置
            int[] map = new int[256];
//            Arrays.fill(map, -1);
            for (int i = 0; i < 256; i++) {
                map[i] = -1;
            }

            int pre = -1; // -1
            int maxLen = 0;
            // 滑动窗口
            // i：滑动窗口的右边界 pre：滑动窗口的左边界
            for (int i = 0; i < s.length(); i++) {
                // abcad
                // map[s.charAt(i)]:表示当前字符出现的位置
                // 当前字符出现的位置在pre的后面，说明当前字符重复出现
                // 将左边界移动到当前位置的下一个位置
                pre = Math.max(map[s.charAt(i)], pre);
                maxLen = Math.max(maxLen, i - pre);
                map[s.charAt(i)] = i;
            }
            return maxLen;
        }

        public int lengthOfLongestSubstring3(String s) {
            if (s == null || s.length() == 0) return 0;
            int right = 0;
            int left = -1;
            int[] map = new int[256];
            Arrays.fill(map, -1);
            int maxLen = 0;

            //输入: s = "abcabcbb"
            //输出: 3
            //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
            // 找以每个数结尾的
            for (; right < s.length(); right++) {
                int index = s.charAt(right);
                left = Math.max(map[index], left);
                maxLen = Math.max(maxLen, right - left);
                map[index] = right;
            }
            return maxLen;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}