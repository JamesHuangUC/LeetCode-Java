/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (52.16%)
 * Likes:    927
 * Dislikes: 45
 * Total Accepted:    377.7K
 * Total Submissions: 717.9K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
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
//         res.add(root.val);
//         helper(root.left, res);
//         helper(root.right, res);
//     }

//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         helper(root, res);
//         return res;  
//     }
// }


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode p = root;
        Stack<TreeNode> st = new Stack<>();

        while (p != null || !st.isEmpty()) {
            if (p != null) {
                st.push(p);
                res.add(p.val);
                p = p.left;
            } else {
                TreeNode popRootNode = st.pop();
                p = popRootNode.right;
            }
        }

        return res;
    }
}

