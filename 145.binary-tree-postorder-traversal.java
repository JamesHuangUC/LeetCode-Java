/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (49.62%)
 * Likes:    1113
 * Dislikes: 57
 * Total Accepted:    290.4K
 * Total Submissions: 577.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [3,2,1]
 * 
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
//         helper(root.right, res);
//         res.add(root.val);
//     }

//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         helper(root, res);
//         return res;
//     }
// }


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;

        while (!st.isEmpty() || p != null) {
            if (p != null) {
                res.add(0, p.val);
                st.push(p);
                p = p.right;
            } else {
                p = st.pop();
                p = p.left;
            }
        }

        return res;
    }
}

