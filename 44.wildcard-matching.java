/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 *
 * https://leetcode.com/problems/wildcard-matching/description/
 *
 * algorithms
 * Hard (22.73%)
 * Likes:    1062
 * Dislikes: 73
 * Total Accepted:    178.6K
 * Total Submissions: 780.7K
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*'.
 * 
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like ? or *.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not
 * match 'b'.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*'
 * matches the substring "dce".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] arr = new boolean[p.length()+1][s.length()+1];
        arr[0][0] = true;
        for (int i = 1; i < p.length()+1; i++) {
            if (p.charAt(i-1) == '*') {
                arr[i][0] = arr[i-1][0];
            }
        }

        for (int pInd = 1; pInd < p.length()+1; pInd++) {
            for (int sInd = 1; sInd < s.length()+1; sInd++) {
                if (p.charAt(pInd-1) == s.charAt(sInd-1) || p.charAt(pInd-1) == '?') {
                    arr[pInd][sInd] = arr[pInd-1][sInd-1]; //top left
                } else {
                    if (p.charAt(pInd-1) == '*') {
                        // top or left
                        arr[pInd][sInd] = arr[pInd-1][sInd] || arr[pInd][sInd-1];
                    }
                }
            }
        }

        return arr[p.length()][s.length()];
    }
}

