/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (40.40%)
 * Likes:    968
 * Dislikes: 20
 * Total Accepted:    163.9K
 * Total Submissions: 405.2K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int i = inStart;
        while (i <= inEnd) {
            if (inorder[i] == postorder[postEnd]) break;
            i += 1;
        }
        root.left = helper(inorder, postorder, inStart, i-1, postStart, postStart+(i-inStart)-1);
        root.right = helper(inorder, postorder, i+1, inEnd, postStart+(i-inStart), postEnd-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length != inorder.length) return null;
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
}

