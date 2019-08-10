/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (48.16%)
 * Likes:    1671
 * Dislikes: 44
 * Total Accepted:    411.5K
 * Total Submissions: 830.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (root == null) return res;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);
//         while (!q.isEmpty()) {
//             List<Integer> temp = new ArrayList<>();
//             for (int i = q.size()-1; i >= 0; i--) {
//                 TreeNode pop = q.poll();
//                 temp.add(pop.val);
//                 if (pop.left != null) q.offer(pop.left);
//                 if (pop.right != null) q.offer(pop.right);
//             }
//             res.add(new ArrayList<>(temp));
//         }

//         return res;
//     }
// }

class Solution {
    void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() <= level) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        helper(root.left, res, level+1);
        helper(root.right, res, level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, 0);
        return res;
    }
}
