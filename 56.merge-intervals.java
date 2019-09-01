/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (35.48%)
 * Likes:    2155
 * Dislikes: 166
 * Total Accepted:    360.4K
 * Total Submissions: 1M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
// class Solution {
//     public int[][] merge(int[][] intervals) {
//         List<int[]> res = new ArrayList<>();
//         if (intervals == null || intervals.length == 0) {
//             return new int[0][0];
//         }

//         int[] start = new int[intervals.length];
//         int[] end = new int[intervals.length];
//         for (int i = 0; i < intervals.length; i++) {
//             start[i] = intervals[i][0];
//             end[i] = intervals[i][1];
//         }
//         Arrays.sort(start);
//         Arrays.sort(end);

//         int i = 0;
//         while (i < intervals.length) {
//             int st = start[i];
//             while (i + 1 < intervals.length && end[i] >= start[i+1]) {
//                 i += 1;
//             }
//             int en = end[i];

//             int[] temp = new int[2];
//             temp[0] = st;
//             temp[1] = en;
//             res.add(temp);
//             i += 1;
//         }

//         return res.toArray(new int[0][]);
//     }
// }

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[] { start, end });

        return res.toArray(new int[0][]);
    }
}
