//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1410 👎 0

package com.cc.smartx.algorithm.practice.滑动窗口.滑动窗口最大值.done;

/**
 * 最小覆盖子串
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int right = 0;
            int left = 0;
            int[] map = new int[256];
            int count = 0;
            for (int i = 0; i < t.length(); i++) {
                map[t.charAt(i)] += 1;
                count += 1;
            }
            // 记录结果
            int minLen = -1;
            int ansL = 0;
            int ansR = 0;

            // aaaaddaabc  abc
            for (; right < s.length(); right++) {
                if (map[s.charAt(right)] > 0) {
                    count--;
                }
                map[s.charAt(right)]--;

                // 什么时候移动窗口左边界？
                if (count == 0) {
                    // 小于0表示多余
                    while (map[s.charAt(left)] < 0) {
                        map[s.charAt(left)]++;
                        left++;
                    }
                    // 收集答案
                    if (minLen == -1 || minLen > right - left + 1) {
                        ansL = left;
                        ansR = right;
                        minLen = right - left + 1;
                    }

                    map[s.charAt(left)]++;
                    left++;
                    count++;
                }
            }
            return minLen == -1 ? "" : s.substring(ansL, ansR +1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}