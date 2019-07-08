/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (38.85%)
 * Likes:    1014
 * Dislikes: 198
 * Total Accepted:    314.4K
 * Total Submissions: 793.5K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        int ptrA = a.length() - 1;
        int ptrB = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        int carry = 0, sum = 0;
        while (ptrA >= 0 || ptrB >= 0) {
            sum = carry;
            if (ptrA >= 0) {
                sum += a.charAt(ptrA) - '0';
            }
            if (ptrB >= 0) {
                sum += b.charAt(ptrB) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
            ptrA -= 1;
            ptrB -= 1;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}

