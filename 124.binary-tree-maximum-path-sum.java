/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (30.56%)
 * Likes:    1919
 * Dislikes: 143
 * Total Accepted:    217.1K
 * Total Submissions: 705.5K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * Output: 42
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
class Solution {
    int res = Integer.MIN_VALUE;
    int helper(TreeNode root) {
        if (root == null) return 0;
        int singleLeftPath = Math.max(0, helper(root.left));
        int singleRightPath = Math.max(0, helper(root.right));
        int singleMax = root.val + Math.max(singleLeftPath, singleRightPath);
        int bothPath = root.val + singleLeftPath + singleRightPath;
        res = Math.max(res, singleMax);
        res = Math.max(res, bothPath);
        return singleMax;
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }    
}

