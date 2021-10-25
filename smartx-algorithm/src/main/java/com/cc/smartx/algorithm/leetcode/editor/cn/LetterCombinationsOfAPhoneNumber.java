//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1567 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public final char[][] phone = {
                {'a', 'b', 'c'}, // 2    0
                {'d', 'e', 'f'}, // 3    1
                {'g', 'h', 'i'}, // 4    2
                {'j', 'k', 'l'}, // 5    3
                {'m', 'n', 'o'}, // 6
                {'p', 'q', 'r', 's'}, // 7
                {'t', 'u', 'v'},   // 8
                {'w', 'x', 'y', 'z'}, // 9
        };

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return new ArrayList<>();
            List<String> ans = new ArrayList<>();
            char[] chars = digits.toCharArray();
            char[] path = new char[digits.length()];
            process(chars, 0, path, ans);
            return ans;
        }

        // str = ['2','3']  3   3
        // str[....index-1]，按出的结果是什么都在path里
        // str[index...]  当前按完index位置之后，有哪些组合，放入到ans里
        public void process(char[] str, int index, char[] path, List<String> ans) {
            if (index == str.length) {
                ans.add(String.valueOf(path));
            } else {
                char[] cands = phone[str[index] - '2'];
                for (char cur : cands) {
                    // 深度优先遍历
                    path[index] = cur; // 入递归栈
                    process(str, index + 1, path, ans);
                }
            }
        }

        public void process2(char[] str, int index, char[] path, List<String> ans) {
            if (index == str.length) {
                ans.add(new String(path));
            } else {
                char[] cands = phone[str[index] - '2'];
                for (char cur : cands) {
                    path[index] = cur;
                    process2(str, index + 1, path, ans);
                }
            }
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}