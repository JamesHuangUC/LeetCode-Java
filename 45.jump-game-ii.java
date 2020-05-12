/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (27.92%)
 * Likes:    1189
 * Dislikes: 61
 * Total Accepted:    172.4K
 * Total Submissions: 612.2K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * ⁠   Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 */
// class Solution {
//     public int jump(int[] nums) {
//         if (nums == null || nums.length <= 1) return 0;
//         int step = 0;
//         int curMax = 0, nextMax = 0, ind = 0;
//         while (ind <= curMax) {
//             while (ind <= curMax) {
//                 nextMax = Math.max(nextMax, ind+nums[ind]);
//                 ind += 1;
//             }
//             step += 1;
//             curMax = nextMax;
//             if (curMax >= nums.length-1) {
//                 return step;
//             }
//         }

//         return 0;
//     }
// }

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int step = 0;
        int farthest = 0;
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                step += 1;
                end = farthest;
            }
        }

        return step;
    }
}
