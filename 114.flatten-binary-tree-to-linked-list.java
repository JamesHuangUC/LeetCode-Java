/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (43.49%)
 * Likes:    1691
 * Dislikes: 218
 * Total Accepted:    256.8K
 * Total Submissions: 587.6K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 
 * The flattened tree should look like:
 * 
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
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
//     void preorder(TreeNode root, List<TreeNode> lst) {
//         if (root == null) return;
//         lst.add(root);
//         preorder(root.left, lst);
//         preorder(root.right, lst);
//     }

//     public void flatten(TreeNode root) {
//         if (root == null) return;
//         List<TreeNode> lst = new ArrayList<>();
//         preorder(root, lst);
//         for (int i = 0; i < lst.size()-1; i++) {
//             lst.get(i).left = null;
//             lst.get(i).right = lst.get(i+1);
//         }
//         lst.get(lst.size()-1).left = null;
//         lst.get(lst.size()-1).right = null;
//     }
// }

class Solution {
    TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return root;
    }

    public void flatten(TreeNode root) {
        helper(root);
    }
}

