/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (39.65%)
 * Likes:    557
 * Dislikes: 157
 * Total Accepted:    144.7K
 * Total Submissions: 363.2K
 * Testcase Example:  '[1,3,5]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5]
 * Output: 1
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,2,0,1]
 * Output: 0
 * 
 * Note:
 * 
 * 
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int res = nums[0];
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[left]) return nums[left];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid+1]) return nums[mid+1];

            if (nums[mid] > nums[left]) {
                res = Math.min(res, nums[left]);
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left += 1;
            }
        }

        return res;
    }
}
// @lc code=end
