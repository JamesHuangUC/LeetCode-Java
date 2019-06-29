/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 *
 * https://leetcode.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (31.10%)
 * Likes:    869
 * Dislikes: 110
 * Total Accepted:    181.1K
 * Total Submissions: 577.3K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with
 * [3,5],[6,7],[8,10].
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        int nStart = newInterval[0];
        int nEnd = newInterval[1];
        
        while (i < n && intervals[i][1] < nStart) {
            res.add(intervals[i]);
            i += 1;
        }

        if (i == n) {
            res.add(newInterval);
            return res.toArray(new int[0][]);
        }

        nStart = Math.min(intervals[i][0], newInterval[0]);
        while (i < n  && intervals[i][0] <= newInterval[1]) {
            nEnd = Math.max(intervals[i][1], newInterval[1]);
            i += 1;
        }
        res.add(new int[]{nStart, nEnd});

        while (i < n) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[0][]);
    }
}

