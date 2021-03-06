/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (40.27%)
 * Likes:    777
 * Dislikes: 5969
 * Total Accepted:    285.4K
 * Total Submissions: 703K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the n^th term of the
 * count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "1211"
 * 
 */
// class Solution {
//     public String countAndSay(int n) {
//         if (n == 1) return "1";

//         StringBuilder temp = new StringBuilder();
//         StringBuilder res = new StringBuilder("1");

//         while (--n > 0) {
//             for (int i = 0; i < res.length(); i++) {
//                 int count = 1;
//                 while (i + 1 < res.length() && res.charAt(i) == res.charAt(i+1)) {
//                     i += 1;
//                     count += 1;
//                 }
//                 temp.append(count);
//                 temp.append(res.charAt(i));
//             }
//             res.setLength(0);
//             res.append(temp);
//             temp.setLength(0);
//         }

//         return res.toString();
//     }
// }

class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String previous = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < previous.length();) {
            int j = i + 1;
            while (j < previous.length() && previous.charAt(i) == previous.charAt(j)) {
                j += 1;
            }
            res.append(j - i);
            res.append(previous.charAt(i));
            i = j;
        }
        return res.toString();
    }
}
