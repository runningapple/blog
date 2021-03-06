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
        if (head == null || head.next == null) return head;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode current = result;
        ListNode first = null, second = null;
        while (current.next != null && current.next.next != null) {
            first = current.next;
            second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return result.next;
    }
}