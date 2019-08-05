/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 *
 * https://leetcode.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (27.82%)
 * Likes:    850
 * Dislikes: 45
 * Total Accepted:    117.3K
 * Total Submissions: 411.3K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
 * s2.
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        
        for (int i = 0; i <= s3.length(); i++) {
            for (int s1Len = 0; s1Len <= i && s1Len <= s1.length(); s1Len++) {
                int s2Len = i - s1Len;
                if (s2Len > s2.length()) continue;
                if (s1Len > 0 && dp[s1Len-1][s2Len] && s3.charAt(i-1) == s1.charAt(s1Len-1)) {
                    dp[s1Len][s2Len] = true;
                } else if (s2Len > 0 && dp[s1Len][s2Len-1] && s3.charAt(i-1) == s2.charAt(s2Len-1)) {
                    dp[s1Len][s2Len] = true;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}

