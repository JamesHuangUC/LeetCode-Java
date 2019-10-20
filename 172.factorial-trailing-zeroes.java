/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 *
 * algorithms
 * Easy (37.63%)
 * Likes:    564
 * Dislikes: 812
 * Total Accepted:    174.4K
 * Total Submissions: 463.5K
 * Testcase Example:  '3'
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Example 1:
 * 
 * 
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            res += n / 5;
            n = n / 5;
        }
        return res;
    }
}
// @lc code=end

