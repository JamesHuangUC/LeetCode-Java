/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (31.76%)
 * Likes:    1095
 * Dislikes: 80
 * Total Accepted:    172.3K
 * Total Submissions: 532.4K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if (head == null) return;

        Stack<ListNode> st = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            st.push(cur);
            cur = cur.next;
        }

        cur = head;
        int n = (st.size() - 1) / 2;
        while (n-- > 0) {
            ListNode next = cur.next;
            ListNode popNode = st.pop();
            cur.next = popNode;
            popNode.next = next;
            cur = next;
        }
        st.peek().next = null;
    }
}

