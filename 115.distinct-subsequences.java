/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 *
 * https://leetcode.com/problems/distinct-subsequences/description/
 *
 * algorithms
 * Hard (35.53%)
 * Likes:    766
 * Dislikes: 39
 * Total Accepted:    112.4K
 * Total Submissions: 315.5K
 * Testcase Example:  '"rabbbit"\n"rabbit"'
 *
 * Given a string S and a string T, count the number of distinct subsequences
 * of S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Example 1:
 * 
 * 
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 * 
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 * 
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 * 
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 * 
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ⁠ ^  ^^
 * babgbag
 * ⁠   ^^^
 * 
 * 
 */
class Solution {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[tLen+1][sLen+1];
        for (int col = 0; col < dp[0].length; col++) {
            dp[0][col] = 1;
        }
        
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                if (s.charAt(col-1) == t.charAt(row-1)) {
                    dp[row][col] = dp[row-1][col-1] + dp[row][col-1];
                } else {
                    dp[row][col] = dp[row][col-1];
                }
            }
        }

        return dp[tLen][sLen];
    }
}

