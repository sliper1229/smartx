//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2786 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 接雨水
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int N = height.length;
            int leftMax = height[0];
            int L = 1;
            int rightMax = height[N - 1];
            int R = N - 2;
            int water = 0;
            while (L <= R) {
                if (leftMax < rightMax) {
                    water += Math.max(0, leftMax - height[L]);
                    leftMax = Math.max(height[L++], leftMax);
                } else {
                    water += Math.max(0, rightMax - height[R]);
                    rightMax = Math.max(height[R--], rightMax);
                }


            }
            return water;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}