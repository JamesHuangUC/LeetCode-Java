/*
 * @lc app=leetcode id=186 lang=java
 *
 * [186] Reverse Words in a String II
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
 *
 * algorithms
 * Medium (39.59%)
 * Likes:    323
 * Dislikes: 86
 * Total Accepted:    72.7K
 * Total Submissions: 183.6K
 * Testcase Example:  '["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]'
 *
 * Given an input string , reverse the string word by word. 
 * 
 * Example:
 * 
 * 
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 
 * Note: 
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * 
 * 
 * Follow up: Could you do it in-place without allocating extra space?
 * 
 */

// @lc code=start
class Solution {
    void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left += 1;
            right -= 1;
        }
    }

    public void reverseWords(char[] s) {
        for (int i = 0, left = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, left, i - 1);
                left = i + 1;
            }
        }
        reverse(s, 0, s.length - 1);
    }
}
// @lc code=end

