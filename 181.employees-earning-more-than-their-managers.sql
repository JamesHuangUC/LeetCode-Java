--
-- @lc app=leetcode id=181 lang=mysql
--
-- [181] Employees Earning More Than Their Managers
--
-- https://leetcode.com/problems/employees-earning-more-than-their-managers/description/
--
-- database
-- Easy (51.02%)
-- Likes:    432
-- Dislikes: 48
-- Total Accepted:    133.5K
-- Total Submissions: 260.6K
-- Testcase Example:  '{"headers": {"Employee": ["Id", "Name", "Salary", "ManagerId"]}, "rows": {"Employee": [[1, "Joe", 70000, 3], [2, "Henry", 80000, 4], [3, "Sam", 60000, null], [4, "Max", 90000, null]]}}'
--
-- The Employee table holds all employees including their managers. Every
-- employee has an Id, and there is also a column for the manager Id.
-- 
-- 
-- +----+-------+--------+-----------+
-- | Id | Name  | Salary | ManagerId |
-- +----+-------+--------+-----------+
-- | 1  | Joe   | 70000  | 3         |
-- | 2  | Henry | 80000  | 4         |
-- | 3  | Sam   | 60000  | NULL      |
-- | 4  | Max   | 90000  | NULL      |
-- +----+-------+--------+-----------+
-- 
-- 
-- Given the Employee table, write a SQL query that finds out employees who
-- earn more than their managers. For the above table, Joe is the only employee
-- who earns more than his manager.
-- 
-- 
-- +----------+
-- | Employee |
-- +----------+
-- | Joe      |
-- +----------+
-- 
-- 
--

-- @lc code=start
# Write your MySQL query statement below
SELECT e1.Name AS Employee
FROM Employee e1
LEFT JOIN Employee e2 ON e1.ManagerId = e2.Id
WHERE e1.Salary > e2.Salary AND e1.ManagerId = e2.Id;
-- @lc code=end

