/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (34.14%)
 * Likes:    2435
 * Dislikes: 158
 * Total Accepted:    387K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
//     ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if (l1 == null)
//             return l2;
//         if (l2 == null)
//             return l1;
//         if (l1.val < l2.val) {
//             l1.next = mergeTwoLists(l1.next, l2);
//             return l1;
//         } else {
//             l2.next = mergeTwoLists(l1, l2.next);
//             return l2;
//         }
//     }

//     public ListNode mergeKLists(ListNode[] lists) {
//         int n = lists.length;
//         if (n < 1)
//             return null;
//         if (n == 1)
//             return lists[0];
//         while (n >= 2) {
//             int mid = (n + 1) / 2;
//             for (int i = 0; i < n / 2; i++) {
//                 lists[i] = mergeTwoLists(lists[i], lists[i + mid]);
//             }
//             n = mid;
//         }
//         return lists[0];
//     }
// }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode lst : lists) {
            if (lst != null) {
                queue.offer(lst);
            }
        }

        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }
        return res.next;
    }
}

