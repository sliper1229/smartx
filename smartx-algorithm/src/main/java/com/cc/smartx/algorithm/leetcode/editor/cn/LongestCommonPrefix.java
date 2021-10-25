//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1822 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            if (strs.length == 1) return strs[0];
            String first = strs[0];
            int index = 0;
            for (; index < first.length(); index++) {
                for (int i = 0; i < strs.length; i++) {
                    if (strs[i].length() <= index
                            || strs[i].charAt(index) != first.charAt(index)) {
                        return first.substring(0, index);
                    }
                }
            }
            return first;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}