/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (30.32%)
 * Likes:    1028
 * Dislikes: 207
 * Total Accepted:    231.1K
 * Total Submissions: 759.8K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1, right = nums.length-1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> sub = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        res.add(sub);
                        while (left < right && nums[left] == nums[left+1]) left +=1;
                        while (left < right && nums[right] == nums[right-1]) right -= 1;
                        left += 1;
                        right -= 1;
                    } else if (sum < target) {
                        left += 1;
                    } else {
                        right -= 1;
                    }
                }
            }
        }

        return res;
    }
}

