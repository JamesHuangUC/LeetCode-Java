/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (47.24%)
 * Likes:    822
 * Dislikes: 83
 * Total Accepted:    280.1K
 * Total Submissions: 589.1K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int row = 1; row <= numRows; row++) {
            List<Integer> rowLst = new ArrayList<>();
            rowLst.add(1);
            for (int preCol = 1; preCol < row; preCol++) {
                int preNum = rowLst.get(rowLst.size()-1);
                int curNum = preNum * (row - preCol) / preCol;
                rowLst.add(curNum);
            }
            res.add(rowLst);
        }

        return res;
    }
}

