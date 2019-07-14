/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (39.58%)
 * Likes:    1128
 * Dislikes: 203
 * Total Accepted:    218.8K
 * Total Submissions: 543.7K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to
 * 0. Do it in-place.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output: 
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output: 
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 
 * 
 * Follow up:
 * 
 * 
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int numRow = matrix.length;
        int numCol = matrix[0].length;
        
        boolean zeroRow = false;
        boolean zeroCol = false;
        for (int r = 0; r < numRow; r++) {
            if (matrix[r][0] == 0) {
                zeroCol = true;
                break;
            }
        }
        for (int c = 0; c < numCol; c++) {
            if (matrix[0][c] == 0) {
                zeroRow = true;
                break;
            }
        }

        for (int r = 1; r < numRow; r++) {
            for (int c = 1; c < numCol; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = 1; r < numRow; r++) {
            for (int c = 1; c < numCol; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (zeroRow) {
            for (int c = 0; c < numCol; c++) {
                matrix[0][c] = 0;
            }
        }
        if (zeroCol) {
            for (int r = 0; r < numRow; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}

