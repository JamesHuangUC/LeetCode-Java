/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 *
 * https://leetcode.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (15.96%)
 * Likes:    573
 * Dislikes: 1497
 * Total Accepted:    130.4K
 * Total Submissions: 808.2K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    double getSlope(int[] a, int[] b) {
        if (a[0] == b[0]) return Double.MAX_VALUE;
        return 10 * (double) (a[1] - b[1]) / (double) (a[0] - b[0]); // multiple 10 to avoid overflow
    }

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int res = 1;
        Map<Double, Integer> slopeFreq = new HashMap<>();
        
        for (int i = 0; i < points.length; i++) {
            int duplicate = 1;
            int tempMax = 0;
            double slope = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplicate += 1;
                } else {
                    slope = getSlope(points[i], points[j]);
                    slopeFreq.put(slope, slopeFreq.getOrDefault(slope, 0) + 1);
                    tempMax = Math.max(tempMax, slopeFreq.get(slope));
                }
            }
            slopeFreq.clear();
            res = Math.max(res, tempMax + duplicate);
        }

        return res;
    }
}

