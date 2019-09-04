/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 *
 * https://leetcode.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (18.40%)
 * Likes:    1139
 * Dislikes: 200
 * Total Accepted:    133.7K
 * Total Submissions: 714.8K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such
 * that:
 * 
 * 
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: []
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    HashSet<String> doneSet = new HashSet<String>();
    HashMap<String, Integer> deepsMap = new HashMap<String, Integer>();

    public void buildMap(List<String> wordList, String beginWord) {
        HashSet<String> wordSet = new HashSet<String>();
        for (String str : wordList) {
            wordSet.add(str);
        }
        wordSet.add(beginWord);
        for (String str : wordSet) {
            map.put(str, new LinkedList<String>());
            diff(str, wordSet);
        }
    }

    public void diff(String s, HashSet<String> wordSet) {
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            char curr = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (curr != c) {
                    sb.setCharAt(i, c);
                    if (wordSet.contains(sb.toString())) {
                        map.get(s).add(sb.toString());
                    }
                }
            }
        }
    }

    public int bfs(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        doneSet.add(beginWord);
        deepsMap.put(beginWord, 0);
        int steps = 1;
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return steps;
                if (map.containsKey(curr)) {
                    List<String> nxtStrList = map.get(curr);
                    for (String nxtStr : nxtStrList) {
                        if (!deepsMap.containsKey(nxtStr)) {
                            queue.offer(nxtStr);
                            deepsMap.put(nxtStr, steps);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    public void DFS(LinkedList<String> currList, List<List<String>> results, String target, int minLength,
            int currDeep) {
        String currString = currList.get(0);
        if (currList.size() > minLength) return;
        else if (currList.size() == minLength) {
            if (currString.equals(target)) {
                results.add(new LinkedList<String>(currList));
            }
        } else {
            for (String str : map.get(currString)) {
                if (!doneSet.contains(str) && deepsMap.containsKey(str) && deepsMap.get(str) + currDeep < minLength) {
                    currList.addFirst(str);
                    doneSet.add(str);
                    DFS(currList, results, target, minLength, currDeep + 1);
                    doneSet.remove(str);
                    currList.removeFirst();
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        buildMap(wordList, beginWord);
        int minLength = bfs(beginWord, endWord, wordList);
        doneSet.clear();
        LinkedList<String> currList = new LinkedList<String>();
        List<List<String>> results = new LinkedList<List<String>>();
        currList.add(endWord);
        doneSet.add(endWord);
        DFS(currList, results, beginWord, minLength, 1);
        return results;
    }
}
