/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (42.89%)
 * Likes:    3633
 * Dislikes: 66
 * Total Accepted:    297.7K
 * Total Submissions: 686.9K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */
// class Solution {
//     public int trap(int[] height) {
//         int[] left = new int[height.length];
//         int[] right = new int[height.length];
//         int leftMost = 0, rightMost = 0;
//         int res = 0;

//         for (int i = 1; i < left.length; i++) {
//             leftMost = Math.max(leftMost, height[i-1]);
//             left[i] = leftMost;
//         }

//         for (int i = right.length-2; i >= 0; i--) {
//             rightMost = Math.max(rightMost, height[i+1]);
//             right[i] = rightMost;
//         }

//         for (int i = 0; i < height.length; i++) {
//             int min = Math.min(left[i], right[i]);
//             if (min > height[i]) {
//                 res += min-height[i];
//             }
//         }

//         return res;
//     }
// }


class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftMost = 0, rightMost = 0;
        int res = 0;

        while (left < right) {
            leftMost = Math.max(leftMost, height[left]);
            rightMost = Math.max(rightMost, height[right]);
            
            if (leftMost < rightMost) {
                res += leftMost - height[left];
                left += 1;
            } else {
                res += rightMost - height[right];
                right -= 1;
            }
        }

        return res;
    }
}
