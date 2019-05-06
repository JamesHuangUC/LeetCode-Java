/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.13%)
 * Likes:    3470
 * Dislikes: 338
 * Total Accepted:    538.5K
 * Total Submissions: 2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int start = 0, maxLen = 0, n = s.length();
        int i = 0;
        while (i < n) {
            int left = i, right = i;

            while (right + 1 < n && s.charAt(right) == s.charAt(right + 1))
                right++;

            i = right + 1;

            while (left - 1 >= 0 && right + 1 < n && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                start = left;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
