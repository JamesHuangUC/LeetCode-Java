/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (34.83%)
 * Likes:    899
 * Dislikes: 106
 * Total Accepted:    233.3K
 * Total Submissions: 666.2K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 * 
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rowStart = 0, rowEnd = matrix.length-1;
        int colStart = 0, colEnd = matrix[0].length-1;
        int targetRow = 0;

        while (rowStart < rowEnd) {
            int mid = rowStart + (rowEnd - rowStart) / 2;
            if (matrix[mid][colEnd] == target) {
                return true;
            } else if (matrix[mid][colEnd] < target) {
                rowStart = mid + 1;
            } else {
                rowEnd = mid;
            }
        }
        if (matrix[rowStart][colEnd] >= target) {
            targetRow = rowStart;
        } else {
            return false;
        }

        while (colStart < colEnd) {
            int mid = colStart + (colEnd - colStart) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] < target) {
                colStart = mid + 1;
            } else {
                colEnd = mid;
            }
        }
        if (matrix[targetRow][colStart] == target) {
            return true;
        } else {
            return false;
        }
    }
}

