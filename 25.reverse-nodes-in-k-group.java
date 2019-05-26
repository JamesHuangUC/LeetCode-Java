/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (36.17%)
 * Likes:    1152
 * Dislikes: 244
 * Total Accepted:    183.4K
 * Total Submissions: 504K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes in the end should remain as it is.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
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
// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         ListNode dummy = new ListNode(-1);
//         dummy.next = head;
//         ListNode cur = dummy;
//         ListNode nex = dummy.next;
//         Stack<ListNode> st = new Stack<>();

//         while (nex != null) {
//             for (int i = 0; nex != null && i < k; i++) {
//                 st.push(nex);
//                 nex = nex.next;
//             }
//             if (st.size() < k) return dummy.next;
//             for (int i = 0; i < k; i++) {
//                 cur.next = st.pop();
//                 cur = cur.next;
//             }
//             cur.next = nex;
//         }

//         return dummy.next;
//     }
// }

class Solution {
    ListNode reverseKNodes(ListNode pre, int k) {
        ListNode last = pre;
        for (int i = 0; i < k+1; i++) {
            last = last.next;
            if (last == null && i != k) {
                return null;
            }
        }

        ListNode tail = pre.next;
        ListNode cur = pre.next.next;
        while (cur != last) {
            ListNode nex = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            tail.next = nex;
            cur = nex;
        }

        return tail;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null) {
            pre = reverseKNodes(pre, k);
        }

        return dummy.next;
    }
}

