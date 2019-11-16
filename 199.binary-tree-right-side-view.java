/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (50.20%)
 * Likes:    1408
 * Dislikes: 74
 * Total Accepted:    208.6K
 * Total Submissions: 414K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
 * 
 */

// @lc code=start
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
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         if (root == null) return res;
//         Queue<TreeNode> queue = new LinkedList<>();

//         queue.offer(root);
//         while (!queue.isEmpty()) {
//             for (int i = queue.size() - 1; i >= 0; i--) {
//                 TreeNode pNode = queue.poll();
//                 if (i == 0) {
//                     res.add(pNode.val);
//                 }
//                 if (pNode.left != null)
//                     queue.offer(pNode.left);
//                 if (pNode.right != null)
//                     queue.offer(pNode.right);
//             }
//         }

//         return res;
//     }
// }

class Solution {
    void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null)
            return;
        if (res.size() == level) {
            res.add(root.val);
        }
        helper(root.right, res, level + 1);
        helper(root.left, res, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
}
// @lc code=end

