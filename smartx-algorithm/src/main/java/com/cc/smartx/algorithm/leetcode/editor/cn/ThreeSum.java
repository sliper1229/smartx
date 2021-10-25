//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3886 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // TO TEST
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 两数之和
        // 有序：左右指针
        // 无序：哈希表
        // [-1,0,1,2,-1,-4] [-4,-1,-1,0,1,2]
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            // 排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || nums[i - 1] != nums[i]) {
                    List<List<Integer>> twoSumList = twoSum(nums, i + 1, -nums[i]);
                    for (List<Integer> cur : twoSumList) {
                        // 注意用法
                        cur.add(0, nums[i]);
                        ans.add(cur);
                    }
                }
            }
            return ans;
        }

        // nums[begin......] 找和为target的两数组合
        public List<List<Integer>> twoSum(int[] nums, int begin, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            int l = begin;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    // 边界条件处理
                    if (l == begin || nums[l] != nums[l - 1]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ans.add(list);
                    }
                    l++;
                }
            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}