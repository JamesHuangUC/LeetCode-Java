/*
 * @lc app=leetcode id=170 lang=java
 *
 * [170] Two Sum III - Data structure design
 *
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
 *
 * algorithms
 * Easy (31.68%)
 * Likes:    214
 * Dislikes: 185
 * Total Accepted:    66.4K
 * Total Submissions: 209.4K
 * Testcase Example:  '["TwoSum","add","add","add","find","find"]\n[[],[1],[3],[5],[4],[7]]'
 *
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 * 
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the
 * value.
 * 
 * Example 1:
 * 
 * 
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 
 * 
 * Example 2:
 * 
 * 
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 * 
 */

// @lc code=start
class TwoSum {
    Map<Integer, Integer> hm;

    /** Initialize your data structure here. */
    public TwoSum() {
        hm = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        hm.put(number, hm.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num: hm.keySet()) {
            int target = value - num;
            if (hm.containsKey(target)) {
                if (num == target && hm.get(num) == 1) {
                    continue;
                }
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
// @lc code=end

