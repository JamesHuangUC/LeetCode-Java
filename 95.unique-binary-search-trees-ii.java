/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (35.48%)
 * Likes:    1365
 * Dislikes: 118
 * Total Accepted:    146.6K
 * Total Submissions: 402.3K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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
    List<TreeNode> helper(int min, int max) {
        List<TreeNode> res = new ArrayList<>();
        if (min > max) return res;

        for (int i = min; i <= max; i++) {
            List<TreeNode> left = helper(min, i-1);
            List<TreeNode> right = helper(i+1, max);

            if (left.size() == 0 && right.size() == 0) {
                TreeNode root = new TreeNode(i);
                res.add(root);
                return res;
            } else if (left.size() == 0) {
                for (TreeNode ri: right) {
                    TreeNode root = new TreeNode(i);
                    root.right = ri;
                    res.add(root);
                }
            } else if (right.size() == 0) {
                for (TreeNode le: left) {
                    TreeNode root = new TreeNode(i);
                    root.left = le;
                    res.add(root);
                }
            } else {
                for (TreeNode le: left) {
                    for (TreeNode ri: right) {
                        TreeNode root = new TreeNode(i);
                        root.left = le;
                        root.right = ri;
                        res.add(root);
                    }
                }
            }
        }

        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);   
    }
}

