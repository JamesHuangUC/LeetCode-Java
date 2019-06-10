/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (41.25%)
 * Likes:    837
 * Dislikes: 45
 * Total Accepted:    223.3K
 * Total Submissions: 534.6K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
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
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
class Solution {
    void helper(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (i != start && candidates[i] == candidates[i - 1])
                    continue;
                if (candidates[i] > target)
                    break;
                temp.add(candidates[i]);
                helper(candidates, target - candidates[i], i + 1, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return res;
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, temp);
        return res;
    }
}

