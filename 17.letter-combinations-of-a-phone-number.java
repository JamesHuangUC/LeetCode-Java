/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (41.30%)
 * Likes:    2121
 * Dislikes: 287
 * Total Accepted:    384.3K
 * Total Submissions: 927.9K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() < 1)
            return res;
        StringBuilder temp = new StringBuilder();
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        dfs(digits, 0, hm, temp, res);
        return res;
    }

    void dfs(String digits, int level, HashMap<Character, String> hm, StringBuilder temp, List<String> res) {
        if (level == digits.length()) {
            res.add(temp.toString());
            return;
        }

        String str = hm.get(digits.charAt(level));
        for (char ch : str.toCharArray()) {
            temp.append(ch);
            dfs(digits, level + 1, hm, temp, res);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}

