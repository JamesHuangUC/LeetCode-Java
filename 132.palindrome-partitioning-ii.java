/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 *
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 *
 * algorithms
 * Hard (27.98%)
 * Likes:    689
 * Dislikes: 24
 * Total Accepted:    110.3K
 * Total Submissions: 391K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using
 * 1 cut.
 * 
 * 
 */
class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        boolean[][] isPalindrome = new boolean[n][n];
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (i+1 > j-1 || isPalindrome[i+1][j-1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (isPalindrome[j][i-1]) {
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }

        return dp[n];
    }
}

