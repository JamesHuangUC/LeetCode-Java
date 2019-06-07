/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (36.56%)
 * Likes:    866
 * Dislikes: 59
 * Total Accepted:    129.9K
 * Total Submissions: 350.5K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 * 
 * Note:
 * 
 * 
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique
 * solution.
 * The given board size is always 9x9.
 * 
 * 
 */
class Solution {
    boolean isValid(char[][] board, int row, int col, int num) {
        char c = (char) (num + '0');
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c) {
                return false;
            }
        }
        int rowOff = row / 3 * 3;
        int colOff = col / 3 * 3;
        for (int ro = rowOff; ro < rowOff+3; ro++) {
            for (int co = colOff; co < colOff+3; co++) {
                if (board[ro][co] == c) {
                    return false;
                }
            }
        }

        board[row][col] = c;
        return true;
    }

    boolean helper(char[][] board, int row, int col) {
        while (row < 9 && col < 9) {
            if (board[row][col] == '.') break;
            if (col == 8) {
                col = 0;
                row += 1;
            } else {
                col += 1;
            }
        }

        if (row > 8) return true;

        for (int i = 1; i <= 9; i++) {
            if (isValid(board, row, col, i)) {
                int newRow = col == 8 ? row+1 : row;
                int newCol = col == 8 ? 0 : col+1;
                if (helper(board, newRow, newCol)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        helper(board, 0, 0);
    }
}

