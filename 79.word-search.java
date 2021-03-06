/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (31.06%)
 * Likes:    1911
 * Dislikes: 96
 * Total Accepted:    300.9K
 * Total Submissions: 947.6K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    boolean helper(char[][] board, char[] word, int curIdx, int r, int c) {
        if (curIdx == word.length) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if (board[r][c] != word[curIdx]) return false;
        char temp = board[r][c];
        board[r][c] = '#';
        boolean res = helper(board, word, curIdx+1, r-1, c)
            || helper(board, word, curIdx+1, r+1, c)
            || helper(board, word, curIdx+1, r, c+1)
            || helper(board, word, curIdx+1, r, c-1);
        board[r][c] = temp;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (helper(board, word.toCharArray(), 0, r, c)) return true;
            }
        }
        return false;
    }
}
