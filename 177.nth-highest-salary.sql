--
-- @lc app=leetcode id=177 lang=mysql
--
-- [177] Nth Highest Salary
--
-- https://leetcode.com/problems/nth-highest-salary/description/
--
-- database
-- Medium (28.13%)
-- Likes:    298
-- Dislikes: 249
-- Total Accepted:    81.1K
-- Total Submissions: 287.5K
-- Testcase Example:  '{"headers": {"Employee": ["Id", "Salary"]}, "argument": 2, "rows": {"Employee": [[1, 100], [2, 200], [3, 300]]}}'
--
-- Write a SQL query to get the n^th highest salary from the Employee table.
-- 
-- 
-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- 
-- 
-- For example, given the above Employee table, the n^th highest salary where n
-- = 2 is 200. If there is no n^th highest salary, then the query should return
-- null.
-- 
-- 
-- +------------------------+
-- | getNthHighestSalary(2) |
-- +------------------------+
-- | 200                    |
-- +------------------------+
-- 
-- 
--

-- @lc code=start
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT MAX(e1.Salary)
      FROM Employee e1
      WHERE N-1 = (SELECT COUNT(DISTINCT e2.Salary)
                  FROM Employee e2
                  WHERE e2.salary > e1.salary)
  );
END
-- @lc code=end

