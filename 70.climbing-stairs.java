/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (44.01%)
 * Likes:    2332
 * Dislikes: 86
 * Total Accepted:    426.6K
 * Total Submissions: 958.6K
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 */
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i++) {
            cur = cur + pre;
            pre = cur - pre;
        }
        return cur;
    }
}

// class Solution {
//     public int climbStairs(int n) {
//         if (n <= 2) return n;
//         int[] dp = new int[n+1];
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 2;
//         for (int i = 3; i <= n; i++) {
//             dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[n];
//     }
// }

