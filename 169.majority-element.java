/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (54.50%)
 * Likes:    2049
 * Dislikes: 179
 * Total Accepted:    449.2K
 * Total Submissions: 824.2K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0], cnt = 0;
        for (int num: nums) {
            if (cnt == 0) {
                res = num;
                cnt = 1;
            } else if (num == res) {
                cnt += 1;
            } else {
                cnt -= 1;
            }
        }

        return res;
    }
}
// @lc code=end

