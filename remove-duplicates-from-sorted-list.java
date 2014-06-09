/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        for (ListNode cur = head.next; cur != null; cur = cur.next) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
        }
        return head;
    }
}