/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (38.88%)
 * Likes:    951
 * Dislikes: 43
 * Total Accepted:    144.2K
 * Total Submissions: 363.5K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: [
 * ⁠[".Q..",  // Solution 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // Solution 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above.
 * 
 * 
 */
class Solution {
    void helper(List<List<String>> res, int[] col, int row) {
        if (row == col.length) {
            addRes(res, col);
            return;
        }

        for (int i = 0; i < col.length; i++) {
            col[row] = i;
            if (isValid(col, row)) {
                helper(res, col, row+1);
            }
        }        
    }

    boolean isValid(int[] col, int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row]) {
                return false;
            } else if (Math.abs(i - row) == Math.abs(col[i] - col[row])) {
                return false;
            }
        }

        return true;
    }

    void addRes(List<List<String>> res, int[] col) {
        List<String> temp = new ArrayList<>();
        for (int curCol = 0; curCol < col.length; curCol++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col.length; j++) {
                if (col[curCol] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            temp.add(sb.toString());
        }

        res.add(new ArrayList<>(temp));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        helper(res, new int[n], 0);
        return res;
    }
}

