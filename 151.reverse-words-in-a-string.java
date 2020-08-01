/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (17.41%)
 * Likes:    661
 * Dislikes: 2429
 * Total Accepted:    314.1K
 * Total Submissions: 1.8M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string, reverse the string word by word.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a
 * single space in the reversed string.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * For C programmers, try to solve it in-place in O(1) extra space.
 */

// @lc code=start
// class Solution {
//     public String reverseWords(String s) {
//         String trimStr = s.trim();
//         String[] strArr = trimStr.split("\\s+");
//         StringBuilder sb = new StringBuilder();

//         for (int i = strArr.length - 1; i >= 1; i--) {
//             sb.append(strArr[i] + " ");
//         }
//         sb.append(strArr[0]);

//         return sb.toString();
//     }
// }


// class Solution {
//     public String reverseWords(String s) {
//         String[] words = s.trim().split(" +");
//         Collections.reverse(Arrays.asList(words));
//         return String.join(" ", words);
//     }
// }

class Solution {
    public String reverseWords(String s) {
        int start = 0, end = 0;
        int n = s.length();
        String res = "";
        
        while (start < n) {
            while (start < n && s.charAt(start) == ' ') start += 1;
            if (start == n) break;
            end = start + 1;
            while (end < n && s.charAt(end) != ' ') end += 1;
            if (res.length() == 0) res = s.substring(start, end);
            else res = s.substring(start, end) + " " + res;
            start = end + 1;
        }

        return res;
    }
}
// @lc code=end

