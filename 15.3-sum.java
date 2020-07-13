/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.88%)
 * Likes:    3703
 * Dislikes: 402
 * Total Accepted:    541.7K
 * Total Submissions: 2.3M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         Arrays.sort(nums);
//         if (nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0) {
//             return res;
//         }
//         List<Integer> lst = new ArrayList<>();
//         for (int i = 0; i < nums.length; i++) {
//             if (i > 0 && nums[i] == nums[i - 1]) {
//                 continue;
//             }
//             int fix = nums[i];
//             int target = 0 - fix;
//             int left = i + 1;
//             int right = nums.length - 1;
//             while (left < right) {
//                 if (nums[left] + nums[right] == target) {
//                     res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                     while (left < right && nums[left] == nums[left + 1]) {
//                         left++;
//                     }
//                     while (left < right && nums[right] == nums[right - 1]) {
//                         right--;
//                     }
//                     left++;
//                     right--;
//                 } else if (nums[left] + nums[right] < target) {
//                     left++;
//                 } else {
//                     right--;
//                 }
//             }
//         }
//         return res;
//     }
// }

class Solution {
    List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left += 1;
            } else if (sum > target) {
                right -= 1;
            } else {
                res.add(Arrays.asList(nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1])
                    left += 1;
                while (left < right && nums[right] == nums[right - 1])
                    right -= 1;
                left += 1;
                right -= 1;
            }
        }
        return res;
    }

    List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || start >= nums.length)
            return res;
        if (n == 2)
            return twoSum(nums, start, target);

        for (int i = start; i < nums.length; i++) {
            List<List<Integer>> lst = nSum(nums, n - 1, i + 1, target - nums[i]);
            for (List<Integer> sub : lst) {
                res.add(new ArrayList<>(sub));
                res.get(res.size() - 1).add(nums[i]);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i += 1;
        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        return nSum(nums, 3, 0, 0);
    }
}
