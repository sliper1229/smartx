package com.cc.smartx.algorithm.leetcode.editor.cn;
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 数组 分治 动态规划 👍 433 👎 0

public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出: 6
        //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }

        public int maxSubArray2(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            //输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
            //输出: 6
            //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
            int max = Integer.MIN_VALUE;
            int cur = 0;
            for (int i = 0; i < arr.length; i++) {
                cur += arr[i];
                max = Math.max(max, cur);
                cur = Math.max(cur, 0);
            }
            return max;
        }

        public int maxSubArray3(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            int cur = 0;
            for (int i = 0; i < arr.length; i++) {
                cur += arr[i];
                max = Math.max(cur, max);
                cur = Math.max(cur, 0);
            }
            return max;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}