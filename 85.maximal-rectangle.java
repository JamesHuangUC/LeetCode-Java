/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 *
 * https://leetcode.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (33.08%)
 * Likes:    1578
 * Dislikes: 52
 * Total Accepted:    128.3K
 * Total Submissions: 377.5K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * Output: 6
 * 
 * 
 */
class Solution {
    int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (st.isEmpty() || heights[i] > heights[st.peek()]) {
                st.push(i);
            } else {
                int rightMost = i;
                int ind = st.pop();
                while (!st.isEmpty() && st.peek() == ind) {
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
            while (!st.isEmpty() && st.peek() == ind) {
                ind = st.pop();
            }
            int leftMost = st.isEmpty() ? -1 : st.peek();
            max = Math.max(max, heights[ind] * (rightMost - leftMost - 1));
        }

        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int max = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '0') {
                    heights[col] = 0;
                } else {
                    heights[col] += 1;
                }
            }

            int area = largestRectangleArea(heights);
            max = Math.max(max, area);
        }

        return max;
    }
}

