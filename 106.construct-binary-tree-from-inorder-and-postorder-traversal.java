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
    TreeNode helper(int[] inorder, int[] postorder, int left, int right, int rootIdx, Map<Integer, Integer> hm) {
        if (left > right) return null;
        if (left == right) return new TreeNode(postorder[rootIdx]);

        TreeNode root = new TreeNode(postorder[rootIdx]);

        int inorderRootIdx = hm.get(postorder[rootIdx]);

        root.right = helper(inorder, postorder, inorderRootIdx+1, right, rootIdx-1, hm);
        root.left = helper(inorder, postorder, left, inorderRootIdx-1, rootIdx - (right - inorderRootIdx + 1), hm);

        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length-1, postorder.length-1, hm);
    }
}

