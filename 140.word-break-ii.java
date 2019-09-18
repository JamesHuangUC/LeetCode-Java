/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (27.88%)
 * Likes:    1164
 * Dislikes: 269
 * Total Accepted:    174.4K
 * Total Submissions: 617.9K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 */
class Solution {
    Map<String, List<String>> hm = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (hm.containsKey(s)) return hm.get(s);
        if (s.equals("")) return Arrays.asList(s);
        List<String> res = new ArrayList<>();

        for (String word : wordDict) {
            int wordLen = word.length();
            if (wordLen > s.length() || !s.substring(0, wordLen).equals(word)) continue;

            List<String> remain = wordBreak(s.substring(wordLen), wordDict);
            for (String str : remain) {
                res.add(word + (str.equals("") ? "" : " ") + str);
            }
        }

        hm.put(s, res);
        return res;
    }
}

