/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (46.65%)
 * Likes:    951
 * Dislikes: 269
 * Total Accepted:    179.2K
 * Total Submissions: 380.7K
 * Testcase Example:  '[2,2,3,2]'
 *
 * Given a non-empty array of integers, every element appears three times
 * except for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,3,2]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 
 */
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;

        for (int num : nums) {
            b = (b ^ num) & ~a;
            a = (a ^ num) & ~b;
        }

        return b;
    }
}

