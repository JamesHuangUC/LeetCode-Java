/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 *
 * https://leetcode.com/problems/maximum-gap/description/
 *
 * algorithms
 * Hard (33.56%)
 * Likes:    605
 * Dislikes: 142
 * Total Accepted:    76.6K
 * Total Submissions: 228.4K
 * Testcase Example:  '[3,6,9,1]'
 *
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 * (3,6) or (6,9) has the maximum difference 3.
 * 
 * Example 2:
 * 
 * 
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * 
 * Note:
 * 
 * 
 * You may assume all elements in the array are non-negative integers and fit
 * in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        if (nums.length == 2) {
            return Math.abs(nums[0]-nums[1]);
        }
        
        int len = nums.length;
        int min = nums[0], max = nums[0];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        int gap = (int)Math.ceil((double)(max-min) / (len-1));
        if (gap == 0) return 0;
        int numBucket = (int)Math.floor((double)(max-min) / gap) +1;
        
        int[] bucketMin = new int[numBucket];
        int[] bucketMax = new int[numBucket];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == Integer.MIN_VALUE || num == Integer.MAX_VALUE) continue;
            int ind = (int)Math.floor((double)(num - min) / gap);
            bucketMin[ind] = Math.min(bucketMin[ind], num);
            bucketMax[ind] = Math.max(bucketMax[ind], num);
        }
        
        int res = 0, preMax = bucketMax[0];
        for (int i = 1; i < numBucket; i++) {
            if (bucketMin[i] != Integer.MAX_VALUE) {
                res = Math.max(res, bucketMin[i] - preMax);
                preMax = bucketMax[i];
            }
        }
        
        return res;
    }
}

// @lc code=end

