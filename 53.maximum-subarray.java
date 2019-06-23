/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (43.41%)
 * Likes:    4422
 * Dislikes: 154
 * Total Accepted:    548.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int currMax = nums[0];
//         int res = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             currMax = Math.max(nums[i], currMax+nums[i]);
//             res = Math.max(res, currMax);
//         }
//         return res;
//     }
// }

class Solution {
    int helper(int[] nums, int left, int right) {
        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int mid = left + (right - left) / 2;
        
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        for (int i = mid+1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        sum = leftSum + rightSum;
        return sum;
    }

    int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        return Math.max(Math.max(maxSubArrayHelper(nums, left, mid),
            maxSubArrayHelper(nums, mid+1, right)),
            helper(nums, left, right));
    }

    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length-1);
    }
}
