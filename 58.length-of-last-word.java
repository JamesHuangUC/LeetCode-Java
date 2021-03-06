/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.25%)
 * Likes:    382
 * Dislikes: 1617
 * Total Accepted:    275.4K
 * Total Submissions: 853.3K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * 
 * Input: "Hello World"
 * Output: 5
 * 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLastWord(String s) {
        // return s.trim().length() - 1 - s.trim().lastIndexOf(" ");
        if (s.length() == 0) return 0;
        int right = s.length()-1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right -= 1;
        }
        int res = 0;
        while (right >= 0 && s.charAt(right) != ' ') {
            right -= 1;
            res += 1;
        }

        return res;
    }
}

