/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (20.15%)
 * Likes:    564
 * Dislikes: 1246
 * Total Accepted:    98.5K
 * Total Submissions: 488.7K
 * Testcase Example:  '1\n2'
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * Example 1:
 * 
 * 
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * 
 * Example 3:
 * 
 * 
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "";
        StringBuilder res = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) res.append("-");

        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        long ans = num / den;
        res.append(String.valueOf(ans));

        long rem = (num % den) * 10;
        if (rem == 0) return res.toString();

        Map<Long, Integer> hm = new HashMap<>();
        res.append(".");
        while (rem != 0) {
            if (hm.containsKey(rem)) {
                int begin = hm.get(rem);
                String part1 = res.toString().substring(0, begin);
                String part2 = res.toString().substring(begin, res.length());
                return part1 + "(" + part2 + ")";
            }
            hm.put(rem, res.length());
            ans = rem / den;
            res.append(String.valueOf(ans));
            rem = (rem % den) * 10;
        }

        return res.toString();
    }
}
// @lc code=end

