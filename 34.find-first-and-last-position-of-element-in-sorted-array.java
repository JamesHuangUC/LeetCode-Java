/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (33.44%)
 * Likes:    1570
 * Dislikes: 85
 * Total Accepted:    302.7K
 * Total Submissions: 901K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */
class Solution {
    int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        
        return res;
    }
}

