//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 2150 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            int curr = nums[i];
            if (i > 0 && nums[i - 1] == curr) {
                continue;
            }
            if (((long) curr + nums[n - 1] + nums[n - 2] + nums[n - 3]) < target) {
                continue;
            }
            if (((long) curr + nums[i + 1] + nums[i + 2] + nums[i + 3]) > target) {
                break;
            }
            for (int j = i + 1; j < n - 2; j++) {
                int next = nums[j];
                if (j > i + 1 && nums[j - 1] == next) {
                    continue;
                }
                if (((long) curr + next + nums[n - 1] + nums[n - 2]) < target) {
                    continue;
                }
                if (((long) curr + next + nums[j + 1] + nums[j + 2]) > target) {
                    break;
                }
                int l = j + 1, r = n - 1;
                long remain = (long) target - curr - next;
                while (l < r) {
                    int left = nums[l];
                    int right = nums[r];
                    int sum = left + right;
                    if (sum > remain) {
                        r--;
                    } else if (sum < remain) {
                        l++;
                    } else {
                        result.add(Arrays.asList(curr, next, left, right));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                        l++;
                    }
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
