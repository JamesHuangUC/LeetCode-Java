/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (28.73%)
 * Likes:    1678
 * Dislikes: 577
 * Total Accepted:    215.5K
 * Total Submissions: 744.3K
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array, find the smallest missing positive
 * integer.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,0]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,4,-1,1]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [7,8,9,11,12]
 * Output: 1
 * 
 * 
 * Note:
 * 
 * Your algorithm should run in O(n) time and uses constant extra space.
 * 
 */
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         if (nums == null || nums.length == 0)
//             return 1;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] <= 0)
//                 nums[i] = Integer.MAX_VALUE;
//         }

//         for (int i = 0; i < nums.length; i++) {
//             int num = Math.abs(nums[i]);
//             if (num > nums.length)
//                 continue;
//             nums[num - 1] = -1 * Math.abs(nums[num - 1]);
//         }

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] > 0) {
//                 return i + 1;
//             }
//         }

//         return nums.length + 1;
//     }
// }


class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        boolean[] arr = new boolean[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) continue;
            arr[nums[i]-1] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == false) return i+1;
        }

        return nums.length + 1;
    }
}

