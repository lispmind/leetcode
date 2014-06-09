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
        if (head == null) {
            return head;
        }

        ListNode sentinelHead = new ListNode(0);
        sentinelHead.next = head;

        boolean duplicated = false;
        ListNode currentSentinel = sentinelHead;
        ListNode pre = head;
        for (ListNode cur = head.next; cur != null;) {
            if (cur.val == pre.val) {
                duplicated = true;
                currentSentinel.next = cur;
            } else {
                if (duplicated) {
                    currentSentinel.next = cur;
                } else {
                    currentSentinel = currentSentinel.next;
                }
                duplicated = false;
            }
            pre = cur;
            cur = cur.next;
        }
        if (duplicated) {
            currentSentinel.next = null;
        }
        return sentinelHead.next;
    }
}
