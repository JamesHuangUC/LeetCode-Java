/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (37.01%)
 * Likes:    736
 * Dislikes: 196
 * Total Accepted:    171.3K
 * Total Submissions: 452.3K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1);
        ListNode left = dummy;
        ListNode pre = dummy;
        dummy.next = head;
        ListNode cur = head;

        while (cur != null) {
            if (pre == left) {
                if (cur.val < x) left = left.next;
                pre = cur;
                cur = cur.next;
            } else {
                if (cur.val >= x) {
                    pre = cur;
                    cur = cur.next;
                } else {
                    pre.next = cur.next;
                    cur.next = left.next;
                    left.next = cur;

                    left = left.next;
                    cur = pre.next;
                }
            }
        }

        return dummy.next;
    }
}

