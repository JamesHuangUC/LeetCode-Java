/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (40.18%)
 * Likes:    1015
 * Dislikes: 43
 * Total Accepted:    247.2K
 * Total Submissions: 606.8K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    void helper(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                    continue;
                }
                temp.add(nums[i]);
                visited[i] = true;
                helper(nums, temp, res, visited);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, temp, res, visited);
        return res;
    }
}

