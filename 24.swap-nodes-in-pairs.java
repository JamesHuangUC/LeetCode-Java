/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (44.33%)
 * Likes:    1111
 * Dislikes: 101
 * Total Accepted:    313.1K
 * Total Submissions: 701.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;

        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next;
            pre.next = temp.next;
            temp.next = temp.next.next;
            pre.next.next = temp;

            pre = pre.next.next;
        }
        return res.next;
    }
}

