/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (32.82%)
 * Likes:    921
 * Dislikes: 79
 * Total Accepted:    190.4K
 * Total Submissions: 567.7K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode resCur = dummy;
        
        while (cur != null) {
            if ((pre == dummy || pre.val != cur.val) && (cur.next == null || cur.val != cur.next.val)) {
                resCur.next = cur;
                resCur = resCur.next;
            }
            pre = cur;
            cur = cur.next;
            pre.next = null; // [1, 2, 2], expected answer [1]
        }

        return dummy.next;
    }
}

