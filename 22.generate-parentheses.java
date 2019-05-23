/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (54.52%)
 * Likes:    2708
 * Dislikes: 170
 * Total Accepted:    336.2K
 * Total Submissions: 613.5K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    void dfs(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            dfs(n, left + 1, right, sb.append("("), res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            dfs(n, left, right + 1, sb.append(")"), res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb, res);
        return res;
    }
}

