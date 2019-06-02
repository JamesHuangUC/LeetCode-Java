/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (25.35%)
 * Likes:    1830
 * Dislikes: 89
 * Total Accepted:    190.8K
 * Total Submissions: 747.9K
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * 
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * 
 */
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        Stack<Integer> st = new Stack<>();
        int res = 0;
        int leftMost = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (st.isEmpty()) {
                    leftMost = i;
                } else {
                    st.pop();
                    if (st.isEmpty()) {
                        res = Math.max(res, i-leftMost);
                    } else {
                        res = Math.max(res, i-st.peek());
                    }
                }
            }
        }

        return res;
    }
}

