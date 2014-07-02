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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        for (ListNode cur = temp; cur.next != null && cur.next.next != null; cur = cur.next.next) {
            cur.next = swap(cur.next, cur.next.next);
        }
        return temp.next;
    }

    private ListNode swap(ListNode first, ListNode second) {
        first.next = second.next;
        second.next = first;
        return second;
    }
}
