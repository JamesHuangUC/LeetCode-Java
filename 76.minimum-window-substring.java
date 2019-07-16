/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (30.56%)
 * Likes:    2446
 * Dislikes: 163
 * Total Accepted:    250.9K
 * Total Submissions: 801.9K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 * 
 */
class Solution {
    int findNextValidIdx(int start, String s, int[] tArr) {
        while (start < s.length()) {
            char c = s.charAt(start);
            if (tArr[c] != 0) return start;
            start += 1;
        }
        return start;
    }

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        
        String res = "";
        int matchCount = 0;
        int[] tArr = new int[256];
        for (char c: t.toCharArray()) {
            tArr[c] += 1;
        }

        int[] sArr = new int[256];
        int left = findNextValidIdx(0, s, tArr);
        if (left == s.length()) return "";
        int right = left;
        while (right < s.length()) {
            int rightChar = s.charAt(right);
            if (sArr[rightChar] < tArr[rightChar]) {
                matchCount += 1;
            }
            sArr[rightChar] += 1;

            while (left < s.length() && matchCount == t.length()) {
                if (res.isEmpty() || res.length() > right - left + 1) {
                    res = s.substring(left, right+1);
                }
                int leftChar = s.charAt(left);
                if (sArr[leftChar] <= tArr[leftChar]) {
                    matchCount -= 1;
                }
                sArr[leftChar] -= 1;
                left = findNextValidIdx(left+1, s, tArr);
            }

            right = findNextValidIdx(right+1, s, tArr);
        }

        return res;
    }
}

