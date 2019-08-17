/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (51.98%)
 * Likes:    1322
 * Dislikes: 137
 * Total Accepted:    285.9K
 * Total Submissions: 548.8K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted array: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
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
//     public TreeNode sortedArrayToBST(int[] nums) {
//         if (nums == null || nums.length == 0) return null;
//         int mid = (nums.length-1) / 2;
//         TreeNode root = new TreeNode(nums[mid]);
//         int[] leftArr = new int[mid];
//         int[] rightArr = new int[nums.length-mid-1];
//         System.arraycopy(nums, 0, leftArr, 0, leftArr.length);
//         System.arraycopy(nums, mid+1, rightArr, 0, rightArr.length);
//         root.left = sortedArrayToBST(leftArr);
//         root.right = sortedArrayToBST(rightArr);
//         return root;
//     }
// }

class Solution {
    TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length-1);
    }
}

