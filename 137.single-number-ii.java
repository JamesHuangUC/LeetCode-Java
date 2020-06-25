/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (46.65%)
 * Likes:    951
 * Dislikes: 269
 * Total Accepted:    179.2K
 * Total Submissions: 380.7K
 * Testcase Example:  '[2,2,3,2]'
 *
 * Given a non-empty array of integers, every element appears three times
 * except for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,3,2]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 
 */
// class Solution {
//     public int singleNumber(int[] nums) {
//         int a = 0, b = 0;

//         for (int num : nums) {
//             b = (b ^ num) & ~a;
//             a = (a ^ num) & ~b;
//         }

//         return b;
//     }
// }

// class Solution {
//     public int singleNumber(int[] nums) {
//         int res = 0;
//         int[] bits = new int[32];

//         for (int i = 0; i < 32; i++) {
//             for (int num : nums) {
//                 bits[i] += num >> i & 1;
//                 bits[i] %= 3;
//             }
//         }

//         for (int i = 0; i < 32; i++) {
//             res += bits[i] << i;
//         }

//         return res;
//     }
// }

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;

        for (int num : nums) {
            twos = twos | (ones & num);
            ones = ones ^ num;
            threes = ones & twos;
            ones = ones & (~threes);
            twos = twos & (~threes);
        }

        return ones;
    }
}
