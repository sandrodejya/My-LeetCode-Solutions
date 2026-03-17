//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2923 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargestHelper(nums, k, 0, nums.length - 1);
    }

    private int findKthLargestHelper(int[] nums, int k, int left, int right) {
        int pivot = partition(nums, left, right);
        if (pivot == nums.length - k) {
            return nums[pivot];
        } else if (pivot < nums.length - k) {
            return findKthLargestHelper(nums, k, pivot + 1, right);
        } else {
            return findKthLargestHelper(nums, k, left, pivot - 1);
        }
    }

    private int partition(int[] nums, int left, int right) {

        int randomIndex = left + (int)(Math.random() * (right - left + 1));

        int swapTemp = nums[left];
        nums[left] = nums[randomIndex];
        nums[randomIndex] = swapTemp;

        int pivot = nums[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[left] = nums[i];
        nums[i] = pivot;
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
