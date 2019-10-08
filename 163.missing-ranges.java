/*
 * @lc app=leetcode id=163 lang=java
 *
 * [163] Missing Ranges
 *
 * https://leetcode.com/problems/missing-ranges/description/
 *
 * algorithms
 * Medium (23.53%)
 * Likes:    240
 * Dislikes: 1428
 * Total Accepted:    65.2K
 * Total Submissions: 277K
 * Testcase Example:  '[0,1,3,50,75]\n0\n99'
 *
 * Given a sorted integer array nums, where the range of elements are in the
 * inclusive range [lower, upper], return its missing ranges.
 * 
 * Example:
 * 
 * 
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) {
            if (lower == upper) {
                res.add(String.valueOf(lower));
                return res;
            } else {
                res.add(lower + "->" + upper);
                return res;
            }
        }

        if (lower < nums[0]) {
            if (nums[0] - lower == 1) {
                res.add(String.valueOf(lower));
            } else {
                res.add(String.valueOf(lower) + "->" + (nums[0] - 1));
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1 ||
                (nums[i] > nums[i - 1] && nums[i] - nums[i - 1] < 0)) {
                if (nums[i] - nums[i - 1] == 2) {
                    res.add(String.valueOf(nums[i] - 1));
                } else {
                    res.add(nums[i - 1] + 1 + "->" + (nums[i] - 1));
                }
            }
        }

        if (upper > nums[nums.length - 1]) {
            if (upper - nums[nums.length - 1] == 1) {
                res.add(String.valueOf(upper));
            } else {
                res.add((nums[nums.length - 1] + 1) + "->" + upper);
            }
        }

        return res;
    }
}
// @lc code=end

