/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (26.73%)
 * Likes:    1273
 * Dislikes: 164
 * Total Accepted:    146.6K
 * Total Submissions: 547.7K
 * Testcase Example:  '[10,2]'
 *
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example 1:
 * 
 * 
 * Input: [10,2]
 * Output: "210"
 * 
 * Example 2:
 * 
 * 
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * 
 * 
 * Note: The result may be very large, so you need to return a string instead
 * of an integer.
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "0";

        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(arr, (String a, String b) -> {
            return (b+a).compareTo(a+b);
        });

        StringBuilder sb = new StringBuilder();
        for (String s: arr) {
            sb.append(s);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
// @lc code=end

