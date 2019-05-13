/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 *
 * https://leetcode.com/problems/integer-to-roman/description/
 *
 * algorithms
 * Medium (50.69%)
 * Likes:    565
 * Dislikes: 1806
 * Total Accepted:    225.4K
 * Total Submissions: 444.1K
 * Testcase Example:  '3'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: 3
 * Output: "III"
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "IV"
 * 
 * Example 3:
 * 
 * 
 * Input: 9
 * Output: "IX"
 * 
 * Example 4:
 * 
 * 
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 */
// class Solution {
//     public String intToRoman(int num) {
//         StringBuilder res = new StringBuilder();
//         char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
//         int[] value = {1000, 500, 100, 50, 10, 5, 1};

//         for (int i = 0; i < 7; i += 2) {
//             int x = num / value[i];
//             if (x < 4) {
//                 for (int j = 0; j < x; j++) {
//                     res.append(roman[i]);
//                 }
//             } else if (x == 4) {
//                 res.append(roman[i]);
//                 res.append(roman[i-1]);
//             } else if (x > 4 && x < 9) {
//                 res.append(roman[i-1]);
//                 for (int j = 0; j < x-5; j++) {
//                     res.append(roman[i]);
//                 }
//             } else if (x == 9) {
//                 res.append(roman[i]);
//                 res.append(roman[i-2]);
//             }

//             num %= value[i];
//         }

//         return res.toString();
//     }
// }


class Solution {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                res.append(str[i]);
                num -= val[i];
            }
        }

        return res.toString();
    }
}
