/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.06%)
 * Likes:    1066
 * Dislikes: 80
 * Total Accepted:    341.7K
 * Total Submissions: 750.6K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - closest);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int fix = nums[i];
            int left = i + 1, right = nums.length-1;
            while (left < right) {
                int sum = fix + nums[left] + nums[right];
                int newDiff = Math.abs(target - sum);
                if (newDiff < diff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (sum < target) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        return closest;
    }
}

