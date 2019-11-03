/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 *
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (37.21%)
 * Likes:    531
 * Dislikes: 212
 * Total Accepted:    139.5K
 * Total Submissions: 374.9K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and
 * T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * Example:
 * 
 * 
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 9) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String curStr = s.substring(i, i+10);
            if (set.contains(curStr)) {
                res.add(curStr);
            } else {
                set.add(curStr);
            }
        }

        return new ArrayList<String>(res);
    }
}
// @lc code=end

