/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (40.24%)
 * Likes:    1271
 * Dislikes: 146
 * Total Accepted:    196K
 * Total Submissions: 484.2K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */
// class Solution {
//     int helper(List<List<Integer>> triangle, Integer[][] dp, int row, int col) {
//         if (row == triangle.size()-1) {
//             dp[row][col] = triangle.get(row).get(col);
//             return dp[row][col];
//         }
//         if (dp[row][col] == null) {
//             int sum = triangle.get(row).get(col) + Math.min(helper(triangle, dp, row+1, col), helper(triangle, dp, row+1, col+1));
//             dp[row][col] = sum;
//         }

//         return dp[row][col];
//     }

//     public int minimumTotal(List<List<Integer>> triangle) {
//         Integer[][] dp = new Integer[triangle.size()][triangle.size()];
//         return helper(triangle, dp, 0, 0);
//     }
// }

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        List<Integer> lastRow = triangle.get(triangle.size()-1);
        dp = lastRow.stream().mapToInt(i -> i).toArray();
        for (int row = triangle.size()-2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                dp[col] = Math.min(dp[col], dp[col+1]) + triangle.get(row).get(col);
            }
        }
        return dp[0];
    }
}
