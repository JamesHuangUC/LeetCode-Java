/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (32.95%)
 * Likes:    636
 * Dislikes: 382
 * Total Accepted:    181.3K
 * Total Submissions: 541.6K
 * Testcase Example:  '["2","1","+","3","*"]'
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Note:
 * 
 * 
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would
 * always evaluate to a result and there won't be any divide by zero
 * operation.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation: 
 * ⁠ ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 * 
 */
// class Solution {
//     public int evalRPN(String[] tokens) {
//         if (tokens.length == 1) return Integer.valueOf(tokens[0]);
//         Stack<Integer> st = new Stack<>();
        
//         for (String token : tokens) {
//             if (!token.equals("+") && !token.equals("-") &&
//                 !token.equals("*") && !token.equals("/")) {
//                 st.push(Integer.valueOf(token));
//             } else {
//                 int num1 = st.pop();
//                 int num2 = st.pop();
//                 if (token.equals("+")) st.push(num2 + num1);
//                 if (token.equals("-")) st.push(num2 - num1);
//                 if (token.equals("*")) st.push(num2 * num1);
//                 if (token.equals("/")) st.push(num2 / num1);
//             }
//         }

//         return st.pop();
//     }
// }


class Solution {
    int endInd = 0;

    int helper(String[] tokens) {
        endInd -= 1;
        String cur = tokens[endInd];

        if (!cur.equals("+") && !cur.equals("-") &&
            !cur.equals("*") && !cur.equals("/")) {
            return Integer.valueOf(cur);
        }

        int num1 = helper(tokens);
        int num2 = helper(tokens);

        if (cur.equals("+")) return num2 + num1;
        if (cur.equals("-")) return num2 - num1;
        if (cur.equals("*")) return num2 * num1;
        return num2 / num1;
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.valueOf(tokens[0]);
        endInd = tokens.length;
        return helper(tokens);
    }
}
