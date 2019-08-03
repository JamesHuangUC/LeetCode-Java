/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (56.29%)
 * Likes:    1785
 * Dislikes: 74
 * Total Accepted:    497.4K
 * Total Submissions: 862.4K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
//     void helper(TreeNode root, List<Integer> res) {
//         if (root == null) return;
//         helper(root.left, res);
//         res.add(root.val);
//         helper(root.right, res);
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         helper(root, res);
//         return res;
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();

        TreeNode cur = root;
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = st.pop();
                res.add(temp.val);
                cur = temp.right;
            }
        }

        return res;
    }
}
