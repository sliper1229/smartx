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
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            List<List<Integer>> ans = new ArrayList<>();
            process(list, 0, ans);
            return ans;
        }

        // xx 在[index.....]需要做决定
        // xx在index位置做好决定
        // xx 在[index+1.....]需要做决定
        // 回复index位置的现场

        // nums在[index.....]需要做决定, 最终做好决定的结果放在ans里
        private void process(List<Integer> nums, int index, List<List<Integer>> ans) {
            // base case : 越界
            if (index == nums.size()) {
                // 注意点：这里必须新建一个List
                List<Integer> cur = new ArrayList<>(nums);
                ans.add(cur);
            } else {
                for (int i = index; i < nums.size(); i++) {
                    // 在index位置做好决定
                    Collections.swap(nums, index, i);
                    // 在[index+1.....]需要做决定
                    process(nums, index + 1, ans);
                    // 恢复现场
                    Collections.swap(nums, index, i);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}