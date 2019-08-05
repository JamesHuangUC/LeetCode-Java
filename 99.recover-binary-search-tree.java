/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (34.43%)
 * Likes:    852
 * Dislikes: 48
 * Total Accepted:    123.9K
 * Total Submissions: 351.5K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * Output: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * Output: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 
 * Follow up:
 * 
 * 
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
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
//     TreeNode pre = null;
//     TreeNode first = null;
//     TreeNode second = null;

//     void helper(TreeNode root) {
//         if (root == null) return;

//         helper(root.left);
//         if (pre != null && pre.val > root.val) {
//             if (first == null) first = pre;
//             second = root;
//         }
//         pre = root;
//         helper(root.right);
//     }

//     public void recoverTree(TreeNode root) {
//         helper(root);
//         int temp = first.val;
//         first.val = second.val;
//         second.val = temp;
//     }
// }


class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        while (root != null) {
            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    temp.right = null;
                    // visit root.val
                    if (pre != null && pre.val >= root.val) {
                        if (first == null)
                            first = pre;
                        second = root;
                    }
                    pre = root;
                    root = root.right;
                }
            } else {
                // visit root.val
                if (pre != null && pre.val >= root.val) {
                    if (first == null)
                        first = pre;
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
