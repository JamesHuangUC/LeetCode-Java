/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.40%)
 * Likes:    1333
 * Dislikes: 1283
 * Total Accepted:    457.6K
 * Total Submissions: 1.4M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs.length == 0)
//             return "";
//         if (strs.length == 1)
//             return strs[0];
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < strs[0].length(); i++) {
//             char a = strs[0].charAt(i);
//             for (int j = 1; j < strs.length; j++) {
//                 if (i >= strs[j].length() || a != strs[j].charAt(i)) {
//                     return sb.toString();
//                 }
//             }
//             sb.append(a);
//         }
//         return sb.toString();
//     }
// }

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        int minLen = Math.min(strs[0].length(), strs[strs.length-1].length());
        int i = 0;
        while (i < minLen) {
            if (strs[0].charAt(i) == strs[strs.length-1].charAt(i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
            i += 1;
        }
        return sb.toString();
    }
}

