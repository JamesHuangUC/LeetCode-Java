/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (46.27%)
 * Likes:    462
 * Dislikes: 82
 * Total Accepted:    139.3K
 * Total Submissions: 296.3K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n <= 0) return res;

        int top = 0;
        int right = res[0].length - 1;
        int bottom = res.length - 1;
        int left = 0;

        int counter = 1;
        while (top < bottom && left < right) {
            for (int i = left; i < right; i++) {
                res[top][i] = counter++;
            }
            for (int i = top; i < bottom; i++) {
                res[i][right] = counter++;
            }
            for (int i = right; i > left; i--) {
                res[bottom][i] = counter++;
            }
            for (int i = bottom; i > top; i--) {
                res[i][left] = counter++;
            }

            top += 1;
            right -= 1;
            bottom -= 1;
            left += 1;
        }

        if (n % 2 == 1) {
            int midA = n / 2;
            int midB = n / 2;
            res[midA][midB] = counter;
        }

        return res;
    }
}

