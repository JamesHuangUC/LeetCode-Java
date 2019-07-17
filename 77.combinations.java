/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (47.25%)
 * Likes:    825
 * Dislikes: 48
 * Total Accepted:    212K
 * Total Submissions: 437K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
class Solution {
    void dfs(int n, int k, int start, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            dfs(n, k, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(n, k, 1, temp, res);
        return res;   
    }
}

