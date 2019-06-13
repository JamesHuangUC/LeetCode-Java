/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (30.49%)
 * Likes:    1006
 * Dislikes: 464
 * Total Accepted:    203.8K
 * Total Submissions: 661.9K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Note:
 * 
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length(), len2 = num2.length();
        int res[] = new int[len1+len2];

        for (int i = len2-1; i >= 0; i--) {
            for (int j = len1-1; j >= 0; j--) {
                int loPos = i+j+1;
                int hiPos = i+j;
                int mul = (num2.charAt(i)-'0') * (num1.charAt(j)-'0') + res[loPos];
                res[loPos] = mul % 10;
                res[hiPos] += mul / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int e: res) {
            if (e == 0 && sb.length() == 0) continue;
            sb.append(e);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}

