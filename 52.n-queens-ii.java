/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (51.61%)
 * Likes:    281
 * Dislikes: 115
 * Total Accepted:    101.1K
 * Total Submissions: 193.3K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */
class Solution {
    int res = 0;

    void helper(int[] colArr, int row) {
        if (row == colArr.length) {
            res += 1;
            return;
        }

        for (int i = 0; i < colArr.length; i++) {
            if (isValid(colArr, row, i)) {
                colArr[row] = i;
                helper(colArr, row+1);
                colArr[row] = -1;
            }
        }
    }

    boolean isValid(int[] colArr, int row, int colInd) {
        for (int i = 0; i < row; i++) {
            if (colArr[i] == colInd || Math.abs(row-i) == Math.abs(colInd-colArr[i])) {
                return false;
            }
        }

        return true;
    }

    public int totalNQueens(int n) {
        int[] colArr = new int[n];
        Arrays.fill(colArr, -1);
        helper(colArr, 0);
        return res;
    }
}

