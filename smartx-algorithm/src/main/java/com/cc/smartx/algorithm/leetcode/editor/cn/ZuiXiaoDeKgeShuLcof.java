//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 178 👎 0

package com.cc.smartx.algorithm.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 */
public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();

        int[] arr = {2, 4, 3, 7, 6, 2};
        int[] leastNumbers = solution.getLeastNumbers(arr, 4);
        int[] leastNumbers2 = solution.getLeastNumbers2(arr, 4);

        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.print(leastNumbers[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < leastNumbers2.length; i++) {
            System.out.print(leastNumbers2[i] + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {

            int[] res = new int[k];

            PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int i = 0; i < k; i++) {
                heap.add(arr[i]);
            }

            for (int i = k; i < arr.length; i++) {
                if (arr[i] < heap.peek()) {
                    heap.poll();
                    heap.add(arr[i]);
                }
            }

            for (int i = 0; i < k; i++) {
                res[i] = heap.poll();
            }

            return res;
        }

        public int[] getLeastNumbers2(int[] arr, int k) {
            int[] res = new int[k];

            process(arr, 0, arr.length - 1, k);

            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }

            return res;
        }

        // arr[l...r] 上找第k大的位置
        // 快排：不规则的二分么？？？
        private void process(int[] arr, int l, int r, int k) {
            if (l < r) {
                swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
                int p = partition(arr, l, r);

                // num: 区间上的第k个数
                int num = p - l + 1; // important key

                if (num == k) {
                    return;
                } else if (num < k) {
                    process(arr, p + 1, r, k - num);
                } else {
                    process(arr, l, p, k);
                }
            }
        }
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int less = l - 1;

        for (int i = l; i < r; i++) { // 不用 i < more
            if (arr[i] < pivot) {
                swap(arr, ++less, i);
            }
        }

        swap(arr, less + 1, r);

        return less;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//leetcode submit region end(Prohibit modification and deletion)

}