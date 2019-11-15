/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 *
 * https://leetcode.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (41.41%)
 * Likes:    3245
 * Dislikes: 111
 * Total Accepted:    393.8K
 * Total Submissions: 950.4K
 * Testcase Example:  '[1,2,3,1]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 2:
 * 
 * 
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house
 * 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * 
 */

// @lc code=start
// class Solution {
//     public int rob(int[] nums) {
//         if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
//         if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
//         int[] dp = new int[nums.length];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);

//         for (int i = 2; i < nums.length; i++) {
//             dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
//         }

//         return dp[nums.length - 1];
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int rob = 0, notRob = 0;
        int preRob = 0, preNotRob = 0;

        for (int i = 0; i < nums.length; i++) {
            preRob = rob;
            preNotRob = notRob;
            rob = Math.max(nums[i] + preNotRob, preRob);
            notRob = Math.max(preRob, preNotRob);
        }

        return Math.max(rob, notRob);
    }
}
// @lc code=end

