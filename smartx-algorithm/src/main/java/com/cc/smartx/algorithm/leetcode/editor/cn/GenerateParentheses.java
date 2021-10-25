//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2107 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            char[] path = new char[n << 1];
            process(path, 0, 0, n, ans);
            return ans;
        }

        // path[....index - 1] 已经确定好
        // leftMinusRight 左括号使用个数-有括号使用个数
        // leftRest 左括号使用个数
        public void process(char[] path, int index,
                            int leftMinusRight, int leftRest, List<String> ans) {
            if (index == path.length) {
                ans.add(new String(path));
            } else {
                if (leftMinusRight > 0) {
                    path[index] = ')';
                    // 深度优先遍历, 产生多个分支
                    process(path, index + 1, leftMinusRight - 1, leftRest, ans);
                }
                if (leftRest > 0) {
                    path[index] = '(';
                    // 深度优先遍历, 产生多个分支
                    process(path, index + 1, leftMinusRight + 1, leftRest - 1, ans);
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}