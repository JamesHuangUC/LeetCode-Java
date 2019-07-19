/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (52.40%)
 * Likes:    2101
 * Dislikes: 53
 * Total Accepted:    386.1K
 * Total Submissions: 717.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    void helper(int[] nums, List<List<Integer>> res, int start, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, res, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(nums, res, 0, new ArrayList<>());
        return res;
    }
}

// class Solution {
//     void helper(int[] nums, List<List<Integer>> res, int start, List<Integer> temp) {
//         if (start == nums.length) {
//             res.add(new ArrayList<>(temp));
//             return;
//         }
//         helper(nums, res, start+1, temp);

//         temp.add(nums[start]);
//         helper(nums, res, start+1, temp);
//         temp.remove(temp.size()-1);
//     }

//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (nums == null || nums.length == 0)
//             return res;
//         helper(nums, res, 0, new ArrayList<>());
//         return res;
//     }
// }
