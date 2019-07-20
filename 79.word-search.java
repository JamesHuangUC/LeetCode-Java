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
    boolean helper(char[][] board, char[] wordArr, int r, int c, boolean[][] isUsed, int idx) {
        if (idx == wordArr.length) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }
        if (isUsed[r][c] == true) {
            return false;
        }
        if (board[r][c] != wordArr[idx]) {
            return false;
        }
        isUsed[r][c] = true;
        if (helper(board, wordArr, r - 1, c, isUsed, idx + 1)) return true;
        if (helper(board, wordArr, r + 1, c, isUsed, idx + 1)) return true;
        if (helper(board, wordArr, r, c - 1, isUsed, idx + 1)) return true;
        if (helper(board, wordArr, r, c + 1, isUsed, idx + 1)) return true;
        isUsed[r][c] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (word == null || word.length() == 0) return false;
        boolean[][] isUsed = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (helper(board, word.toCharArray(), r, c, isUsed, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}

