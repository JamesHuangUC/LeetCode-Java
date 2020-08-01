/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
 *
 * https://leetcode.com/problems/same-tree/description/
 *
 * algorithms
 * Easy (49.88%)
 * Likes:    1229
 * Dislikes: 41
 * Total Accepted:    400.7K
 * Total Submissions: 794.5K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'
 *
 * Given two binary trees, write a function to check if they are the same or
 * not.
 * 
 * Two binary trees are considered the same if they are structurally identical
 * and the nodes have the same value.
 * 
 * Example 1:
 * 
 * 
 * Input:     1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * 
 * ⁠       [1,2,3],   [1,2,3]
 * 
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:     1         1
 * ⁠         /           \
 * ⁠        2             2
 * 
 * ⁠       [1,2],     [1,null,2]
 * 
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:     1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * 
 * ⁠       [1,2,1],   [1,1,2]
 * 
 * Output: false
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
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if (p == null) return q == null;
//         if (q == null) return p == null;
//         if (p.val == q.val) {
//             return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//         } else {
//             return false;
//         }
//     }
// }

class Solution {
    boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (!helper(p, q)) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        if (p != null) q1.offer(p);
        if (q != null) q2.offer(q);
        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode curP = q1.poll();
            TreeNode curQ = q2.poll();
            if (!helper(curP.left, curQ.left) || !helper(curP.right, curQ.right)) return false;
            if (curP.left != null) q1.offer(curP.left);
            if (curP.right != null) q1.offer(curP.right);
            if (curQ.left != null) q2.offer(curQ.left);
            if (curQ.right != null) q2.offer(curQ.right);
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
