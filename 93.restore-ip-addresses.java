/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (31.28%)
 * Likes:    719
 * Dislikes: 297
 * Total Accepted:    146.8K
 * Total Submissions: 458.4K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    void helper(String s, List<String> res, String cur, int field) {
        if (field == 4 && s.length() == 0) {
            res.add(cur.substring(1));
        } else if (field == 4 || s.length() == 0) {
            return;
        } else {
            helper(s.substring(1), res, cur+"."+s.substring(0, 1), field+1);
            if (s.charAt(0) != '0' && s.length() >= 2) {
                helper(s.substring(2), res, cur+"."+s.substring(0, 2), field+1);
            }
            if (s.charAt(0) != '0' && s.length() >= 3 && Integer.valueOf(s.substring(0, 3)) <= 255) {
                helper(s.substring(3), res, cur+"."+s.substring(0, 3), field+1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) return res;
        helper(s, res, "", 0);
        return res;
    }
}

