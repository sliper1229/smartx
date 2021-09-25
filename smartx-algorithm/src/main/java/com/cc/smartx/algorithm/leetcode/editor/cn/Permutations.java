//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1087 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = solution.permute(nums);
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num: nums) {
                list.add(num);
            }

            List<List<Integer>> result = new ArrayList<>();
            permuteRec(list, 0, result);

            return result;
        }

        /**
         *
         * @param nums
         * @param start 需要做全排列子数组的开始下标
         * @param result
         */
        private void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
            if (start == nums.size()) {
//                result.add(new ArrayList<>(nums));
                result.add(nums);
            } else {
                for (int i = start; i < nums.size(); i++) {
                    Collections.swap(nums, start, i);
                    permuteRec(nums, start +1, result);
                    Collections.swap(nums, start, i);
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}