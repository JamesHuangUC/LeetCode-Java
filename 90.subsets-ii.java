/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (42.18%)
 * Likes:    973
 * Dislikes: 49
 * Total Accepted:    213.7K
 * Total Submissions: 496K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
class Solution {
    void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> cur) {
        res.add(new ArrayList<>(cur));

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);
            helper(nums, i+1, res, cur);
            cur.remove(cur.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        helper(nums, 0, res, cur);
        return res;
    }
}


// class Solution {
//     void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> cur, boolean taken) {
//         if (start == nums.length) {
//             res.add(new ArrayList<>(cur));
//             return;
//         }
//         helper(nums, start+1, res, cur, false);

//         if (taken == false && nums[start] == nums[start-1]) {
//             return;
//         }

//         cur.add(nums[start]);
//         helper(nums, start+1, res, cur, true);
//         cur.remove(cur.size()-1);
//     }

//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (nums == null || nums.length == 0) return res;
//         Arrays.sort(nums);
//         List<Integer> cur = new ArrayList<>();
//         helper(nums, 0, res, cur, true);
//         return res;
//     }
// }
