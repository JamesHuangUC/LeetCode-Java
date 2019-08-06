/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (43.29%)
 * Likes:    2463
 * Dislikes: 51
 * Total Accepted:    436K
 * Total Submissions: 991.3K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3] is not:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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
//     boolean helper(TreeNode left, TreeNode right) {
//         if (left == null && right == null) return true;
//         if (left == null || right == null) return false;
//         return (left.val == right.val) && (helper(left.left, right.right) && helper(left.right, right.left));
//     }

//     public boolean isSymmetric(TreeNode root) {
//         if (root == null) return true;
//         return helper(root.left, root.right);
//     }
// }

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        st.push(left);
        st.push(right);
        while (!st.isEmpty()) {
            right = st.pop();
            left = st.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);
        }

        return true;
    }
}

