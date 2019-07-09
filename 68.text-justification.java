/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 *
 * https://leetcode.com/problems/text-justification/description/
 *
 * algorithms
 * Hard (23.10%)
 * Likes:    374
 * Dislikes: 1048
 * Total Accepted:    99.7K
 * Total Submissions: 421.7K
 * Testcase Example:  '["This", "is", "an", "example", "of", "text", "justification."]\n16'
 *
 * Given an array of words and a width maxWidth, format the text such that each
 * line has exactly maxWidth characters and is fully (left and right)
 * justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * Note:
 * 
 * 
 * A word is defined as a character sequence consisting of non-space characters
 * only.
 * Each word's length is guaranteed to be greater than 0 and not exceed
 * maxWidth.
 * The input array words contains at least one word.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall
 * be",
 * because the last line must be left-justified instead of fully-justified.
 * ⁠            Note that the second line is also left-justified becase it
 * contains only one word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * words =
 * ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * ⁠ "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * 
 * 
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) return res;

        List<String> list = new ArrayList<>();
        list.add(words[0]);
        int len = words[0].length();
        for (int i = 1; i < words.length; i++) {
            if (len + 1 + words[i].length() <= maxWidth) {
                len = len + 1 + words[i].length();
                list.add(words[i]);
            } else {
                even(res, list, maxWidth, len);
                list = new ArrayList<>();
                list.add(words[i]);
                len = words[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size()-1) {
                sb.append(" ");
            }
        }
        for (int i = 0; i < maxWidth - len; i++) {
            sb.append(" ");
        }
        res.add(sb.toString());
        return res;
    }

    void even(List<String> res, List<String> list, int maxWidth, int len) {
        int num = list.size(), blankNum = maxWidth - len;
        int[] count = new int[num-1];
        StringBuilder sb = new StringBuilder();
        if (num == 1) {
            sb.append(list.get(0));
            for (int i = 0; i < blankNum; i++) {
                sb.append(" ");
            }
            res.add(sb.toString());
            return;
        }
        int base = blankNum / (num - 1), rest = blankNum % (num - 1);
        for (int i = 0; i < num-1; i++) {
            count[i] = base;
            if (rest > 0) {
                count[i] += 1;
                rest -= 1;
            }
        }
        for (int i = 0; i < num; i++) {
            sb.append(list.get(i));
            if (i == num - 1) continue;
            for (int j = 0; j < count[i] + 1; j++) {
                sb.append(" ");
            }
        }
        res.add(sb.toString());
    }
}

