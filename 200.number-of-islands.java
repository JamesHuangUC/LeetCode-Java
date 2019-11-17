/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (43.45%)
 * Likes:    3505
 * Dislikes: 129
 * Total Accepted:    473.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 */

// @lc code=start
class Solution {
    void helper(char[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] == '0' || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        helper(grid, visited, r - 1, c);
        helper(grid, visited, r + 1, c);
        helper(grid, visited, r, c - 1);
        helper(grid, visited, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) {
            return res;
        }
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    res += 1;
                    helper(grid, visited, r, c);
                }
            }
        }

        return res;
    }
}

// class Solution {
//     public int numIslands(char[][] grid) {
//         int res = 0;
//         if (grid == null || grid.length == 0) {
//             return res;
//         }
//         int row = grid.length, col = grid[0].length;
//         boolean[][] visited = new boolean[row][col];
//         Queue<Integer> queue = new LinkedList<>();
//         int[] dirX = new int[] { -1, 0, 1, 0 };
//         int[] dirY = new int[] { 0, 1, 0, -1 };

//         for (int r = 0; r < row; r++) {
//             for (int c = 0; c < col; c++) {
//                 if (grid[r][c] == '1' && !visited[r][c]) {
//                     res += 1;
//                     visited[r][c] = true;
//                     queue.offer(r * col + c);
//                     while (!queue.isEmpty()) {
//                         int pNum = queue.poll();
//                         int pRow = pNum / col, pCol = pNum % col;
//                         for (int i = 0; i < 4; i++) {
//                             int x = pRow + dirX[i];
//                             int y = pCol + dirY[i];
//                             if (x < 0 || x >= row || y < 0 || y >= col) {
//                                 continue;
//                             }
//                             if (grid[x][y] == '0' || visited[x][y]) {
//                                 continue;
//                             }
//                             visited[x][y] = true;
//                             queue.offer(x * col + y);
//                         }
//                     }
//                 }
//             }
//         }

//         return res;
//     }
// }
// @lc code=end

