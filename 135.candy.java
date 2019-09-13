/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 *
 * https://leetcode.com/problems/candy/description/
 *
 * algorithms
 * Hard (28.94%)
 * Likes:    600
 * Dislikes: 130
 * Total Accepted:    109.9K
 * Total Submissions: 375.9K
 * Testcase Example:  '[1,0,2]'
 *
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * 
 * 
 * What is the minimum candies you must give?
 * 
 * Example 1:
 * 
 * 
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2,
 * 1, 2 candies respectively.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1,
 * 2, 1 candies respectively.
 * ⁠            The third child gets 1 candy because it satisfies the above two
 * conditions.
 * 
 * 
 */
// class Solution {
//     public int candy(int[] ratings) {
//         if (ratings == null || ratings.length == 0) return 0;
//         int[] arr = new int[ratings.length];
//         arr[0] = 1;
        
//         for (int i = 1; i < arr.length; i++) {
//             if (ratings[i] > ratings[i-1]) {
//                 arr[i] = arr[i-1] + 1;
//             } else {
//                 arr[i] = 1;
//             }
//         }

//         for (int i = arr.length - 1; i >= 1; i--) {
//             if (ratings[i] < ratings[i-1] && arr[i] >= arr[i-1]) {
//                 arr[i-1] = arr[i] + 1;
//             }
//         }

//         int res = 0;
//         for (int i = 0; i < arr.length; i++) {
//             res += arr[i];
//         }

//         return res;
//     }
// }

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int res = 1, pre = 1, cnt = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i-1]) {
                if (cnt > 0) {
                    res += cnt * (cnt + 1) / 2;
                    if (cnt >= pre) {
                        res += cnt + 1 - pre;
                    }
                    pre = 1;
                    cnt = 0;
                }
                pre = ratings[i] == ratings[i-1] ? 1 : pre + 1;
                res += pre;
            } else {
                cnt += 1;
            }
        }

        if (cnt > 0) {
            res += cnt * (cnt + 1) / 2;
            if (cnt >= pre) {
                res += cnt + 1 - pre;
            }
        }

        return res;
    }
}

