/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (27.07%)
 * Likes:    988
 * Dislikes: 61
 * Total Accepted:    103.1K
 * Total Submissions: 380.7K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * Say you have an array for which the i-th element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * 
 * Example 1:
 * 
 * 
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit
 * = 4-2 = 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit
 * = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 =
 * 3.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) return 0;
        if (k >= prices.length) {
            int profit = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i-1] >= prices[i]) {
                    min = prices[i];
                } else {
                    profit += prices[i]-min;
                    min = prices[i];
                }
            }
            return profit;
        }
        
        int[] res = new int[prices.length];
        int[] prev = new int[prices.length];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int d = 1; d < prices.length; d++) {
                res[d] = Math.max(res[d-1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, prev[d] - prices[d]);
            }
            for (int i = 0; i < res.length; i++) {
                prev[i] = res[i];
            }
        }

        return res[res.length - 1];
    }
}

//     Memory Limit Exceeded

//     class Solution {
//         public int maxProfit(int k, int[] prices) {
//             if (prices == null || prices.length == 0 || k == 0)
//                 return 0;
//             int[][] dp = new int[k + 1][prices.length];

//             for (int t = 1; t < dp.length; t++) {
//                 int maxDiff = -prices[0];
//                 for (int d = 1; d < dp[0].length; d++) {
//                     dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
//                     maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
//                 }
//             }

//             return dp[k][prices.length - 1];
//         }
//     }

//     Memory Limit Exceeded

// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         if (prices == null || prices.length == 0 || k == 0) return 0;
//         int[][] dp = new int[k+1][prices.length];

//         for (int t = 1; t < dp.length; t++) {
//             for (int d = 1; d < dp[0].length; d++) {
//                 int maxVal = Integer.MIN_VALUE;
//                 for (int m = 0; m < d; m++) {
//                     maxVal = Math.max(maxVal, prices[d]+dp[t-1][m]-prices[m]);
//                 }
//                 dp[t][d] = Math.max(dp[t][d-1], maxVal);
//             }
//         }
        
//         return dp[k][prices.length-1];
//     }
// }
// @lc code=end

