/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (23.48%)
 * Likes:    516
 * Dislikes: 880
 * Total Accepted:    133.1K
 * Total Submissions: 564K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * Output: []
 * 
 * 
 */
// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> res = new ArrayList<>();
//         if (s.length() == 0 || words.length == 0)
//             return res;
//         HashMap<String, Integer> hm = new HashMap<>();
//         for (String str : words) {
//             hm.put(str, hm.getOrDefault(str, 0) + 1);
//         }
//         int strLen = s.length();
//         int wordArrLen = words.length;
//         int wordLen = words[0].length();
//         for (int i = 0; i <= strLen - wordArrLen * wordLen; i++) {
//             int tempInd = i;
//             HashMap<String, Integer> tempHm = new HashMap<>(hm);

//             while (tempInd + wordLen <= i + wordArrLen * wordLen) {
//                 String tempWord = s.substring(tempInd, tempInd + wordLen);
//                 if (!tempHm.containsKey(tempWord)) {
//                     break;
//                 }
//                 tempHm.put(tempWord, tempHm.get(tempWord) - 1);
//                 if (tempHm.get(tempWord) == 0) {
//                     tempHm.remove(tempWord);
//                 }
//                 if (tempHm.isEmpty()) {
//                     res.add(i);
//                 }
//                 tempInd += wordLen;
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0)
            return res;
        HashMap<String, Integer> hm = new HashMap<>();
        for (String str : words) {
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            int tempInd = i;
            int count = 0;
            int left = i;
            HashMap<String, Integer> tempHm = new HashMap<>();
            for (tempInd = i; tempInd <= s.length() - wordLen; tempInd += wordLen) {
                String tempStr = s.substring(tempInd, tempInd + wordLen);
                if (hm.containsKey(tempStr)) {
                    tempHm.put(tempStr, tempHm.getOrDefault(tempStr, 0) + 1);

                    if (tempHm.get(tempStr) <= hm.get(tempStr)) {
                        count += 1;
                    } else {
                        while (tempHm.get(tempStr) > hm.get(tempStr)) {
                            String first = s.substring(left, left + wordLen);
                            tempHm.put(first, tempHm.get(first) - 1);
                            if (tempHm.get(first) < hm.get(first)) {
                                count -= 1;
                            }
                            left += wordLen;
                        }
                    }
                    if (count == words.length) {
                        res.add(left);
                        String tempFirst = s.substring(left, left + wordLen);
                        tempHm.put(tempFirst, tempHm.get(tempFirst) - 1);
                        if (tempHm.get(tempFirst) < 1)
                            tempHm.remove(tempFirst);
                        count -= 1;
                        left += wordLen;
                    }
                } else {
                    tempHm.clear();
                    count = 0;
                    left = tempInd + wordLen;
                }
            }
        }

        return res;
    }
}

