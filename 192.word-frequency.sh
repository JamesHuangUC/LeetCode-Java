#
# @lc app=leetcode id=192 lang=bash
#
# [192] Word Frequency
#
# https://leetcode.com/problems/word-frequency/description/
#
# shell
# Medium (26.79%)
# Likes:    164
# Dislikes: 90
# Total Accepted:    22K
# Total Submissions: 82K
# Testcase Example:  'a'
#
# Write a bash script to calculate the frequency of each word in a text file
# words.txt.
# 
# For simplicity sake, you may assume:
# 
# 
# words.txt contains only lowercase characters and space ' ' characters.
# Each word must consist of lowercase characters only.
# Words are separated by one or more whitespace characters.
# 
# 
# Example:
# 
# Assume that words.txt has the following content:
# 
# 
# the day is sunny the the
# the sunny is is
# 
# 
# Your script should output the following, sorted by descending frequency:
# 
# 
# the 4
# is 3
# sunny 2
# day 1
# 
# 
# Note:
# 
# 
# Don't worry about handling ties, it is guaranteed that each word's frequency
# count is unique.
# Could you write it in one-line using Unix pipes?
# 
# 
#

# @lc code=start
# Read from the file words.txt and output the word frequency list to stdout.
grep -oE [a-z]+ words.txt | sort | uniq -c | sort -nr | awk '{print $2 " " $1}'
# @lc code=end

