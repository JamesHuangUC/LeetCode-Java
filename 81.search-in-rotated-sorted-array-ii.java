/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (32.59%)
 * Likes:    716
 * Dislikes: 336
 * Total Accepted:    179.3K
 * Total Submissions: 548.5K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums
 * may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * 
 * 
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length-1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            } else if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid+1;
                }
            } else {
                left += 1;
            }
        }

        if (nums[left] == target) {
            return true;
        } else {
            return false;
        }
    }
}

