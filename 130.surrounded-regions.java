/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (23.54%)
 * Likes:    905
 * Dislikes: 472
 * Total Accepted:    160.3K
 * Total Submissions: 671.5K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */
class Solution {
    void fillBoarders(char[][] board, char target, char ch) {
        int row = board.length, col = board[0].length;

        // Check most left and most right column
        for (int r = 0; r < row; r++) {
            if (board[r][0] == target) {
                fill(board, r, 0, target, ch);
            }
            if (board[r][col-1] == target) {
                fill(board, r, col-1, target, ch);
            }
        }

        // Check first row and last row
        for (int c = 0; c < col; c++) {
            if (board[0][c] == target) {
                fill(board, 0, c, target, ch);
            }
            if (board[row-1][c] == target) {
                fill(board, row-1, c, target, ch);
            }
        }
    } 

    void fill(char[][] board, int row, int col, char target, char ch) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (board[row][col] != target) return;
        board[row][col] = ch;
        fill(board, row-1, col, target, ch);
        fill(board, row+1, col, target, ch);
        fill(board, row, col-1, target, ch);
        fill(board, row, col+1, target, ch);
    }

    void replace(char[][] board, char target, char ch) {
        int row = board.length, col = board[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == target) {
                    board[r][c] = ch;
                }
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) return;
        fillBoarders(board, 'O', 'Y');
        replace(board, 'O', 'X');
        replace(board, 'Y', 'O');
    }
}

