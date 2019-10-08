/*
 * @lc app=leetcode id=161 lang=java
 *
 * [161] One Edit Distance
 *
 * https://leetcode.com/problems/one-edit-distance/description/
 *
 * algorithms
 * Medium (32.00%)
 * Likes:    458
 * Dislikes: 91
 * Total Accepted:    87.2K
 * Total Submissions: 272.5K
 * Testcase Example:  '"ab"\n"acb"'
 *
 * Given two strings s and t, determine if they are both one edit distance
 * apart.
 * 
 * Note: 
 * 
 * There are 3 possiblities to satisify one edit distance apart:
 * 
 * 
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * 
 * Example 3:
 * 
 * 
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 * 
 */

// @lc code=start
// class Solution {
//     public boolean isOneEditDistance(String s, String t) {
//         if (s.length() < t.length()) {
//             String temp = s;
//             s = t;
//             t = temp;
//         }
//         int sLen = s.length(), tLen = t.length();
//         int diff = sLen - tLen;

//         if (diff >= 2) {
//             return false;

//         } else if (diff == 1) {
//             for (int i = 0; i < tLen; i++) {
//                 if (s.charAt(i) != t.charAt(i)) {
//                     return s.substring(i + 1).equals(t.substring(i));
//                 }
//             }
//             return true;

//         } else {
//             int cnt = 0;
//             for (int i = 0; i < tLen; i++) {
//                 if (s.charAt(i) != t.charAt(i)) {
//                     cnt += 1;
//                     if (cnt > 1)
//                         return false;
//                 }
//             }
//             return cnt == 1;
//         }
//     }
// }


class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }
        }

        return Math.abs(s.length() - t.length()) == 1;
    }
}
// @lc code=end

