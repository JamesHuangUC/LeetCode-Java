/*
 * @lc app=leetcode id=159 lang=java
 *
 * [159] Longest Substring with At Most Two Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
 *
 * algorithms
 * Hard (47.91%)
 * Likes:    628
 * Dislikes: 13
 * Total Accepted:    80.9K
 * Total Submissions: 168.7K
 * Testcase Example:  '"eceba"'
 *
 * Given a string s , find the length of the longest substring t  that contains
 * at most 2 distinct characters.
 * 
 * Example 1:
 * 
 * 
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 * 
 */

// @lc code=start
// class Solution {
//     public int lengthOfLongestSubstringTwoDistinct(String s) {
//         int res = 0;
//         int left = 0;
//         Map<Character, Integer> hm = new HashMap<>();

//         for (int i = 0; i < s.length(); i++) {
//             char curChar = s.charAt(i);
//             hm.put(curChar, hm.getOrDefault(curChar, 0) + 1);
//             while (hm.size() > 2) {
//                 char leftChar = s.charAt(left);
//                 hm.put(leftChar, hm.get(leftChar) - 1);
//                 if (hm.get(leftChar) == 0)
//                     hm.remove(leftChar);
//                 left += 1;
//             }

//             res = Math.max(res, i - left + 1);
//         }

//         return res;
//     }
// }

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;
        int curLen = 0, cntSecond = 0;
        char first = ' ';
        char second = ' ';

        for (char c : s.toCharArray()) {
            curLen = (c == first || c == second) ? curLen + 1 : cntSecond + 1;
            cntSecond = (c == second) ? cntSecond + 1 : 1;
            if (c != second) {
                first = second;
                second = c;
            }
            res = Math.max(res, curLen);
        }

        return res;
    }
}
// @lc code=end

