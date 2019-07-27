/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (30.91%)
 * Likes:    2085
 * Dislikes: 56
 * Total Accepted:    185K
 * Total Submissions: 583.2K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * 
 * 
 */
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         if (heights == null || heights.length == 0) return 0;
//         int max = 0;
//         for (int cur = 0; cur < heights.length; cur++) {
//             if (cur == heights.length - 1 || heights[cur + 1] < heights[cur]) {
//                 int minHeight = heights[cur];
//                 for (int i = cur; i >= 0; i--) {
//                     int width = cur - i + 1;
//                     minHeight = Math.min(minHeight, heights[i]);
//                     max = Math.max(max, width * minHeight);
//                 }
//             }
//         }

//         return max;
//     }
// }


class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (st.isEmpty() || heights[i] >= heights[st.peek()]) {
                st.push(i);
            } else {
                int rightMost = i;
                int ind = st.pop();
                while (!st.isEmpty() && heights[st.peek()] == heights[ind]) {
                    ind = st.pop();
                }
                int leftMost = st.isEmpty() ? -1 : st.peek();
                max = Math.max(max, heights[ind] * (rightMost - leftMost - 1));
                i--;
            }
        }

        int rightMost = st.peek() + 1;
        while (!st.isEmpty()) {
            int ind = st.pop();
            while (!st.isEmpty() && heights[st.peek()] == heights[ind]) {
                ind = st.pop();
            }
            int leftMost = st.isEmpty() ? -1 : st.peek();
            max = Math.max(max, heights[ind] * (rightMost - leftMost - 1));
        }

        return max;
    }
}

