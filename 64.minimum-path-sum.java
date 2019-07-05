/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (46.57%)
 * Likes:    1434
 * Dislikes: 41
 * Total Accepted:    239.2K
 * Total Submissions: 504.5K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        
        dp[0][0] = grid[0][0];
        // left most column
        for (int r = 1; r < dp.length; r++) {
            dp[r][0] = grid[r][0] + dp[r-1][0];
        }
        // top row
        for (int c = 1; c < dp[0].length; c++) {
            dp[0][c] = grid[0][c] + dp[0][c-1];
        }

        for (int r = 1; r < grid.length; r++) {
            for (int c = 1; c < grid[0].length; c++) {
                dp[r][c] = grid[r][c] + Math.min(dp[r-1][c], dp[r][c-1]);
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}

