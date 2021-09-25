//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
//
//
// 示例 1:
//
// 输入: [7,5,6,4]
//输出: 5
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
// 👍 297 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

/**
 * 数组中的逆序对
 */
public class ShuZuZhongDeNiXuDuiLcof {

    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        int[] arr = new int[] {7,5,6,4};
        int count = solution.reversePairs(arr);
        System.out.println(count);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] arr) {
            if (arr == null || arr.length < 2) {
                return 0;
            }
            return process(arr, 0, arr.length - 1);
        }

        private int process(int[] arr, int l, int r) {
            if (l == r) {
                return 0;
            }

            int m = l + (r - l) / 2;

            int count1 = process(arr, l, m);

            int count2 = process(arr, m + 1, r);

            int count3 = merge(arr, l, m, r);

            return count1 + count2 + count3;

        }

        private int merge(int[] arr, int l, int m, int r) {
            int count = 0;
            int[] help = new int[r - l + 1];
            int i = 0;

            //3.
            int p1 = l; //[l, m]
            int p2 = m + 1; //[m+1, r]

            while (p1 <= m && p2 <= r) {
                // 改写归并 1.
                count += arr[p1] > arr[p2] ? (r - p2 + 1) : 0;
                help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
            }

            while (p1 <= m) {
                help[i++] = arr[p1++];
            }

            while (p2 <= r) {
                help[i++] = arr[p2++];
            }

            for (int j = 0; j < help.length; j++) {
                arr[l + j] = help[j]; // 2.
            }

            return count;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}