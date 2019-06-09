/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (48.06%)
 * Likes:    2020
 * Dislikes: 58
 * Total Accepted:    346.5K
 * Total Submissions: 711.5K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */
class Solution {
    void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) break;
                temp.add(candidates[i]);
                helper(candidates, target-candidates[i], res, temp, i);
                temp.remove(temp.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, res, temp, 0);
        return res;
    }
}

