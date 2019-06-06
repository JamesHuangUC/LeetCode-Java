/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (42.78%)
 * Likes:    837
 * Dislikes: 312
 * Total Accepted:    237.5K
 * Total Submissions: 550.3K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without
 * repetition.
 * 
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being 
 * ⁠   modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 * 
 * 
 * Note:
 * 
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned
 * rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 * 
 * 
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            boolean[] rowToken = new boolean[9];
            for (int col = 0; col < 9; col++) {
                char charToken = board[row][col];
                if (charToken == '.')
                    continue;
                int token = charToken - '0';
                if (rowToken[token - 1] == true) {
                    // System.out.println("row");
                    return false;
                } else {
                    rowToken[token - 1] = true;
                }
            }
        }

        for (int col = 0; col < 9; col++) {
            boolean[] colToken = new boolean[9];
            for (int row = 0; row < 9; row++) {
                char charToken = board[row][col];
                if (charToken == '.')
                    continue;
                int token = charToken - '0';
                if (colToken[token - 1] == true) {
                    // System.out.println("col");
                    return false;
                } else {
                    colToken[token - 1] = true;
                }
            }
        }

        for (int box = 0; box < 9; box++) {
            boolean[] boxToken = new boolean[9];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    char charToken = board[row + box / 3 * 3][col + box % 3 * 3];
                    if (charToken == '.')
                        continue;
                    int token = charToken - '0';
                    if (boxToken[token - 1] == true) {
                        // System.out.println("box");
                        return false;
                    } else {
                        boxToken[token - 1] = true;
                    }
                }
            }
        }
        return true;
    }
}

