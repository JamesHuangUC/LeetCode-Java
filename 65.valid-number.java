/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 *
 * https://leetcode.com/problems/valid-number/description/
 *
 * algorithms
 * Hard (13.96%)
 * Likes:    444
 * Dislikes: 3303
 * Total Accepted:    127.5K
 * Total Submissions: 903K
 * Testcase Example:  '"0"'
 *
 * Validate if a given string can be interpreted as a decimal number.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one. However, here is a
 * list of characters that can be in a valid decimal number:
 * 
 * 
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * 
 * 
 * Of course, the context of these characters also matters in the input.
 * 
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your
 * function signature accepts a const char * argument, please click the reload
 * button to reset your code definition.
 * 
 */
class Solution {
    public boolean isNumber(String s) {
        boolean num = false, numAfterE = true, dot = false, exp = false, sign = false;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (i < n-1 && s.charAt(i+1) != ' ' && (num || dot || exp || sign)) {
                    return false;
                }
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != ' ') {
                    return false;
                }
                sign = true;
            } else if (c >= '0' && c <= '9') {
                num = true;
                numAfterE = true;
            } else if (c == '.') {
                if (dot || exp) {
                    return false;
                }
                dot = true;
            } else if (c == 'e') {
                if (exp || !num) {
                    return false;
                }
                exp = true;
                numAfterE = false;
            } else {
                return false;
            }
        }

        return num && numAfterE;
    }
}

