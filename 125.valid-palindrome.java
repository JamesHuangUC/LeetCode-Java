/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (31.89%)
 * Likes:    677
 * Dislikes: 1984
 * Total Accepted:    399K
 * Total Submissions: 1.2M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length-1;
        while (i < j) {
            while (i < arr.length && !Character.isLetterOrDigit(arr[i])){
                i += 1;
            }
            while (j >= 0 && !Character.isLetterOrDigit(arr[j])) {
                j -= 1;
            }
            if (i < arr.length && j >= 0 && Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j])) {
                return false;
            }
            i += 1;
            j -= 1;
        }

        return true;
    }
}

