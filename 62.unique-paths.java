/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (47.33%)
 * Likes:    1657
 * Dislikes: 115
 * Total Accepted:    299.6K
 * Total Submissions: 623.9K
 * Testcase Example:  '3\n2'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 7, n = 3
 * Output: 28
 * 
 */
// class Solution {
//     void helper(int[][] memo) {
//         for (int c = 0; c < memo[0].length; c++) {
//             memo[0][c] = 1;
//         }
//         for (int r = 0; r < memo.length; r++) {
//             memo[r][0] = 1;
//         }

//         for (int r = 1; r < memo.length; r++) {
//             for (int c = 1; c < memo[0].length; c++) {
//                 memo[r][c] = memo[r-1][c] + memo[r][c-1];
//             }
//         }
//     }

//     public int uniquePaths(int m, int n) {
//         int[][] memo = new int[n][m];
//         helper(memo);
//         return memo[n-1][m-1];
//     }
// }

class Solution {
    void helper(int[][] memo) {
        for (int c = 0; c < memo[0].length; c++) {
            memo[0][c] = 1;
        }
        for (int r = 0; r < memo.length; r++) {
            memo[r][0] = 1;
        }

        for (int r = 1; r < memo.length; r++) {
            for (int c = 1; c < memo[0].length; c++) {
                memo[r][c] = memo[r - 1][c] + memo[r][c - 1];
            }
        }
    }

    public int uniquePaths(int m, int n) {
        int[] memo = new int[m];
        Arrays.fill(memo, 1);
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                memo[c] += memo[c-1];
            }
        }

        return memo[memo.length-1];
    }
}
