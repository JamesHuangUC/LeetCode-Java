/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (36.10%)
 * Likes:    2659
 * Dislikes: 141
 * Total Accepted:    383.1K
 * Total Submissions: 1M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */
// class Solution {
//     boolean helper(String s, Set<String> hs, int[] memo, int start) {
//         if (start == s.length()) return true;
//         if (memo[start] != -1) return memo[start] == 1;
        
//         for (int i = start + 1; i <= s.length(); i++) {
//             if (hs.contains(s.substring(start, i)) && helper(s, hs, memo, i)) {
//                 memo[start] = 1;
//                 return true;
//             }
//         }
//         memo[start] = 0;
//         return false;
//     }

//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> hs = new HashSet<>();
//         for (String word : wordDict) hs.add(word);
//         int[] memo = new int[s.length()];
//         Arrays.fill(memo, -1);
//         return helper(s, hs, memo, 0);
//     }
// }


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>();
        for (String word : wordDict) hs.add(word);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hs.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}

