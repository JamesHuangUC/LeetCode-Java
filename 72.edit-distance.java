/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (37.41%)
 * Likes:    2220
 * Dislikes: 34
 * Total Accepted:    181.8K
 * Total Submissions: 473.9K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int r = 0; r <= word1.length(); r++) {
            for (int c = 0; c <= word2.length(); c++) {
                if (r == 0) {
                    dp[r][c] = c;
                } else if (c == 0) {
                    dp[r][c] = r;
                } else if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = 1 + Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}

