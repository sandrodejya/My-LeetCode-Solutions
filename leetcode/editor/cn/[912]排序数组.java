//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//解释：数组排序后，某些数字的位置没有改变（例如，2 和 3），而其他数字的位置发生了改变（例如，1 和 5）。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//解释：请注意，nums 的值不一定唯一。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 1205 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }

        int[] left = new int[nums.length / 2];
        int[] right = new int[nums.length - nums.length / 2];
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length / 2) {
                left[i] = nums[i];
                continue;
            }
            right[i - nums.length / 2] = nums[i];
        }

        left = sortArray(left);
        right = sortArray(right);

        int p = 0, q = 0, index = 0;
        int[] sortedArray = new int[nums.length];
        while (index < nums.length) {
            if (p >= left.length) {
                while (q < right.length) {
                    sortedArray[index++] = right[q++];
                }
            } else if (q >= right.length) {
                while (p < left.length) {
                    sortedArray[index++] = left[p++];
                }
            } else {
                int leftNum = left[p];
                int rightNum = right[q];
                int min = leftNum;
                if (rightNum < leftNum) {
                    min = rightNum;
                    q++;
                } else {
                    p++;
                }
                sortedArray[index++] = min;
            }
        }
        return sortedArray;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
