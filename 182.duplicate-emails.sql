--
-- @lc app=leetcode id=182 lang=mysql
--
-- [182] Duplicate Emails
--
-- https://leetcode.com/problems/duplicate-emails/description/
--
-- database
-- Easy (57.31%)
-- Likes:    336
-- Dislikes: 22
-- Total Accepted:    137.6K
-- Total Submissions: 239.4K
-- Testcase Example:  '{"headers": {"Person": ["Id", "Email"]}, "rows": {"Person": [[1, "a@b.com"], [2, "c@d.com"], [3, "a@b.com"]]}}'
--
-- Write a SQL query to find all duplicate emails in a table named Person.
-- 
-- 
-- +----+---------+
-- | Id | Email   |
-- +----+---------+
-- | 1  | a@b.com |
-- | 2  | c@d.com |
-- | 3  | a@b.com |
-- +----+---------+
-- 
-- 
-- For example, your query should return the following for the above table:
-- 
-- 
-- +---------+
-- | Email   |
-- +---------+
-- | a@b.com |
-- +---------+
-- 
-- 
-- Note: All emails are in lowercase.
-- 
--

-- @lc code=start
-- # Write your MySQL query statement below
SELECT DISTINCT p1.Email
FROM Person as p1
INNER JOIN Person as p2
ON p1.Email = p2.Email AND p1.Id != p2.Id;

-- SELECT Email
-- FROM Person
-- GROUP BY Email
-- HAVING Count(Email) > 1;
-- @lc code=end

