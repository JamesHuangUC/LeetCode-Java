/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (42.66%)
 * Likes:    1104
 * Dislikes: 65
 * Total Accepted:    239.8K
 * Total Submissions: 561.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
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
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = q.size()-1; i >= 0; i--) {
                TreeNode pop;
                if (leftToRight) {
                    pop = q.remove(0);
                    if (pop.left != null) q.add(pop.left);
                    if (pop.right != null) q.add(pop.right);
                } else {
                    pop = q.remove(q.size()-1);
                    if (pop.right != null) q.add(0, pop.right);
                    if (pop.left != null) q.add(0, pop.left);
                }
                temp.add(pop.val);
            }
            res.add(temp);
            leftToRight = !leftToRight;
        }

        return res;
    }
}

