//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4572 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 寻找两个正序数组的中位数
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int total = nums1.length + nums2.length;
            // 奇数
            if ((total & 1) == 1) {
                return findKthSmallestInSortedArrays(nums1, nums2, total / 2 + 1);
            } else {
                double a = findKthSmallestInSortedArrays(nums1, nums2, total / 2);
                double b = findKthSmallestInSortedArrays(nums1, nums2, total / 2 + 1);
                return (a + b) / 2;
            }
        }


        // 1 2 6 7 9
        // 3 4 5 7 9
        // k = 4
        // 谁小排除掉谁
        // 1、在原两个数组中找第4小，排除掉1个之后
        // 2、剩下的元素中，找第2小，排除1个之后
        // 3、在剩下的元素中，找第1小
        // 整个过程下来。找到在整体上的第k小的数
        public double findKthSmallestInSortedArrays(int[] nums1, int[] nums2, int k) {
            // 数组剩余长度
            int len1 = nums1.length, len2 = nums2.length;
            // 两个指针，不停往右移 base1 + i = 下一个base1的位置
            int base1 = 0, base2 = 0;

            while (true) {
                // 终止条件，任意一个数组剩余长度为01，即没有元素了
                if (len1 == 0) return nums2[base2 + k - 1];
                if (len2 == 0) return nums1[base1 + k - 1];
                // 终止条件，k=1时，谁小取谁
                if (k == 1) return Math.min(nums1[base1], nums2[base2]);

                // base1和base2分别移动的长度
                int i = Math.min(k / 2, len1);
                int j = Math.min(k - i, len2);
                int a = nums1[base1 + i - 1];
                int b = nums2[base2 + j - 1];

                // 终止条件，如果取的元素和刚好等于k，且正好相等，直接返回其中一个
                if (i + j == k && a == b) return a;

                // 谁小移动谁
                if (a <= b) {
                    base1 += i;
                    len1 -= i;
                    k -= i;
                }
                if (a >= b) {
                    base2 += j;
                    len2 -= j;
                    k -= j;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}